package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class VerificationCodeScreen extends BaseScreen {

    public static final String CODE = "reg_verification_code";

    public VerificationCodeScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(CODE);
    }

    public void submit(String code) {
        super.inputText(CODE, code);
        driver.hideKeyboard();
        super.clickById(BUTTON_DONE);
    }
}
