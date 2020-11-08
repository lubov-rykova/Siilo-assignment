package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseScreen {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;

    final protected String basePath = "com.siilo.android.registration:id/";

    public BaseScreen(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(String id) {
        driver.findElement(By.id(basePath + id)).click();
    }

    protected void waitLoaded(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(basePath + id)));
    }

    protected void inputText(String id, String text) {
        driver.findElement(By.id(basePath + id)).sendKeys(text);
    }
}
