package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.RegistrationPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveRegisterTest extends BaseTest {

    @Test
    public void registrationWithAllFields() {
        RegistrationPage registrationPage = new LoginPage(driver).open().checkRegistration();
        assertThat(registrationPage.isOpened()).isTrue().as("RegistrationPage don't opened");
        new RegistrationPage(driver).getRegistration();
        boolean openedSuccessfulForm = new RegistrationPage(driver).isOpenedSuccessfulForm();
        assertThat(openedSuccessfulForm).isTrue().as("SuccessfulRegistrationPage has not been opened");
    }
}
