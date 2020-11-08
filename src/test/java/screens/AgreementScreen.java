package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AgreementScreen extends BaseScreen {

    public static final String ACCEPT_AGREEMENT = "button_yes_agree";

    public AgreementScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoaded(ACCEPT_AGREEMENT);
    }

}
