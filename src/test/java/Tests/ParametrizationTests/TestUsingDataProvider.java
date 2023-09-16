package Tests.ParametrizationTests;

import Tests.ConfigurationClasses.ConfigParametrizationClasses;
import Tests.TestUtils.TestForParametrization;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUsingDataProvider extends ConfigParametrizationClasses {

    @Test(dataProvider = "myDataProvider")
    public void testUsingDataProvider(String firstName, String lastName, String gender, String phoneNumber){
        TestForParametrization.parametrizedFormTest(firstName, lastName, gender, phoneNumber);
    }

    @DataProvider(name = "myDataProvider")
    public Object[][] myDataProvider(){
        return new Object[][]{
            {"Rick", "Sanchez", "Male", "1371371371"},
            {"Beth", "Smith", "Female", "1311311311"},
            {"Gar", "Gloonch", "Other", "1234567890"},
        };
    }
}
