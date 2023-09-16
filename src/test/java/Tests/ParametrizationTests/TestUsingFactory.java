package Tests.ParametrizationTests;

import Tests.ConfigurationClasses.ConfigParametrizationClasses;
import Tests.TestUtils.TestForParametrization;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestUsingFactory extends ConfigParametrizationClasses {

    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;

    public TestUsingFactory(String firstName, String lastName, String gender, String phoneNumber){

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Test
    public void testUsingFactory(){
        TestForParametrization.parametrizedFormTest(firstName, lastName, gender, phoneNumber);
    }

    @Factory
    public static Object[] factoryMethod(){
        return new Object[]{new TestUsingFactory("Rick", "Sanchez", "Male", "1371371371"),
                new TestUsingFactory("Beth", "Smith", "Female", "1311311311"),
                new TestUsingFactory("Gar", "Gloonch", "Other", "1234567890")};
    }
}
