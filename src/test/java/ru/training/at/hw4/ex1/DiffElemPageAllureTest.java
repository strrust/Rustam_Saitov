package ru.training.at.hw4.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.AllureListener;
import ru.training.at.hw4.TestBase;

@Feature("Different Elements page")
@Listeners({AllureListener.class})
public class DiffElemPageAllureTest extends TestBase {
    @Test
    @Story("User can log in to the site")
    @Story("User can move to Service -> Different Elements page")
    @Story("User can select items in checkboxes, radios, dropdown list")
    public void diffElemPageTest() {
        stepAct.openPage();
        stepAssert.checkTitle();
        stepAct.performLogin();
        stepAssert.checkLoggedUserName();
        stepAct.openDifferentElementsPage();
        stepAct.selectCheckboxesElements();
        stepAct.selectRadioElements();
        stepAct.selectDropdownElements();
        stepAssert.checkCheckboxes();
        stepAssert.checkRadios();
        stepAssert.checkColorDropdownSelect();
    }
}
