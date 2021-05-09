package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestEx1 {
    WebDriver webDriver;
    private static final String name = "ROMAN IOVLEV";
    private static final String webAddr = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String pageName = "Home Page";
    private static final String driverPath = "src/main/resources/chromedriver.exe";
    private static final String loginName = "Roman";
    private static final String loginPassword = "Jdi1234";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void simpleTest() {
        SoftAssert softAssert = new SoftAssert();

        //1 Open test site by URL
        webDriver.navigate().to(webAddr);

        //2 Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), pageName);

        //3 Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(loginName);
        webDriver.findElement(By.id("password")).sendKeys(loginPassword);
        webDriver.findElement(By.id("login-button")).click();

        //4 Assert Username is loggined
        softAssert.assertTrue(webDriver.findElement(By.id("user-name")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), name);

        //5 Assert there are 4 items on the header section are displayed, they have proper texts
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/child::li[1]"))
                .getText(), "HOME");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/child::li[2]"))
                .getText(), "CONTACT FORM");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/child::li[3]"))
                .getText(), "SERVICE");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/child::li[4]"))
                .getText(), "METALS & COLORS");

        //6 Assert there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(webDriver.findElement(By.cssSelector(".icons-benefit.icon-practise"))
                .isDisplayed());
        softAssert.assertTrue(webDriver.findElement(By.cssSelector(".icons-benefit.icon-custom"))
                .isDisplayed());
        softAssert.assertTrue(webDriver.findElement(By.cssSelector(".icons-benefit.icon-multi"))
                .isDisplayed());
        softAssert.assertTrue(webDriver.findElement(By.cssSelector(".icons-benefit.icon-base"))
                .isDisplayed());

        //7 Assert there are 4 texts on the Index Page under icons, they have proper text
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//span[@class = 'icons-benefit icon-practise']/../following-sibling::span"))
                .getText(), "To include good practices\n"
                + "and ideas from successful\n" + "EPAM project");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//span[@class = 'icons-benefit icon-custom']/../following-sibling::span"))
                .getText(), "To be flexible and\n"
                + "customizable");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//span[@class = 'icons-benefit icon-multi']/../following-sibling::span"))
                .getText(), "To be multiplatform");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//span[@class = 'icons-benefit icon-base']/../following-sibling::span"))
                .getText(), "Already have good base\n"
                + "(about 20 internal and\n" + "some external projects),\n"
                + "wish to get more…");

        //8 Assert there is the iframe with “Frame Button” exist
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("frame")));
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        //9 Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());
        webDriver.findElement(By.id("frame-button")).click();

        //10 Switch to original window back
        webDriver.switchTo().defaultContent();

        //11 Assert there are 5 items in the Left Section are displayed, they have proper text
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'sidebar-menu left']/child::li[@index = '1']"))
                .getText(), "Home");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'sidebar-menu left']/child::li[@index = '2']"))
                .getText(), "Contact form");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'sidebar-menu left']/child::li[@index = '3']"))
                .getText(), "Service");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'sidebar-menu left']/child::li[@ui = 'label'][@index = '4']"))
                .getText(), "Metals & Colors");
        softAssert.assertEquals(webDriver.findElement(By
                .xpath("//ul[@class = 'sidebar-menu left']/child::li[@index = '5']"))
                .getText(), "Elements packs");

        softAssert.assertAll();
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
