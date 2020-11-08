import org.junit.Test;

import screens.AgreementScreen;
import screens.EmailScreen;
import screens.ProfessionScreen;
import screens.ProfileScreen;
import screens.StartScreen;

public class E2ERegistrationTests extends BaseTest {

    @Test
    public void startActivity() {
        StartScreen start = new StartScreen(driver, wait);
        start.waitLoaded();
        start.click(StartScreen.NEW_USER);

        AgreementScreen agreement = new AgreementScreen(driver, wait);
        agreement.waitLoaded();
        agreement.click(AgreementScreen.ACCEPT_AGREEMENT);

        ProfileScreen profile = new ProfileScreen(driver, wait);
        profile.waitLoaded();
        profile.submitCredentials("Rick", "Sanchez");

        ProfessionScreen profession = new ProfessionScreen(driver, wait);
        profession.waitLoaded();
        profession.click(ProfessionScreen.PHYSICIAN);

        EmailScreen email = new EmailScreen(driver, wait);
        email.waitLoaded();
        email.submitEmail("ricksanchez@mail.ru");
    }
}