package ru.training.at.hw3.ex1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw3.TestBase;
import ru.training.at.hw3.pages.*;

import static ru.training.at.hw3.PropertiesLoader.getProperty;

public class HomePageTest extends TestBase {
    public static MainPage mainPage;
    public static LoginWindow loginWindow;
    public static HeaderMenu headerMenu;
    public static LeftMenu leftMenu;
    public static MainPageIcons mainPageIcons;
    public static MainPageIconsText mainPageIconsText;
    public static MainPageIframes mainPageIframes;

    @BeforeMethod
    public void before() {
        mainPage = new MainPage(webDriver);
        loginWindow = new LoginWindow(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        leftMenu = new LeftMenu(webDriver);
        mainPageIcons = new MainPageIcons(webDriver);
        mainPageIconsText = new MainPageIconsText(webDriver);
        mainPageIframes = new MainPageIframes(webDriver);
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

        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(0),
                getProperty("headerMenuHome"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(1),
                getProperty("headerMenuContactForm"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(2),
                getProperty("headerMenuService"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(3),
                getProperty("headerMenuMetalsColors"));

        mainPageIcons.checkIconIsDisplayed(mainPageIcons.practiseIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.customIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.multiIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.baseIcon);

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

        mainPageIframes.checkFrameExistence();
        webDriver.switchTo().frame("frame");
        mainPageIframes.checkFrameButtonClick();

        webDriver.switchTo().defaultContent();

        leftMenu.checkMenuItemText(leftMenu.homeMenuItem, getProperty("leftMenuHome"));
        leftMenu.checkMenuItemText(leftMenu.contactMenuItem, getProperty("leftMenuContactForm"));
        leftMenu.checkMenuItemText(leftMenu.serviceMenuItem, getProperty("leftMenuService"));
        leftMenu.checkMenuItemText(leftMenu.metalMenuItem, getProperty("leftMenuMetalsColors"));
        leftMenu.checkMenuItemText(leftMenu.elementsMenuItem, getProperty("leftMenuElemPacks"));
    }
}
