package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import screens.BaseScreen;

public class ProfileScreen extends BaseScreen {

    public static final String FIRST_NAME = "reg_first_name";
    public static final String LAST_NAME = "reg_last_name";
    public static final String BUTTON_DONE = "button_done";

    public ProfileScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoaded(FIRST_NAME);
    }

    public void submitCredentials(String firstName, String lastName) {
        super.inputText(FIRST_NAME, firstName);
        super.inputText(LAST_NAME, lastName);
        super.click(BUTTON_DONE);
    }
}
