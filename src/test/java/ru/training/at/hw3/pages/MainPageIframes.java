package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageIframes {
    public WebDriver driver;

    public MainPageIframes(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "frame")
    public WebElement iframe;

    @FindBy(id = "frame-button")
    public WebElement iframeButton;

    public void checkFrameExistence() {
        iframe.isDisplayed();
    }

    public void checkFrameButtonClick() {
        iframeButton.click();
    }
}
