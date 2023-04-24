package by.teachmeskills;


import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.WorkingPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogoutTest extends BaseTest {

    @Test
    public void checkLogOut() {
        new LoginPage(driver).open().loginAsStandardUser().logOut();
        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.isOpened()).as("Logout  doesn't return user on Login page")
                .isTrue();
    }

}






