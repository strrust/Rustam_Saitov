package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.AbstractTest;

import java.util.List;


public class TestEx1 extends AbstractTest {
    SoftAssert softAssert;

    public void checkObjectExistence(String selectType, String pathToObject) {
        switch (selectType) {
            case "ID":
                softAssert.assertTrue(webDriver.findElement(By.id(pathToObject))
                        .isDisplayed());
                break;
            case "CSS":
                softAssert.assertTrue(webDriver.findElement(By.cssSelector(pathToObject))
                        .isDisplayed());
                break;
            case "XPATH":
                softAssert.assertTrue(webDriver.findElement(By.xpath(pathToObject))
                        .isDisplayed());
                break;
            default:
                break;
        }
    }

    public void checkObjectExistenceAndValue(String selectType, String pathToObject, String value) {
        switch (selectType) {
            case "ID":
                softAssert.assertTrue(webDriver.findElement(By
                        .id(pathToObject)).isDisplayed());
                softAssert.assertEquals(webDriver.findElement(By
                        .id(pathToObject)).getText(), value);
                break;
            case "CSS":
                softAssert.assertTrue(webDriver.findElement(By
                        .cssSelector(pathToObject)).isDisplayed());
                softAssert.assertEquals(webDriver.findElement(By
                        .cssSelector(pathToObject)).getText(), value);
                break;
            case "XPATH":
                softAssert.assertTrue(webDriver.findElement(By
                        .xpath(pathToObject)).isDisplayed());
                softAssert.assertEquals(webDriver.findElement(By
                        .xpath(pathToObject)).getText(), value);
                break;
            default:
                break;
        }
    }

    public void checkWebElementValue(WebElement webElement, String value) {
        softAssert.assertEquals(webElement.getText(), value);
    }

    @Test
    public void simpleTest() {
        softAssert = new SoftAssert();

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
        checkObjectExistenceAndValue("ID", "user-name", name);

        //5 Assert there are 4 items on the Header section are displayed, they have proper texts
        List<WebElement> headerItems = webDriver.findElements(By
                .cssSelector(".uui-navigation.navbar-nav > li"));
        checkWebElementValue(headerItems.get(0), "HOME");
        checkWebElementValue(headerItems.get(1), "CONTACT FORM");
        checkWebElementValue(headerItems.get(2), "SERVICE");
        checkWebElementValue(headerItems.get(3), "METALS & COLORS");

        //6 Assert there are 4 images on the Index Page and they are displayed
        checkObjectExistence("CSS", ".icons-benefit.icon-practise");
        checkObjectExistence("CSS", ".icons-benefit.icon-custom");
        checkObjectExistence("CSS", ".icons-benefit.icon-multi");
        checkObjectExistence("CSS", ".icons-benefit.icon-base");

        //7 Assert there are 4 texts on the Index Page under icons, they have proper text
        checkObjectExistenceAndValue("XPATH",
                "//div[@class='benefit']/span[contains(., 'To include')]",
                "To include good practices\n"
                        + "and ideas from successful\n" + "EPAM project");
        checkObjectExistenceAndValue("XPATH",
                "//div[@class='benefit']/span[contains(., 'To be flex')]",
                "To be flexible and\n"
                        + "customizable");
        checkObjectExistenceAndValue("XPATH",
                "//div[@class='benefit']/span[contains(., 'To be mult')]",
                "To be multiplatform");
        checkObjectExistenceAndValue("XPATH",
                "//div[@class='benefit']/span[contains(., 'Alread')]",
                "Already have good base\n"
                        + "(about 20 internal and\n" + "some external projects),\n"
                        + "wish to get more…");

        //8 Assert there is the iframe with “Frame Button” exist
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("frame")));
        checkObjectExistence("ID", "frame");

        //9 Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        checkObjectExistence("ID", "frame-button");
        webDriver.findElement(By.id("frame-button")).click();

        //10 Switch to original window back
        webDriver.switchTo().defaultContent();

        //11 Assert there are 5 items in the Left Section are displayed, they have proper text
        checkObjectExistenceAndValue("XPATH",
                "//ul[@class='sidebar-menu left']/li[contains(., 'Hom')]/a/span",
                "Home");
        checkObjectExistenceAndValue("XPATH",
                "//ul[@class='sidebar-menu left']/li[contains(., 'Cont')]/a/span",
                "Contact form");
        checkObjectExistenceAndValue("XPATH",
                "//ul[@class='sidebar-menu left']/li[contains(., 'Ser')]/a/span",
                "Service");
        checkObjectExistenceAndValue("XPATH",
                "//ul[@class='sidebar-menu left']/li[contains(., 'Met')]/a/span",
                "Metals & Colors");
        checkObjectExistenceAndValue("XPATH",
                "//ul[@class='sidebar-menu left']/li[contains(., 'El')]/a/span",
                "Elements packs");

        softAssert.assertAll();
    }
}
