package ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.entities.MetalsColorsTestData;
import org.testng.annotations.Test;

import static ru.training.at.hw6.JdiSite.*;
import static ru.training.at.hw6.entities.Defaults.DEFAULT_USER;

public class MetalsColorsFormTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        open();
        login(DEFAULT_USER);
        jdiHomePage.checkLoggedUserName(DEFAULT_USER);
        jdiHomePage.openMetalsColorsPage();
    }

    @Test(dataProviderClass = TestDataProvider.class,
            dataProvider = "getMetalsColorsData")
    public void jdiMetalAndColorsFormTest(MetalsColorsTestData data) {
        jdiMetalsColorsPage.fillInMetalsColorsForm(data);
        jdiMetalsColorsPage.checkResults(data);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
