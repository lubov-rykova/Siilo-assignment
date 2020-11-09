import org.junit.Test;

import screens.CountryScreen;

public class E2ERegistrationTests extends BaseTest {

    @Test
    public void registrationHappyPath() {
        navigator.countryCode = CountryScreen.CODE_31;
        while (navigator.next() != null);
    }
}