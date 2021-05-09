package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestEx2 {
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
        //1 Open test site by URL
        webDriver.navigate().to(webAddr);

        //2 Assert Browser title
        assertEquals(webDriver.getTitle(), pageName);

        //3 Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(loginName);
        webDriver.findElement(By.id("password")).sendKeys(loginPassword);
        webDriver.findElement(By.id("login-button")).click();

        //4 Assert Username is loggined
        assertTrue(webDriver.findElement(By.id("user-name")).isDisplayed());
        assertEquals(webDriver.findElement(By.id("user-name")).getText(), name);

        //5 Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By
                .xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']"
                        + "/child::li[@class = 'dropdown']"))
                .click();
        webDriver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();

        //6 Select checkboxes water, wind
        webDriver.findElement(By.xpath("//div[@class='checkbox-row']/label[1]")).click();
        webDriver.findElement(By.xpath("//div[@class='checkbox-row']/label[3]")).click();

        //7 Select radio selen
        webDriver.findElement(By.xpath("//div[@class='checkbox-row'][2]/label[4]")).click();

        //8 Select in dropdown Yellow
        Select drpColor = new Select(webDriver.findElement(By
                .cssSelector("select.uui-form-element")));
        drpColor.selectByVisibleText("Yellow");

        //9 Assert that
        //for each checkbox there is an individual log row and value
        //is corresponded to the status of checkbox
        assertTrue(webDriver.findElement(By
                .xpath("//div[@class='checkbox-row']/label[1]/input")).isSelected());
        assertTrue(webDriver.findElement(By
                .xpath("//div[@class='checkbox-row']/label[3]/input")).isSelected());

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        assertTrue(webDriver.findElement(By
                .xpath("//div[@class='checkbox-row'][2]/label[4]/input")).isSelected());

        //for dropdown there is a log row and value is corresponded to the selected value.
        Select select = new Select(webDriver.findElement(By
                .cssSelector("select.uui-form-element")));
        assertEquals(select.getFirstSelectedOption().getText(), "Yellow");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
