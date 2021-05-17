package ru.training.at.hw3.ex2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw3.TestBase;
import ru.training.at.hw3.pages.*;

import static ru.training.at.hw3.PropertiesLoader.getProperty;

public class DiffElemPageTest extends TestBase {
    public static MainPage mainPage;
    public static LoginWindow loginWindow;
    public static ServiceDropdown serviceDropdown;
    public static DiffElemsPageColorsDropdown diffElemsPageColorsDropdown;
    public static DiffElemsPageCheckboxes diffElemsPageCheckboxes;
    public static DiffElemsPageRadios diffElemsPageRadios;

    @BeforeMethod
    public void before() {
        mainPage = new MainPage(webDriver);
        loginWindow = new LoginWindow(webDriver);
        serviceDropdown = new ServiceDropdown(webDriver);
        diffElemsPageColorsDropdown = new DiffElemsPageColorsDropdown(webDriver);
        diffElemsPageCheckboxes = new DiffElemsPageCheckboxes(webDriver);
        diffElemsPageRadios = new DiffElemsPageRadios(webDriver);
    }

    @Test
    public void test() {
        mainPage.openPage();
        mainPage.checkTitle();

        loginWindow.openLoginWindow();
        loginWindow.inputName(getProperty("loginName"));
        loginWindow.inputPass(getProperty("loginPassword"));
        loginWindow.clickLoginButton();
        loginWindow.checkLoggedUserName(getProperty("name"));

        serviceDropdown.openServiceDropdown();
        serviceDropdown.openDiffElemsPage();

        diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.waterCheckbox);
        diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.windCheckbox);

        diffElemsPageRadios.radioClick(diffElemsPageRadios.selenRadio);

        diffElemsPageColorsDropdown.selectElementFromColors(getProperty("colorOption"));

        diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.windCheckbox);
        diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.waterCheckbox);

        diffElemsPageRadios.radioIsSelected(diffElemsPageRadios.selenRadio);

        diffElemsPageColorsDropdown.selectCheck(getProperty("colorOption"));
    }
}
