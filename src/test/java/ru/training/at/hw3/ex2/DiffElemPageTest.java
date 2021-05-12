package ru.training.at.hw3.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw3.DefaultTest;
import ru.training.at.hw3.GetDataFromProperties;
import ru.training.at.hw3.pages.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DiffElemPageTest extends DefaultTest {
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
        loginWindow.inputName(GetDataFromProperties.getProperty("loginName"));
        loginWindow.inputPass(GetDataFromProperties.getProperty("loginPassword"));
        loginWindow.clickLoginButton();
        loginWindow.checkLoggedUserName(GetDataFromProperties.getProperty("name"));

        serviceDropdown.openServiceDropdown();
        serviceDropdown.openDiffElemsPage();

        diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.waterCheckbox);
        diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.windCheckbox);

        diffElemsPageRadios.radioClick(diffElemsPageRadios.selenRadio);

        diffElemsPageColorsDropdown.selectElementFromColors(GetDataFromProperties
                .getProperty("colorOption"));

        diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.windCheckbox);
        diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.waterCheckbox);

        diffElemsPageRadios.radioIsSelected(diffElemsPageRadios.selenRadio);

        diffElemsPageColorsDropdown.selectCheck(GetDataFromProperties.getProperty("colorOption"));
    }
}
