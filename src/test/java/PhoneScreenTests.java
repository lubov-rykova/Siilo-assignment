import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import screens.ConfirmationEmailScreen;
import screens.CountryScreen;
import screens.PhoneScreen;


public class PhoneScreenTests extends BaseTest {
    protected PhoneScreen phone;

    @Before
    public void setUpScreen() {
        phone = (PhoneScreen) navigator.goToScreen(PhoneScreen.class);
    }

    @Test
    public void checkUI() {
        Assert.assertTrue(phone.screenIsValid());
    }

    @Test
    public void checkPrefilledCountryCode() {
        Assert.assertEquals(CountryScreen.CODE_31, phone.getPhone().getText());
    }

    @Test
    public void checkPrefilledCountry() {
        Assert.assertEquals(CountryScreen.COUNTRY_NETHERLANDS, phone.getCountry().getText());
    }

    @Test
    public void checkKeyboardShown() {
        phone.getPhone().click();
        Assert.assertTrue(driver.isKeyboardShown());
    }

    @Test
    public void checkGoesBackToEmail() {
        ConfirmationEmailScreen emailScreen = new ConfirmationEmailScreen(driver, wait);
        driver.navigate().back();
        phone.waitNotLoaded();
        emailScreen.waitLoaded();
    }
}
