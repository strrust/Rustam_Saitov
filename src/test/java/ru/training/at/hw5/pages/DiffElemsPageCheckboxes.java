package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiffElemsPageCheckboxes extends PageTestBase {

    public DiffElemsPageCheckboxes(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@class='label-checkbox' and contains(., 'Water')]/input")
    public WebElement waterCheckbox;

    @FindBy(xpath = "//label[@class='label-checkbox' and contains(., 'Wind')]/input")
    public WebElement windCheckbox;

    public void checkboxClick(WebElement webElement) {
        webElement.click();
    }

    public void checkboxIsSelected(WebElement webElement) {
        webElement.isSelected();
    }
}
