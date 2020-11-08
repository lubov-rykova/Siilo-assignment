package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import screens.BaseScreen;

public class StartScreen extends BaseScreen {

    public static final String NEW_USER = "button_new_user";

    public StartScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoaded(NEW_USER);
    }
}
