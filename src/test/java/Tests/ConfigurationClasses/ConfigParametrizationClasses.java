package Tests.ConfigurationClasses;

import static com.codeborne.selenide.Configuration.*;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class ConfigParametrizationClasses {

    @BeforeTest
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        timeout=15000;

        screenshots=true;
        savePageSource = false;
        reportsFolder="src/main/resources/Reports/FailedTests";
    }

    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
