import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import screens.AgreementScreen;
import screens.ProfessionScreen;
import screens.ProfileScreen;

public class ProfileScreenTests extends BaseTest{
    protected ProfileScreen profile;

    @Before
    public void setUpScreen() {
        profile = (ProfileScreen) navigator.goToScreen(ProfileScreen.class);
    }

    @Test
    public void checkUI() {
        Assert.assertTrue(profile.screenIsValid());
    }

    @Test
    public void checkNextDisabled() {
        Assert.assertFalse(profile.getSubmitButton().isEnabled());
    }

    @Test
    public void checkFirstNameRequired() {
        profile.getLastName().sendKeys("text");
        Assert.assertFalse(profile.getSubmitButton().isEnabled());
    }

    @Test
    public void checkLastNameRequired() {
        profile.getFirstName().sendKeys("text");
        Assert.assertFalse(profile.getSubmitButton().isEnabled());
    }

    @Test
    public void checkMinimalLength() {
        profile.getFirstName().sendKeys("t");
        profile.getLastName().sendKeys("t");
        Assert.assertTrue(profile.getSubmitButton().isEnabled());
    }

    @Test
    public void checkSpecialSymbols() {
        profile.getFirstName().sendKeys("1~");
        profile.getLastName().sendKeys("2!");
        Assert.assertTrue(profile.getSubmitButton().isEnabled());
    }

    @Test
    public void checkSpaces() {
        profile.getFirstName().sendKeys(" ");
        profile.getLastName().sendKeys(" ");
        Assert.assertFalse(profile.getSubmitButton().isEnabled());
    }

    @Test
    public void checkKeyboardShownFirstName() {
        profile.getFirstName().click();
        Assert.assertTrue(driver.isKeyboardShown());
    }

    @Test
    public void checkKeyboardShownLastName() {
        profile.getLastName().click();
        Assert.assertTrue(driver.isKeyboardShown());
    }

    @Test
    public void checkGoesBackToAgreement() {
        AgreementScreen agreementScreen = new AgreementScreen(driver, wait);
        driver.navigate().back();
        profile.waitNotLoaded();
        agreementScreen.waitLoaded();
    }

    @Test
    public void checkGoesForwardToProfessions() {
        ProfessionScreen professionScreen = new ProfessionScreen(driver, wait);
        profile.submit("test", "test");
        professionScreen.waitLoaded();
    }
}
