package Tests.ParametrizationTests;

import Tests.ConfigurationClasses.ConfigParametrizationClasses;
import Tests.TestUtils.TestForParametrization;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestUsingParameters extends ConfigParametrizationClasses {

    @Test
    @Parameters({"firstName", "lastName", "gender", "phoneNumber"})
    public void testUsingParameters(String firstName, String lastName, String gender, String phoneNumber){
        TestForParametrization.parametrizedFormTest(firstName, lastName, gender, phoneNumber);
    }
}
