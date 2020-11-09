import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import screens.AgreementScreen;
import screens.BaseScreen;
import screens.ConfirmationEmailScreen;
import screens.CountryScreen;
import screens.EmailScreen;
import screens.NotificationScreen;
import screens.PhoneScreen;
import screens.ProfessionScreen;
import screens.ProfileScreen;
import screens.StartScreen;
import screens.SuccessScreen;
import screens.VerificationCodeScreen;

public class ScreenNavigator {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public String firstName, lastName, profession, email, countryCode, phone, verificationCode, security;

    private BaseScreen currentScreen;

    public ScreenNavigator(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.firstName = "Rick";
        this.lastName = "Sanchez";
        this.profession = ProfessionScreen.PHYSICIAN;
        this.email = "ricksanchez@mail.ru";
        this.countryCode = null;
        this.phone = "1111111111";
        this.verificationCode = "12345";
        this.security = NotificationScreen.PRIVATE;
    }

    public BaseScreen next() {
        if (currentScreen == null) {
            currentScreen = new StartScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof StartScreen) {
            StartScreen screen = (StartScreen) currentScreen;
            screen.newUser();
            currentScreen = new AgreementScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof AgreementScreen) {
            AgreementScreen screen = (AgreementScreen) currentScreen;
            screen.accept();
            currentScreen = new ProfileScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof ProfileScreen) {
            ProfileScreen screen = (ProfileScreen) currentScreen;
            screen.submit(firstName, lastName);
            currentScreen = new ProfessionScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof ProfessionScreen) {
            ProfessionScreen screen = (ProfessionScreen) currentScreen;
            screen.chooseProfession(profession);
            currentScreen = new EmailScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof EmailScreen) {
            EmailScreen screen = (EmailScreen) currentScreen;
            screen.submit(email);
            currentScreen = new ConfirmationEmailScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof ConfirmationEmailScreen) {
            ConfirmationEmailScreen screen = (ConfirmationEmailScreen) currentScreen;
            screen.submit();
            currentScreen = new PhoneScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof PhoneScreen) {
            PhoneScreen screen = (PhoneScreen) currentScreen;
            // todo fix after fixing bug with pre-filled country
            if (countryCode != null && screen.getCountryCode().equals(PhoneScreen.COUNTRY_TEXT)) {
                screen.openCountryList();
                currentScreen = new CountryScreen(driver, wait);
            } else {
                screen.submit(phone);
                currentScreen = new VerificationCodeScreen(driver, wait);
            }
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof CountryScreen) {
            CountryScreen screen = (CountryScreen) currentScreen;
            screen.submit(countryCode);
            currentScreen = new PhoneScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof VerificationCodeScreen) {
            VerificationCodeScreen screen = (VerificationCodeScreen) currentScreen;
            screen.submit(verificationCode);
            currentScreen = new NotificationScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof NotificationScreen) {
            NotificationScreen screen = (NotificationScreen) currentScreen;
            screen.submit(security);
            currentScreen = new SuccessScreen(driver, wait);
            currentScreen.waitLoaded();
            return currentScreen;
        }
        if (currentScreen instanceof SuccessScreen) {
            return null;
        }
        return currentScreen;
    }
}
