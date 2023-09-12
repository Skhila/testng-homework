import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTests extends ConfigTests{
//    Set baseUrl and reportsFolder for current class tests
    @BeforeClass
    public void configTestClass(){
        reportsFolder = "src/main/resources/Reports/RadioButtonFailedTests";
        baseUrl = " https://demoqa.com";
    }

    @Test
    public void radioButtonTest(){
        open("/radio-button");

//        I don't know why, but finding yesRadioButton with id was impossible (Invalid element state [#yesRadio]: element click intercepted)
        SelenideElement yesRadioButton = $("label[for='yesRadio']");
        SelenideElement noRadioButton = $("#noRadio");

        TestUtils.checkYesRadio(yesRadioButton);
        softAssert.fail("\n(1) RadioButton Invoked soft assertion!\n");

        TestUtils.checkNoOptionAvailability(noRadioButton, softAssert);

        softAssert.assertAll();
    }
}
