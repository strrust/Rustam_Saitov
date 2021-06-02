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
        jdiHomePage.userName.is().text(DEFAULT_USER.userName);
        jdiHomePage.openMetalsColorsPage();
        jdiMetalsColorsPage.checkOpened();
    }

    @Test(dataProviderClass = TestDataProvider.class,
            dataProvider = "getMetalsColorsData")
    public void jdiMetalAndColorsFormTest(MetalsColorsTestData data) {
        jdiMetalsColorsPage.fillInMetalsColorsForm(data);
        int summary = data.summary[0] + data.summary[1];
        String elements = data.elements[0];
        String vegetables = data.vegetables[0];
        for (int i = 1; i < data.elements.length; i++) {
            elements = elements + ", " + data.elements[i];
        }
        for (int i = 1; i < data.vegetables.length; i++) {
            vegetables = vegetables + ", " + data.vegetables[i];
        }
        String colors = data.color;
        String metals = data.metals;

        jdiMetalsColorsPage.results.get(1).assertThat().text("Summary: " + summary);
        jdiMetalsColorsPage.results.get(2).assertThat().text("Elements: " + elements);
        jdiMetalsColorsPage.results.get(3).assertThat().text("Color: " + colors);
        jdiMetalsColorsPage.results.get(4).assertThat().text("Metal: " + metals);
        jdiMetalsColorsPage.results.get(5).assertThat().text("Vegetables: " + vegetables);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}