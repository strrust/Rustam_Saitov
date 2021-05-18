package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.pages.*;

public abstract class StepBase {
    public static MainPage mainPage;
    public static LoginWindow loginWindow;
    public static ServiceDropdown serviceDropdown;
    public static DiffElemsPageColorsDropdown diffElemsPageColorsDropdown;
    public static DiffElemsPageCheckboxes diffElemsPageCheckboxes;
    public static DiffElemsPageRadios diffElemsPageRadios;
    public static HeaderMenu headerMenu;
    public static LeftMenu leftMenu;
    public static MainPageIcons mainPageIcons;
    public static MainPageIconsText mainPageIconsText;
    public static MainPageIframes mainPageIframes;

    public StepBase(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginWindow = new LoginWindow(driver);
        serviceDropdown = new ServiceDropdown(driver);
        diffElemsPageColorsDropdown = new DiffElemsPageColorsDropdown(driver);
        diffElemsPageCheckboxes = new DiffElemsPageCheckboxes(driver);
        diffElemsPageRadios = new DiffElemsPageRadios(driver);
        headerMenu = new HeaderMenu(driver);
        leftMenu = new LeftMenu(driver);
        mainPageIcons = new MainPageIcons(driver);
        mainPageIconsText = new MainPageIconsText(driver);
        mainPageIframes = new MainPageIframes(driver);
    }
}
