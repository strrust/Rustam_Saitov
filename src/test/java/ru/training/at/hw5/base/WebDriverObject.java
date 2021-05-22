package ru.training.at.hw5.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static ru.training.at.hw5.base.PropertiesLoader.getProperty;

public class WebDriverObject {
    private static WebDriver webDriver;

    private WebDriverObject() {
    }

    public static WebDriver getDriverInstance() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", getProperty("driverPath"));
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts()
                    .implicitlyWait(10, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.close();
        webDriver = null;
    }
}
