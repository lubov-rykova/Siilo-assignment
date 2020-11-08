package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SuccessScreen extends BaseScreen {

    public static final String SUCCESS_TEXT = "Congratulations, you finished the registration flow.";

    public SuccessScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedByText(SUCCESS_TEXT);
    }
}
