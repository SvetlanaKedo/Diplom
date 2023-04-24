package by.teachmeskills.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class RegistrationPage extends BasePage {

    private By LOCATOR_PAGE = By.id("new_registration");
    private By EMAIL = By.id("registration_email");
    private By PASSWORD = By.id("registration_password");
    private By PASSWORD_CONFIRMATION = By.id("registration_password_confirmation");
    private By PASSWORD_HINT = By.id("registration_password_hint");
    private By AGREE_ONE = By.id("registration_terms_of_use");
    private By AGREE_TWO = By.id("registration_lost_password_warning_registered");
    private By OK_BUTTON = By.xpath("//div[@class='btn-text-content']");
    private By ERROR = By.xpath("//div[@class='alert alert-danger']");
    private By SUCCES_PAGE = By.xpath("//div[@class='content-container']");
    public static final String EMAIL_USER = "swr@mail.ru";
    public static final String PASSWORD_USER = "5871839Aa";
    public static final String CONFIRM_PASSWORD_USER = "5871839Aa";
    public static final String PASSWORD_PROMPT = "code";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(LOCATOR_PAGE).isDisplayed();
    }

    public void getRegistration() {
        driver.findElement(EMAIL).sendKeys(EMAIL_USER);
        driver.findElement(PASSWORD).sendKeys(PASSWORD_USER);
        driver.findElement(PASSWORD_CONFIRMATION).sendKeys(CONFIRM_PASSWORD_USER);
        driver.findElement(AGREE_ONE).click();
        driver.findElement(AGREE_TWO).click();
        driver.findElement(OK_BUTTON).click();
    }

    public RegistrationPage registerAllFields(String email, String password, String confirmPassword) {
        driver.findElement(EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(PASSWORD_CONFIRMATION).sendKeys(confirmPassword);
        driver.findElement(AGREE_ONE).click();
        driver.findElement(AGREE_TWO).click();
        driver.findElement(OK_BUTTON).click();
        log.info("Registration : {},{},{}", email, password, confirmPassword);
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR));
        return driver.findElement(ERROR).isDisplayed();
    }
    public boolean isOpenedSuccessfulForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCES_PAGE));
        return driver.findElement(LOCATOR_PAGE).isDisplayed();
    }
}
