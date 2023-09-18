package Tests.TestUtils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;

import javax.swing.text.Element;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestForParametrization {
    public static void parametrizedFormTest(String firstName, String lastName, String gender, String phoneNumber){
        //        Open Url
        open("https://demoqa.com/automation-practice-form");

        $(By.id("firstName")).scrollTo().sendKeys(firstName);
        $(By.id("lastName")).scrollTo().sendKeys(lastName);

//        I was able to click this element with jsExecutor only (otherwise it throws element click intercepted exception)
        executeJavaScript("arguments[0].scrollIntoView(); " +
                "arguments[0].click()", $("[name='gender'][value='"+gender+"']"));
        $(By.id("userNumber")).scrollTo().sendKeys(phoneNumber);

//        Same case here, submit button is behind footer, so either footer should be removed, or we have to click the button using jsExecutor
        executeJavaScript("arguments[0].scrollIntoView(); " +
                "arguments[0].click()", $(By.id("submit")));

//        Locate table rows and columns and make lists
        SelenideElement submitTable = $(".table-responsive table");

        ElementsCollection rows = submitTable.$$("tbody tr");
        ElementsCollection columns = submitTable.$$("th");

        List<String> headers = columns.texts();

        int indexOfLabel = headers.indexOf("Label");
        int indexOfValues = headers.indexOf("Values");

        int rowSize = rows.size();

//        Create HashMap to store student's information, Labels and Values
        HashMap<String, String> studentInfo = new HashMap<>();

//        Iterate through rows and columns, store information into StudentInfo hashMap
        for(int rowNum = 1; rowNum <= rowSize; rowNum++){

            String studentLabel = submitTable.$(By.xpath(".//tbody/tr[" + rowNum + "]/td[" + (indexOfLabel + 1) + "]")).getText();
            String studentValue = submitTable.$(By.xpath(".//tbody/tr[" + rowNum + "]/td[" + (indexOfValues + 1) + "]")).getText();

            if(!studentLabel.isEmpty()) studentInfo.put(studentLabel, studentValue);
        }

        String userFullName = firstName + " " + lastName;
        Assert.assertEquals(studentInfo.get("Student Name").replace(" ", ""), userFullName.replace(" ", ""));

        System.out.printf("\nStudent: %s registered successfully!\n", userFullName);
    }
}
