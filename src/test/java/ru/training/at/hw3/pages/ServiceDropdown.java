package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceDropdown {
    public WebDriver driver;

    public ServiceDropdown(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(., 'Service')]")
    public WebElement serviceDropdown;

    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    public WebElement diffPageItem;

    public void openServiceDropdown() {
        serviceDropdown.click();
    }

    public void openDiffElemsPage() {
        diffPageItem.click();
    }
}
