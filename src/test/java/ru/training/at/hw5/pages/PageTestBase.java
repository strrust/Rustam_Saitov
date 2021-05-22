package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageTestBase {
    protected WebDriver driver;

    protected PageTestBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
