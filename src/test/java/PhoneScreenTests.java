import org.junit.Assert;
import org.junit.Test;

import screens.PhoneScreen;

public class PhoneScreenTests extends BaseTest {

    @Test
    public void checkUI() {
        PhoneScreen phone = new PhoneScreen(driver, wait);
        phone.waitLoaded();
        Assert.assertTrue(phone.screenIsValid());
    }
}
