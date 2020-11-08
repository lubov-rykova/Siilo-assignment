package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseScreen {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;

    public static final String BUTTON_DONE = "button_done";

    final protected String BASE_PATH = "com.siilo.android.registration:id/";

    public BaseScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected void clickById(String id) {
        driver.findElement(By.id(BASE_PATH + id)).click();
    }

    protected void clickByText(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    protected void waitLoadedById(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_PATH + id)));
    }

    protected void waitLoadedByText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,\"" + text + "\")]")));
    }

    protected void inputText(String id, String text) {
        driver.findElement(By.id(BASE_PATH + id)).sendKeys(text);
    }


}
