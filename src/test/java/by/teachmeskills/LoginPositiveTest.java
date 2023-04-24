package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.WorkingPage;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LoginPositiveTest extends BaseTest {

    @Test
    public void LoginAsStandardUser() {
        WorkingPage workingPage = new LoginPage(driver).open()
                .loginAsStandardUser();
        assertThat(workingPage.isOpened())
                .isTrue()
                .as("Working page should be opened after user logged in with valid credentials");
    }
}

