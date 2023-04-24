package by.teachmeskills.page;

import by.teachmeskills.testng.PropertiesLoader;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

@Log4j
public class LoginPage extends BasePage {

    private static final By USER_NAME = By.id("login");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private static final By ERROR_FOR_USER = By.xpath("//label[contains(text(), 'User')]//ancestor::div[contains(@class, 'form-group')]//div[contains(@class, 'help-block')]");
    private static final By ERROR_FOR_PASSWORD = By.xpath("//label[contains(text(), 'Password')]//ancestor::div[contains(@class, 'form-group')]//div[contains(@class, 'help-block')]");
    private static final By ACT_ERROR = By.xpath("//label[contains(text(), 'Password')]//ancestor::div[contains(@class, 'form-group')]//div[contains(@class, 'help-block')]");

    public static final String EXP_ERROR = "Mandatory field";
    private static final String INCORRECT_LOGIN = "fgfgf";
    private static final String INCORRECT_PASSWORD = "8751289562";
    private static final String EMPTY_LOGIN = "";
    private static final String EMPTY_PASSWORD = "";

    private static final By DONATE_BUTTON = By.xpath("//a[contains(@ng-show, 'donationButtonVisible')]");
    ;
    private By ERROR_INVALID_LOGIN = By.xpath("//form[@ng-hide='loggedIn']//div[@ng-show='formStatus']");
    private By ERROR_EMPTY_LOGIN = By.xpath("//label[contains(text(), 'User')]//ancestor::" +
            "div[contains(@class, 'form-group')]//div[contains(@class, 'help-block')]");
    private By ERROR_EMPTY_PASSWORD = By.xpath("//label[contains(text(), 'Password')]//ancestor::" +
            "div[contains(@class, 'form-group')]//div[contains(@class, 'help-block')]");
    public By REGISTER_BTN = By.xpath("//a[@href='/account/registration']");


    private Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        return this;
    }

    public void loginAs(String userName, String password) {
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public WorkingPage loginAsStandardUser() {
        Properties properties = PropertiesLoader.loadProperties();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginAs(username, password);
        log.info("Login as {} , {}", username, password);
        return new WorkingPage(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
    public RegistrationPage checkRegistration() {
        driver.findElement(REGISTER_BTN).click();
        log.info("Registration page is opened ");
        return new RegistrationPage(driver);
    }

    public String getErrorTextUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_FOR_USER));
        return driver.findElement(ERROR_FOR_USER).getText();
    }

    public String getErrorTextPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_FOR_PASSWORD));
        return driver.findElement(ERROR_FOR_PASSWORD).getText();
    }

    public String getErrorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACT_ERROR));
        return driver.findElement(ACT_ERROR).getText();
    }

    public DonatePage donateClick() {
        driver.findElement(DONATE_BUTTON).click();
        return new DonatePage(driver);
    }
    public LoginPage loginWithIncorrectLoginAndPassword() {
        driver.findElement(USER_NAME).sendKeys(INCORRECT_LOGIN);
        driver.findElement(PASSWORD).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithEmptyFields() {
        driver.findElement(USER_NAME).sendKeys(EMPTY_LOGIN);
        driver.findElement(PASSWORD).sendKeys(EMPTY_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithIncorrectLoginAndEmptyPassword() {
        driver.findElement(USER_NAME).sendKeys(INCORRECT_LOGIN);
        driver.findElement(PASSWORD).sendKeys(EMPTY_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }
    public String getErrorInvalidUserNameAndInvalidPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_INVALID_LOGIN));
        String actError = driver.findElement(ERROR_INVALID_LOGIN).getText();
        return actError;
    }
    public String getErrorEmptyLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_EMPTY_LOGIN));
        String actError = driver.findElement(ERROR_EMPTY_LOGIN).getText();
        return actError;
    }

    public String getErrorEmptyPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_EMPTY_PASSWORD));
        String actError = driver.findElement(ERROR_EMPTY_PASSWORD).getText();
        return actError;
    }
}


