package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiffElemsPageCheckboxes {
    public WebDriver driver;

    public DiffElemsPageCheckboxes(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
