package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EmailScreen extends BaseScreen {

    public static final String EMAIL = "reg_email";
    public static final String BUTTON_DONE = "button_done";

    public EmailScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoaded(EMAIL);
    }

    public void submitEmail(String email) {
        super.inputText(EMAIL, email);
        super.click(BUTTON_DONE);
    }

}
