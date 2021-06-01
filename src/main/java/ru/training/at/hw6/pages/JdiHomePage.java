package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.JdiLoginForm;

public class JdiHomePage extends WebPage {
    public JdiLoginForm jdiLoginForm;

    @Url("/metals-colors.html")
    public JdiMetalsColorsPage jdiMetalsColorsPage;

    @UI("#user-icon")
    public Icon userIcon;

    @UI("#user-name")
    public Label userName;

    @UI("#login-button")
    public Button loginButton;

    @UI(".uui-navigation.navbar-nav > li")
    public Menu headerMenu;

    public void loginToSite(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public void openMetalsColorsPage() {
        headerMenu.select("Metals & Colors");
    }
}
