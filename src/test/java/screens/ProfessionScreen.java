package screens;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProfessionScreen extends BaseScreen {

    public static final String PHYSICIAN = "profession_item_physician";

    public ProfessionScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitLoaded() {
        super.waitLoadedById(PHYSICIAN);
    }

    public void chooseProfession(String profession) {
        super.clickById(profession);
    }
}
