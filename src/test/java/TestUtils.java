import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.*;

public class TestUtils {
    public static void checkUncheckedCheckbox(ElementsCollection checkboxes){
        ElementsCollection uncheckedCheckboxes = checkboxes.filter(not(selected));
        for (SelenideElement uncheckedCheckbox: uncheckedCheckboxes) {
            uncheckedCheckbox.scrollTo().click();
            System.out.println("Checkbox checked successfully!");
        }
    }

    public static void uncheckCheckedCheckbox(ElementsCollection checkboxes){
        ElementsCollection checkedCheckboxes = checkboxes.filter(selected);
        for (SelenideElement checkedCheckbox: checkedCheckboxes) {
            checkedCheckbox.scrollTo().click();
            System.out.println("Checkbox unchecked successfully!");
        }
    }

    public static void checkYesRadio(SelenideElement yesRadioButton){
        yesRadioButton.shouldHave(text("yes")).scrollTo().click();
        System.out.println("Clicked 'Yes' radio button successfully!");
    }

    public static void checkNoOptionAvailability(SelenideElement noRadioButton, SoftAssert softAssert){
        boolean isNoRadioButtonEnabled = noRadioButton.isEnabled();
        softAssert.assertTrue(isNoRadioButtonEnabled, "\n(2) 'No' option is disabled!\n");
    }
}
