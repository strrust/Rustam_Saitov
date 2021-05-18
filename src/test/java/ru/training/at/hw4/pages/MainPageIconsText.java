package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class MainPageIconsText {
    public WebDriver driver;

    public MainPageIconsText(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='benefit']/span[contains(., 'To include')]")
    public WebElement practiseIconText;

    @FindBy(xpath = "//div[@class='benefit']/span[contains(., 'To be flex')]")
    public WebElement customIconText;

    @FindBy(xpath = "//div[@class='benefit']/span[contains(., 'To be mult')]")
    public WebElement multiIconText;

    @FindBy(xpath = "//div[@class='benefit']/span[contains(., 'Alread')]")
    public WebElement baseIconText;

    public void checkIconsTextIsDisplayed(WebElement webElement) {
        webElement.isDisplayed();
    }

    public void checkIconsTextValues(WebElement webElement, String text) {
        assertEquals(webElement.getText(), text);
    }
}
