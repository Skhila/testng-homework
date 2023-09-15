package Tests;

import RetryAnalyzer.MyRetryAnalyzer;
import Tests.ConfigurationClasses.ConfigTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.reportsFolder;


public class TestWhichFails extends ConfigTests {

    @BeforeClass
    public void configTestClass(){
        reportsFolder = "src/main/resources/Reports/FailedTests";
    }

    @Test(retryAnalyzer = MyRetryAnalyzer.class)
    public void testFromKvernadzeUniversity(){
        Assert.fail("I've Failed 😭");
    }
}

