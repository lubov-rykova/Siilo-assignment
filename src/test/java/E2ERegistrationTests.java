import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;

import screens.CountryScreen;

public class E2ERegistrationTests extends BaseTest {

    @Test
    public void registrationHappyPath() {
        navigator.countryCode = CountryScreen.CODE_31;
        while (navigator.next() != null);
    }

    @Test
    public void registrationHorizontalHappyPath() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        navigator.countryCode = CountryScreen.CODE_31;
        while (navigator.next() != null);
    }
}