import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public ScreenNavigator navigator;

    @Before
    public void setUpDriver() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("deviceName", "Pixel 4 API 28");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformVersion", "9.0");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "com.siilo.android.registration");
        dc.setCapability("appActivity","com.siilo.android.registration.ui.activity.RegistrationActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        wait = new WebDriverWait(driver, 10);
        navigator = new ScreenNavigator(driver, wait);
    }

    @After
    public void tearDownDriver() {
        driver.quit();
    }
}
