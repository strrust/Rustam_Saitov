package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceDropdown extends PageTestBase {

    public ServiceDropdown(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(., 'Service')]")
    public WebElement serviceDropdown;

    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    public WebElement diffPageItem;

    @FindBy(xpath = "//a[contains(text(),'User Table')]")
    public WebElement userTableItem;

    public void openServiceDropdown() {
        serviceDropdown.click();
    }

    public void openDiffElemsPage() {
        diffPageItem.click();
    }

    public void openUserTablePage() {
        userTableItem.click();
    }
}
