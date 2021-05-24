package ru.training.at.hw5.steps;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.base.WebDriverObject;
import ru.training.at.hw5.pages.*;

public class StepBase {
    public MainPage mainPage;
    public LoginWindow loginWindow;
    public ServiceDropdown serviceDropdown;
    public DiffElemsPageColorsDropdown diffElemsPageColorsDropdown;
    public DiffElemsPageCheckboxes diffElemsPageCheckboxes;
    public DiffElemsPageRadios diffElemsPageRadios;
    public LogRowsWindow logRowsWindow;
    public UserTablePage userTablePage;

    protected StepBase() {
        WebDriver driver = WebDriverObject.getDriverInstance();
        mainPage = new MainPage(driver);
        loginWindow = new LoginWindow(driver);
        serviceDropdown = new ServiceDropdown(driver);
        diffElemsPageColorsDropdown = new DiffElemsPageColorsDropdown(driver);
        diffElemsPageCheckboxes = new DiffElemsPageCheckboxes(driver);
        diffElemsPageRadios = new DiffElemsPageRadios(driver);
        userTablePage = new UserTablePage(driver);
        logRowsWindow = new LogRowsWindow(driver);
    }
}
