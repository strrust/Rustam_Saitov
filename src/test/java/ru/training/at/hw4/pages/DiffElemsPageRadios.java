package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiffElemsPageRadios {
    public WebDriver driver;

    public DiffElemsPageRadios(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//label[@class='label-radio' and contains(., 'Selen')]/input")
    public WebElement selenRadio;

    public void radioClick(WebElement webElement) {
        webElement.click();
    }

    public void radioIsSelected(WebElement webElement) {
        webElement.isSelected();
    }
}
