package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;
import static ru.training.at.hw4.PropertiesLoader.getProperty;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openPage() {
        driver.get(getProperty("webAddr"));
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), getProperty("pageName"));
    }
}
