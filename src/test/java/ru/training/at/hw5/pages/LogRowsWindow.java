package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class LogRowsWindow extends PageTestBase {

    public LogRowsWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(., 'Water') and contains(., 'true')]")
    public WebElement waterLog;

    @FindBy(xpath = "//li[contains(., 'Wind') and contains(., 'true')]")
    public WebElement windLog;

    @FindBy(xpath = "//li[contains(., 'metal') and contains(., 'Selen')]")
    public WebElement selenLog;

    @FindBy(xpath = "//li[contains(., 'Colors') and contains(., 'Yellow')]")
    public WebElement yellowLog;

    @FindBy(xpath = "//li[contains(., 'Vip') and contains(., 'true')]")
    public WebElement vipLog;

    public void checkLogExistence(WebElement webElement) {
        assertTrue(webElement.isDisplayed());
    }
}
