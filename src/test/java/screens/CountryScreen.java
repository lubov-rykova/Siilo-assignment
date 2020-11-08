package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CountryScreen extends BaseScreen {

    public static final String SEARCH = "search_input";
    public static final String COUNTRY_CODE_31 = "+31";

    public CountryScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(SEARCH);
    }

    public void submit(String code) {
        super.clickByText(code);
    }
}
