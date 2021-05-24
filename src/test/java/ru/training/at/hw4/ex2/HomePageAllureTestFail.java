package ru.training.at.hw4.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.AllureListener;
import ru.training.at.hw4.TestBase;

@Feature("Main page")
@Listeners({AllureListener.class})
public class HomePageAllureTestFail extends TestBase {
    @Test
    @Story("User can log in to the site")
    @Story("Header menu is displayed on site top and have proper menu items")
    @Story("Images is displayed on Index Page and have proper texts")
    @Story("User can switch to the iframe and back")
    @Story("Left menu is displayed on site left and have proper menu items")
    public void testAvailabilityOfHomePageObjects() {
        stepAct.openPage();
        stepAssert.checkTitle();
        stepAct.performLogin();
        stepAssert.checkLoggedUserName();
        stepAssert.checkHeaderMenu(0);
        stepAssert.checkIcons();
        stepAssert.checkIconsTexts();
        stepAct.checkIframeExistence();
        webDriver.switchTo().frame("frame");
        stepAct.clickFrameButton();
        webDriver.switchTo().defaultContent();
        stepAssert.checkLeftMenuItems();
    }
}
