import org.junit.Test;

import screens.AgreementScreen;
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

public class E2ERegistrationTests extends BaseTest {

    @Test
    public void startActivity() throws Exception {
        StartScreen start = new StartScreen(driver, wait);
        start.waitLoaded();
        start.newUser();

        AgreementScreen agreement = new AgreementScreen(driver, wait);
        agreement.waitLoaded();
        agreement.accept();

        ProfileScreen profile = new ProfileScreen(driver, wait);
        profile.waitLoaded();
        profile.submit("Rick", "Sanchez");

        ProfessionScreen profession = new ProfessionScreen(driver, wait);
        profession.waitLoaded();
        profession.chooseProfession(ProfessionScreen.PHYSICIAN);

        EmailScreen email = new EmailScreen(driver, wait);
        email.waitLoaded();
        email.submit("ricksanchez@mail.ru");

        ConfirmationEmailScreen confirm = new ConfirmationEmailScreen(driver, wait);
        confirm.waitLoaded();
        confirm.submit();

        PhoneScreen phone = new PhoneScreen(driver, wait);
        phone.waitLoaded();
        phone.openCountryList();

        CountryScreen country = new CountryScreen(driver, wait);
        country.waitLoaded();
        country.submit(CountryScreen.CODE_31);

        phone.waitLoaded();
        phone.submit("1111111111");

        VerificationCodeScreen verificationCode = new VerificationCodeScreen(driver, wait);
        verificationCode.waitLoaded();
        verificationCode.submit("12345");

        NotificationScreen notification = new NotificationScreen(driver, wait);
        notification.waitLoaded();
        notification.submit(NotificationScreen.PRIVATE);

        SuccessScreen success = new SuccessScreen(driver, wait);
        success.waitLoaded();
    }
}