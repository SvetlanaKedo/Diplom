package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.RegistrationPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NegativeRegisterTest extends BaseTest {

    @DataProvider
    public Object[][] invalidDates() {
        return new Object[][]{
                {"", "753951qazWSX", ""},
                {"", "753951qazWSX", "753951qazWSX"},
                {"", "", ""},
                {"svetlana@mail.ru", "88488845", "123958498"}
        };
    }

    @Test(dataProvider = "invalidDates")
    public void incorrectDates(String Email, String password, String confirmPassword) {
        new LoginPage(driver).open().checkRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver)
                .registerAllFields(Email, password, confirmPassword);
        assertThat(registrationPage.isErrorMessageDisplayed())
                .isTrue().as("Error message is not displayed after invalid data");
    }
}

