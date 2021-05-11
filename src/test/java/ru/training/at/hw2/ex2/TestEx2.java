package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.training.at.hw2.AbstractTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestEx2 extends AbstractTest {

    public void findObjectAndClick(String selectType, String path) {
        switch (selectType) {
            case "ID":
                webDriver.findElement(By.id(path)).click();
                break;
            case "CSS":
                webDriver.findElement(By.cssSelector(path)).click();
                break;
            case "XPATH":
                webDriver.findElement(By.xpath(path)).click();
                break;
            default:
                break;
        }
    }

    public void checkSelected(String selectType, String path) {
        switch (selectType) {
            case "ID":
                assertTrue(webDriver.findElement(By
                        .id(path))
                        .isSelected());
                break;
            case "CSS":
                assertTrue(webDriver.findElement(By
                        .cssSelector(path))
                        .isSelected());
                break;
            case "XPATH":
                assertTrue(webDriver.findElement(By
                        .xpath(path))
                        .isSelected());
                break;
            default:
                break;
        }
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
        findObjectAndClick("XPATH", "//a[contains(., 'Service')]");
        findObjectAndClick("XPATH", "//a[contains(., 'Different elements')]");

        //6 Select checkboxes water, wind
        findObjectAndClick("XPATH", "//label[@class='label-checkbox' and contains(., 'Water')]");
        findObjectAndClick("XPATH", "//label[@class='label-checkbox' and contains(., 'Wind')]");

        //7 Select radio selen
        findObjectAndClick("XPATH", "//label[@class='label-radio' and contains(., 'Selen')]");

        //8 Select in dropdown Yellow
        Select drpColor = new Select(webDriver.findElement(By
                .cssSelector("select.uui-form-element")));
        drpColor.selectByVisibleText("Yellow");

        //9 Assert that
        //for each checkbox there is an individual log row and value
        //is corresponded to the status of checkbox
        checkSelected("XPATH",
                "//label[@class='label-checkbox' and contains(., 'Water')]/input");
        checkSelected("XPATH",
                "//label[@class='label-checkbox' and contains(., 'Wind')]/input");

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        checkSelected("XPATH",
                "//label[@class='label-radio' and contains(., 'Selen')]/input");

        //for dropdown there is a log row and value is corresponded to the selected value.
        Select select = new Select(webDriver.findElement(By
                .cssSelector("select.uui-form-element")));
        assertEquals(select.getFirstSelectedOption().getText(), "Yellow");
    }
}
