package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class WorkingPage extends BasePage {

    private By DELETE_AN_ENTRY_BUTTON = By.id("delete-entry");
    private By ENTRY_FIELD = By.id("editable");
    private static final By LOGOUT_BUTTON = By.xpath("//button[contains(@ng-click, 'logout($event)')]");
    private static final By ICON_HOME = By.xpath("//i[contains(@class, 'icon-home')]");
    private static final By ENTRY_TEXT_ON_WORKING_PAGE = By.xpath("//a[contains(@href, '#/entries/3487016')]");
    private static final By CREATE_AN_ENTRY_BUTTON = By.xpath("//i[contains(@class, 'icon-plus')]");
    private static final By ALL_PRODUCTS_NAMES = By.xpath("//a[@class='entry']");
    private By ENTRY_DELETED = By.xpath("//div[@class='none centered']");
    public static final String ENTRY_TEXT = "input text";

    public WorkingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_AN_ENTRY_BUTTON));
        return driver.findElement(CREATE_AN_ENTRY_BUTTON).isDisplayed();
    }

    public LoginPage logOut() {
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }

    public WritingPage createEntry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_AN_ENTRY_BUTTON));
        driver.findElement(CREATE_AN_ENTRY_BUTTON).click();
        return new WritingPage(driver);
    }

    public String getTextEntry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ENTRY_TEXT_ON_WORKING_PAGE));
        return driver.findElement(ENTRY_TEXT_ON_WORKING_PAGE).getText();
    }

    public List<String> getAllNameNotes() {
        return driver.findElements(ALL_PRODUCTS_NAMES)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public boolean isEntryDeleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ENTRY_DELETED));
        return driver.findElement(ENTRY_DELETED).isDisplayed();
    }
}


