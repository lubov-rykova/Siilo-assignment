package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseScreen {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;

    public static final String BUTTON_DONE = "button_done";
    public static final String BUTTON_DONE_TEXT = "Next";

    final protected String BASE_PATH = "com.siilo.android.registration:id/";

    public BaseScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitLoaded() {}


    protected void inputText(String id, String text) {
        driver.findElement(By.id(BASE_PATH + id)).sendKeys(text);
    }

    protected MobileElement elementById(String id) {
        return driver.findElement(By.id(BASE_PATH + id));
    }

    protected void clickByText(String text) {
        String selector = "new UiSelector().textContains(\"" + text + "\")";
        driver.findElementByAndroidUIAutomator(selector).click();
    }

    protected void clickById(String id) {
        String selector = "new UiSelector().resourceId(\"" + BASE_PATH + id + "\")";
        List<MobileElement> all = driver.findElementsByAndroidUIAutomator(selector);
        // Dirty hack: selecting last element because some elements are not identifiable uniquely.
        all.get(all.size() - 1).click();
    }

    protected void waitLoadedById(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_PATH + id)));
    }

    protected void waitLoadedByText(String text) {
        wait.until(ExpectedConditions.visibilityOf(
            driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")")
        ));
    }

    protected void waitNotLoadedById(String id) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(BASE_PATH + id)));
    }
}
