package ru.training.at.hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    protected WebDriver webDriver;
    protected static final String name = "ROMAN IOVLEV";
    protected static final String webAddr = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String pageName = "Home Page";
    protected static final String driverPath = "src/main/resources/chromedriver.exe";
    protected static final String loginName = "Roman";
    protected static final String loginPassword = "Jdi1234";

    @BeforeMethod
    public void webDriverInit() {
        System.setProperty("webdriver.chrome.driver", driverPath);
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
