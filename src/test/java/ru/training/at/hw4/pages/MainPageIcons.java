package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageIcons {
    public WebDriver driver;

    public MainPageIcons(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".icons-benefit.icon-practise")
    public WebElement practiseIcon;

    @FindBy(css = ".icons-benefit.icon-custom")
    public WebElement customIcon;

    @FindBy(css = ".icons-benefit.icon-multi")
    public WebElement multiIcon;

    @FindBy(css = ".icons-benefit.icon-base")
    public WebElement baseIcon;

    public void checkIconIsDisplayed(WebElement webElement) {
        webElement.isDisplayed();
    }
}
