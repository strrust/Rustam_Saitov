package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.training.at.hw5.base.WebDriverObject;

public class WebDriverHook {

    @Before
    public void setUp() {
        WebDriverObject.getDriverInstance();
    }

    @After
    public void tearDown() {
        WebDriverObject.closeDriver();
    }
}
