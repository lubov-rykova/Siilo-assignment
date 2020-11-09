package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CountryScreen extends BaseScreen {

    public static final String SEARCH = "search_input";
    public static final String CODE_31 = "+31";
    public static final String COUNTRY_NETHERLANDS = "NETHERLANDS";
    public static final String COUNTRY_LIST = "recycler_view";
    public static final String COUNTRY_TEXT = "country_text";
    public static final String COUNTRY_SEPARATOR = "country_text";


    public CountryScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(SEARCH);
    }

    public void submit(String code) {
        driver.hideKeyboard();
        super.clickByText(code);
    }

    public List<MobileElement> getCommonCountries()  {
        List<MobileElement> result = new ArrayList<>();

        List<MobileElement> all = driver.findElementsByAndroidUIAutomator(
        "new UiSelector().resourceId(\"" + super.BASE_PATH + COUNTRY_LIST + "\").childSelector(new UiSelector())"
        );
        for (MobileElement child : all) {
            try {
                child.findElementsById(super.BASE_PATH + COUNTRY_SEPARATOR);
                break;
            } catch (Exception e) {
                result.add(child.findElementById(super.BASE_PATH + COUNTRY_TEXT));
            }
        }

        return result;
    }
}
