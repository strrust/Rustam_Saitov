package ru.training.at.hw3.ex1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw3.DefaultTest;
import ru.training.at.hw3.GetDataFromProperties;
import ru.training.at.hw3.pages.*;


public class HomePageTest extends DefaultTest {
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
        loginWindow.inputName(GetDataFromProperties.getProperty("loginName"));
        loginWindow.inputPass(GetDataFromProperties.getProperty("loginPassword"));
        loginWindow.clickLoginButton();
        loginWindow.checkLoggedUserName(GetDataFromProperties.getProperty("name"));

        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(0),
                GetDataFromProperties.getProperty("headerMenuHome"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(1),
                GetDataFromProperties.getProperty("headerMenuContactForm"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(2),
                GetDataFromProperties.getProperty("headerMenuService"));
        headerMenu.checkMenuItemText(headerMenu.headerMenuItems.get(3),
                GetDataFromProperties.getProperty("headerMenuMetalsColors"));

        mainPageIcons.checkIconIsDisplayed(mainPageIcons.practiseIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.customIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.multiIcon);
        mainPageIcons.checkIconIsDisplayed(mainPageIcons.baseIcon);

        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.practiseIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.practiseIconText,
                GetDataFromProperties.getProperty("iconPractiseText"));
        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.customIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.customIconText,
                GetDataFromProperties.getProperty("iconCustomText"));
        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.multiIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.multiIconText,
                GetDataFromProperties.getProperty("iconMultiText"));
        mainPageIconsText.checkIconsTextIsDisplayed(mainPageIconsText.baseIconText);
        mainPageIconsText.checkIconsTextValues(mainPageIconsText.baseIconText,
                GetDataFromProperties.getProperty("iconBaseText") + "…");

        mainPageIframes.checkFrameExistence();
        webDriver.switchTo().frame("frame");
        mainPageIframes.checkFrameButtonClick();

        webDriver.switchTo().defaultContent();

        leftMenu.checkMenuItemText(leftMenu.homeMenuItem,
                GetDataFromProperties.getProperty("leftMenuHome"));
        leftMenu.checkMenuItemText(leftMenu.contactMenuItem,
                GetDataFromProperties.getProperty("leftMenuContactForm"));
        leftMenu.checkMenuItemText(leftMenu.serviceMenuItem,
                GetDataFromProperties.getProperty("leftMenuService"));
        leftMenu.checkMenuItemText(leftMenu.metalMenuItem,
                GetDataFromProperties.getProperty("leftMenuMetalsColors"));
        leftMenu.checkMenuItemText(leftMenu.elementsMenuItem,
                GetDataFromProperties.getProperty("leftMenuElemPacks"));
    }
}
