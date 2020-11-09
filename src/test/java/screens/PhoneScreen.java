package screens;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PhoneScreen extends BaseScreen {

    public static final String PHONE = "reg_phonenumber";
    public static final String COUNTRY = "reg_country_text";
    public static final String CONTENT = "regflow_phone_text1";

    public static final String CONTENT_TEXT = "Let's continue with the next step: verifying your phone number. \uD83D\uDCF1";
    public static final String COUNTRY_TEXT = "Select country";
    public static final String PHONE_TEXT = "Phone number";


    public PhoneScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(PHONE);
    }

    public void waitNotLoaded() {
        super.waitNotLoadedById(PHONE);
    }

    public void openCountryList() {
        driver.hideKeyboard();
        super.clickById(COUNTRY);
    }

    public void submit(String number) {
        super.inputText(PHONE, number);
        driver.hideKeyboard();
        super.clickById(BUTTON_DONE);
    }

    public Boolean screenIsValid() {
        driver.hideKeyboard();
        try {
            MobileElement content = elementById(CONTENT);
            if (!content.isDisplayed() || !content.getText().equals(CONTENT_TEXT)) {
                return false;
            }

            MobileElement country = elementById(COUNTRY);
           if (!country.isDisplayed()) {
               return false;
           }

            MobileElement phone = elementById(PHONE);
            if (!phone.isDisplayed()) {
                return false;
            }

            MobileElement button = elementById(BaseScreen.BUTTON_DONE);
            if (!button.isDisplayed() || !button.getText().equals(BaseScreen.BUTTON_DONE_TEXT)) {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public MobileElement getCountry() {
        return elementById(COUNTRY);
    }

    public MobileElement getPhone() {
        return elementById(PHONE);
    }
}
