package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.GetDataFromProperties;

import static org.testng.AssertJUnit.assertEquals;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openPage() {
        driver.get(GetDataFromProperties.getProperty("webAddr"));
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), GetDataFromProperties.getProperty("pageName"));
    }
}
