package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static ru.training.at.hw4.PropertiesLoader.getProperty;

public class StepAct extends StepBase {

    public StepAct(WebDriver driver) {
        super(driver);
    }

    @Step("Open main page")
    public void openPage() {
        mainPage.openPage();
    }

    @Step("Perform login")
    public void performLogin() {
        loginWindow.openLoginWindow();
        loginWindow.inputName(getProperty("loginName"));
        loginWindow.inputPass(getProperty("loginPassword"));
        loginWindow.clickLoginButton();
    }

    @Step("Iframe exist")
    public void checkIframeExistence() {
        mainPageIframes.checkFrameExistence();
    }

    @Step("Click to Frame Button")
    public void clickFrameButton() {
        mainPageIframes.checkFrameButtonClick();
    }

    @Step("Open Service -> Different Elements")
    public void openDifferentElementsPage() {
        serviceDropdown.openServiceDropdown();
        serviceDropdown.openDiffElemsPage();
    }

    @Step("Select elements on the Different Elements Page in checkboxes")
    public void selectCheckboxesElements() {
        diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.waterCheckbox);
        diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.windCheckbox);
    }

    @Step("Select elements on the Different Elements Page in radio")
    public void selectRadioElements() {
        diffElemsPageRadios.radioClick(diffElemsPageRadios.selenRadio);
    }

    @Step("Select elements on the Different Elements Page in color dropdown")
    public void selectDropdownElements() {
        diffElemsPageColorsDropdown.selectElementFromColors(getProperty("colorOption"));
    }
}
