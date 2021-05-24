package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiffElemsPageRadios extends PageTestBase {

    public DiffElemsPageRadios(WebDriver driver) {
        super(driver);
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
