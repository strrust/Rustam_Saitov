package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class LeftMenu {
    public WebDriver driver;

    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li[contains(., 'Hom')]/a/span")
    public WebElement homeMenuItem;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li[contains(., 'Cont')]/a/span")
    public WebElement contactMenuItem;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li[contains(., 'Ser')]/a/span")
    public WebElement serviceMenuItem;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li[contains(., 'Met')]/a/span")
    public WebElement metalMenuItem;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li[contains(., 'El')]/a/span")
    public WebElement elementsMenuItem;

    public void checkMenuItemText(WebElement webElement, String text) {
        assertEquals(webElement.getText(), text);
    }
}
