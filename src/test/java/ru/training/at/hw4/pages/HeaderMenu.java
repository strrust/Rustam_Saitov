package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class HeaderMenu {
    public WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    public List<WebElement> headerMenuItems;

    public void checkMenuItemText(WebElement webElement, String text) {
        assertEquals(webElement.getText(), text);
    }

    public void checkMenuItemsCount(int count) {
        assertEquals(count, headerMenuItems.size());
    }
}
