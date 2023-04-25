package by.teachmeskills.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class WritingPage extends BasePage {
    public static final By ICON_HOME = By.xpath("//i[contains(@class, 'icon-home')]");
    public static final String ENTRY_TEXT = "input text";
    private By ENTRY_FIELD = By.id("editable");
    private By SELECT = By.xpath("//input[@title='Select all']");
    private By DELETE = By.xpath("//i[@class='icon-trash']");

    public WritingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ICON_HOME));
        return driver.findElement(ICON_HOME).isDisplayed();
    }

    public WorkingPage writeNote(String inputText) {
        driver.findElement(ENTRY_FIELD).sendKeys(inputText);
        driver.findElement(ICON_HOME).click();
        return new WorkingPage(driver);

    }

    public void deleteNote() {
        driver.findElement(SELECT).click();
        driver.findElement(DELETE).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}



