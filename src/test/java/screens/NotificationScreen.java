package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NotificationScreen extends BaseScreen {

    public static final String PRIVATE = "radio_secure";

    public NotificationScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(PRIVATE);
    }

    public void submit(String type) {
        super.clickById(type);
        super.clickById(BUTTON_DONE);
    }
}
