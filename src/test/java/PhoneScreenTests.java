import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import screens.ConfirmationEmailScreen;
import screens.CountryScreen;
import screens.PhoneScreen;
import screens.VerificationCodeScreen;


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
    public void checkNextDisabled() {
        Assert.assertFalse(phone.getSubmitButton().isEnabled());
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

    @Test
    public void checkGoesForwardToVerification() {
        VerificationCodeScreen verificationScreen = new VerificationCodeScreen(driver, wait);
        phone.submit("1111111111");
        verificationScreen.waitLoaded();
    }

    @Test
    public void checkCommonCountryList() {
        phone.openCountryList();
        CountryScreen country = new CountryScreen(driver, wait);
        country.waitLoaded();

        Assert.assertEquals(0, country.getCommonCountries().size());
    }

    @Test
    public void checkEmptyPhone() {
        phone.getPhone().sendKeys("");
        Assert.assertFalse(phone.getSubmitButton().isEnabled());
    }

    @Test
    public void checkPhoneInput() {
        phone.getPhone().sendKeys("1111111111");
        Assert.assertTrue(phone.getSubmitButton().isEnabled());
    }
}
