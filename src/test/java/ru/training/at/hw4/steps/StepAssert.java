package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static ru.training.at.hw4.PropertiesLoader.getProperty;

public class StepAssert extends StepBase {

    public StepAssert(WebDriver driver) {
        super(driver);
    }

    @Step("Check main page title")
    public void checkTitle() {
        mainPage.checkTitle();
    }

    @Step("Check logged username")
    public void checkLoggedUserName() {
        loginWindow.checkLoggedUserName(getProperty("name"));
    }

    @Step("Items on the header section are displayed and they have proper texts")
    public void checkHeaderMenu(int count) {
        headerMenu.checkMenuItemsCount(count);
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(0),
                getProperty("headerMenuHome"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(1),
                getProperty("headerMenuContactForm"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(2),
                getProperty("headerMenuService"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(3),
                getProperty("headerMenuMetalsColors"));
    }

    @Step("Images on the Index Page are displayed")
    public void checkIcons() {
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.practiseIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.customIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.multiIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.baseIcon);
    }

    @Step("Texts on the Index Page under icons have proper text")
    public void checkIconsTexts() {
        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.practiseIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.practiseIconText,
                getProperty("iconPractiseText"));
        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.customIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.customIconText,
                getProperty("iconCustomText"));
        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.multiIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.multiIconText,
                getProperty("iconMultiText"));
        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.baseIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.baseIconText,
                getProperty("iconBaseText") + "…");
    }

    @Step("Items in the Left Section are displayed and they have proper text")
    public void checkLeftMenuItems() {
        leftMenu.checkMenuItemText(leftMenu.homeMenuItem, getProperty("leftMenuHome"));
        leftMenu.checkMenuItemText(leftMenu.contactMenuItem, getProperty("leftMenuContactForm"));
        leftMenu.checkMenuItemText(leftMenu.serviceMenuItem, getProperty("leftMenuService"));
        leftMenu.checkMenuItemText(leftMenu.metalMenuItem, getProperty("leftMenuMetalsColors"));
        leftMenu.checkMenuItemText(leftMenu.elementsMenuItem, getProperty("leftMenuElemPacks"));
    }

    @Step("All selected elements are present in checkboxes")
    public void checkCheckboxes() {
        diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.windCheckbox);
        diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.waterCheckbox);
    }

    @Step("All selected elements are present in radio")
    public void checkRadios() {
        diffElemsPageRadios.radioIsSelected(diffElemsPageRadios.selenRadio);
    }

    @Step("All selected elements are present in dropdown")
    public void checkColorDropdownSelect() {
        diffElemsPageColorsDropdown.selectCheck(getProperty("colorOption"));
    }
}
