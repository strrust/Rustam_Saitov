package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static ru.training.at.hw3.PropertiesLoader.getProperty;

public abstract class TestBase {
    protected WebDriver webDriver;

    @BeforeMethod
    public void webDriverInit() {
        System.setProperty("webdriver.chrome.driver", getProperty("driverPath"));
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void webDriverClose() {
        webDriver.close();
    }
}
