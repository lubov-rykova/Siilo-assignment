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

            //todo replace COUNTRY_TEXT with country name
            MobileElement country = elementById(COUNTRY);
           if (!country.isDisplayed() || !country.getText().equals(COUNTRY_TEXT)) {
               return false;
           }

            MobileElement phone = elementById(PHONE);
            if (!phone.isDisplayed() || !phone.getText().equals(PHONE_TEXT)) {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public String getCountryCode() {
        return elementById(COUNTRY).getText();
    }
}
