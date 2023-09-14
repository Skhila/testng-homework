package Tests;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

import Tests.ConfigurationClasses.ConfigTests;
import Tests.TestUtils.TestUtils;

import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxTests extends ConfigTests {
//    Set baseUrl and reportsFolder for current class tests
    @BeforeClass
    public void configTestClass(){
        reportsFolder = "src/main/resources/Reports/CheckBoxFailedTests";
    }

    @Test(groups = "FrontEnd")
    public void checkboxTest(){
        open("https://the-internet.herokuapp.com/checkboxes");

        ElementsCollection checkboxes = $$("[type='checkbox']");

        TestUtils.uncheckCheckedCheckbox(checkboxes);
        softAssert.fail("\n(1) Checkbox Invoked soft assertion!\n");

        TestUtils.checkUncheckedCheckbox(checkboxes);
        softAssert.fail("\n(2) Checkbox Invoked soft assertion!\n");

        softAssert.assertAll();
    }

    @Test(groups = "BackEnd")
    public void checkboxTestSecond(){
        System.out.println("(Checkbox) Successful Test!");
    }
}
