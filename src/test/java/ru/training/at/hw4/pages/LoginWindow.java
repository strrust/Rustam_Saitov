package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class LoginWindow {
    public WebDriver driver;

    public LoginWindow(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //get login webElems
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    //get logged user name
    @FindBy(id = "user-name")
    private WebElement loggedUserName;

    public void openLoginWindow() {
        userIcon.click();
    }

    public void inputName(String name) {
        nameField.sendKeys(name);
    }

    public void inputPass(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void checkLoggedUserName(String name) {
        assertEquals(loggedUserName.getText(), name);
    }
}
