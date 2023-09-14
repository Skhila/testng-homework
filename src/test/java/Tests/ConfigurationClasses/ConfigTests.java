package Tests.ConfigurationClasses;

import static com.codeborne.selenide.Configuration.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


public class ConfigTests {
    WebDriver driver;
    protected SoftAssert softAssert;

//    Changed default configuration for all project tests
    @BeforeTest(groups = {"FrontEnd, BackEnd"})
    public void setupForAllTests(){
        reopenBrowserOnFail = false;
        timeout = 18000;
        screenshots = true;
        savePageSource = false;
        System.out.println("1");
    }

//    Start all test methods with new webdriver instances and instantiate testNG SoftAssert
    @BeforeMethod(groups = {"FrontEnd, BackEnd"})
    public void configTestMethods(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

        softAssert = new SoftAssert();
        System.out.println("2");

    }

//    Close webdriver after each test method
    @AfterMethod(groups = {"FrontEnd, BackEnd"})
    public void tearDown(){
        System.out.println("3");

        Selenide.closeWebDriver();
    }
}
