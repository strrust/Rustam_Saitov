package ru.training.at.hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw4.steps.StepAct;
import ru.training.at.hw4.steps.StepAssert;

import java.util.concurrent.TimeUnit;

import static ru.training.at.hw4.PropertiesLoader.getProperty;

public abstract class TestBase {
    protected WebDriver webDriver;
    protected StepAct stepAct;
    protected StepAssert stepAssert;

    @BeforeMethod
    public void webDriverInit(ITestContext testContext) {
        System.setProperty("webdriver.chrome.driver", getProperty("driverPath"));
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        testContext.setAttribute("driver", webDriver);
        stepAct = new StepAct(webDriver);
        stepAssert = new StepAssert(webDriver);
    }

    @AfterMethod
    public void webDriverClose() {
        webDriver.close();
    }
}
