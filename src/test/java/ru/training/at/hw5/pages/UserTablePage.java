package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTablePage extends PageTestBase {

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='user-table']/tbody/tr")
    public List<WebElement> numberTypeDropdowns;

    @FindBy(xpath = "//a[contains(., 'Roman')]")
    public WebElement firstUserName;

    @FindBy(xpath = "//a[contains(., 'Sergey Ivan')]")
    public WebElement secondUserName;

    @FindBy(xpath = "//a[contains(., 'Vladzimir')]")
    public WebElement thirdUserName;

    @FindBy(xpath = "//a[contains(., 'Helen Bennett')]")
    public WebElement fourthUserName;

    @FindBy(xpath = "//a[contains(., 'Yoshi Tannamuri')]")
    public WebElement fifthUserName;

    @FindBy(xpath = "//a[contains(., 'Giovanni Rovelli')]")
    public WebElement sixthUserName;

    @FindBy(id = "roman")
    public WebElement firstUserCheckbox;

    @FindBy(id = "ivan")
    public WebElement secondUserCheckbox;

    @FindBy(id = "vlad")
    public WebElement thirdUserCheckbox;

    @FindBy(id = "helen")
    public WebElement fourthUserCheckbox;

    @FindBy(id = "yoshi")
    public WebElement fifthUserCheckbox;

    @FindBy(id = "gio")
    public WebElement sixthUserCheckbox;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> userCheckboxes;

    @FindBy(xpath = "//span[contains(., 'Wolverine')]")
    public WebElement firstUserDescriptionText;

    @FindBy(xpath = "//span[contains(., 'Spider')]")
    public WebElement secondUserDescriptionText;

    @FindBy(xpath = "//span[contains(., 'Punisher')]")
    public WebElement thirdUserDescriptionText;

    @FindBy(xpath = "//span[contains(., 'Captain')]")
    public WebElement fourthUserDescriptionText;

    @FindBy(xpath = "//span[contains(., 'Cyclope')]")
    public WebElement fifthUserDescriptionText;

    @FindBy(xpath = "//span[contains(., 'Hulk')]")
    public WebElement sixthUserDescriptionText;

    @FindBy(xpath = "//tr[contains(., 'Roman')]/td/select/option")
    public List<WebElement> dropDownValues;

    public void checkNumberTypeDropdownsCount(int count) {
        assertEquals(numberTypeDropdowns.size(), count);
    }

    public void checkCheckboxesCount(int count) {
        assertEquals(userCheckboxes.size(), count);
    }

    public void selectVip(WebElement webElement) {
        webElement.click();
    }

    public void vipIsSelected(WebElement webElement) {
        webElement.isSelected();
    }

    public void checkOptionText(WebElement webElement, String text) {
        assertEquals(webElement.getText(), text);
    }

    public void checkElementDisplayed(WebElement webElement) {
        assertTrue(webElement.isDisplayed());
    }

    public void checkPageTitle() {
        assertEquals(driver.getTitle(), "User Table");
    }
}
