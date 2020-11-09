package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CountryScreen extends BaseScreen {

    public static final String SEARCH = "search_input";
    public static final String CODE_31 = "+31";
//    public static final String COUNTRY_LIST = "recycler_view";


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
}
