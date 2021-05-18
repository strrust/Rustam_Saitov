package ru.training.at.hw4;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        attachedScreenShot(driver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachedScreenShot(WebDriver driver) {
        return ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.BYTES);
    }
}
