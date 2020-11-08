package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PhoneScreen extends BaseScreen {

    public static final String PHONE = "reg_phonenumber";

    public PhoneScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(PHONE);
    }

    public void submit(String number) {
        super.inputText(PHONE, number);
        driver.hideKeyboard();
        super.clickById(BUTTON_DONE);
    }
}
