package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static ru.training.at.hw3.PropertiesLoader.getProperty;

public class HomePageStep extends StepBase {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubSite() {
        mainPage.openPage();
        mainPage.checkTitle();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void login() {
        loginWindow.openLoginWindow();
        loginWindow.inputName(getProperty("loginName"));
        loginWindow.inputPass(getProperty("loginPassword"));
        loginWindow.clickLoginButton();
        loginWindow.checkLoggedUserName(getProperty("name"));
    }

    @When("I click on \"Service\" button in Header")
    public void clickToServiceInHeaderMenu() {
        serviceDropdown.openServiceDropdown();
    }

    @When("I click on \"Different elements\" button in Service dropdown")
    public void clickToDifferentsElements() {
        serviceDropdown.openDiffElemsPage();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickToUserTableInHeaderMenu() {
        serviceDropdown.openUserTablePage();
    }
}
