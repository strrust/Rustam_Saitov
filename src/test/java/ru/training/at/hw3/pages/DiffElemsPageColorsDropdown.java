package ru.training.at.hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;

public class DiffElemsPageColorsDropdown {
    public WebDriver driver;

    public DiffElemsPageColorsDropdown(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "select.uui-form-element")
    public WebElement dropdownColor;

    public void selectElementFromColors(String text) {
        Select select = new Select(dropdownColor);
        select.selectByVisibleText(text);
    }

    public void selectCheck(String text) {
        Select select = new Select(dropdownColor);
        assertEquals(select.getFirstSelectedOption().getText(), text);
    }
}
