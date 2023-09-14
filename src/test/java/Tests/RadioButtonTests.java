package Tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Tests.ConfigurationClasses.ConfigTests;
import Tests.TestUtils.TestUtils;

import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTests extends ConfigTests {
    @BeforeClass
    public void configTestClass(){
        reportsFolder = "src/main/resources/Reports/RadioButtonFailedTests";
    }

    @Test(groups = "FrontEnd", priority = 2)
    public void radioButtonTest(){
        open("https://demoqa.com/radio-button");

//        I don't know why, but finding yesRadioButton with id was impossible (Invalid element state [#yesRadio]: element click intercepted)
        SelenideElement yesRadioButton = $("label[for='yesRadio']");
        SelenideElement noRadioButton = $("#noRadio");

        TestUtils.checkYesRadio(yesRadioButton);
        softAssert.fail("\n(1) RadioButton Invoked soft assertion!\n");

        TestUtils.checkNoOptionAvailability(noRadioButton, softAssert);

        softAssert.assertAll();
    }

    @Test(groups = "BackEnd", priority = 1)
    public void radioButtonTestSecond(){
        System.out.println("(Radio Button) Successful Test!");
    }
}
