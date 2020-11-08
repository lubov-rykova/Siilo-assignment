package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StartScreen extends BaseScreen {

    public static final String NEW_USER = "button_new_user";

    public StartScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(NEW_USER);
    }

    public void newUser() {
        super.clickById(NEW_USER);
    }
}
