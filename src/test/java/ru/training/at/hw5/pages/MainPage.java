package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;
import static ru.training.at.hw5.base.PropertiesLoader.getProperty;

public class MainPage extends PageTestBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(getProperty("webAddr"));
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), getProperty("pageName"));
    }
}
