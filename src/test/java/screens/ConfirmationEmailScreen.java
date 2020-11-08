package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ConfirmationEmailScreen extends BaseScreen {

    public static final String CONTENT_TEXT = "Thx! We'll send you an email to verify your email address.";

    public ConfirmationEmailScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedByText(CONTENT_TEXT);
    }

    public void submit() {
        super.clickById(BUTTON_DONE);
    }
}
