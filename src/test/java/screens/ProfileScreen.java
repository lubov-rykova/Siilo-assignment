package screens;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProfileScreen extends BaseScreen {

    public static final String FIRST_NAME = "reg_first_name";
    public static final String LAST_NAME = "reg_last_name";
    public static final String FIRST_NAME_TEXT = "First Name";
    public static final String LAST_NAME_TEXT = "Last Name";
    public static final String CONTENT = "content";
    public static final String CONTENT_TEXT = "What’s your first and last name?";
    public static final String CONTENT_DESCRIPTION = "This is how your colleagues will find you. ✨\uD83D\uDD0D✨";

    public ProfileScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(FIRST_NAME);
    }

    public void waitNotLoaded() {
        super.waitNotLoadedById(FIRST_NAME);
    }

    public void submit(String firstName, String lastName) {
        super.inputText(FIRST_NAME, firstName);
        super.inputText(LAST_NAME, lastName);
        driver.hideKeyboard();
        super.clickById(BUTTON_DONE);
    }

    public Boolean screenIsValid() {
        driver.hideKeyboard();
        try {
            if (!elementById(CONTENT).isDisplayed()) {
                return false;
            }
            if (!elementByText(CONTENT_TEXT).isDisplayed()) {
                return false;
            }
            if (!elementByText(CONTENT_DESCRIPTION).isDisplayed()) {
                return false;
            }
            if (!elementById(FIRST_NAME).isDisplayed()) {
                return false;
            }
            if (!elementById(LAST_NAME).isDisplayed()) {
                return false;
            }

            MobileElement button = elementById(BaseScreen.BUTTON_DONE);
            if (!button.isDisplayed() || !button.getText().equals(BaseScreen.BUTTON_DONE_TEXT)) {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


    public MobileElement getFirstName() {
        return super.elementById(FIRST_NAME);
    }

    public MobileElement getLastName() {
        return super.elementById(LAST_NAME);
    }
}
