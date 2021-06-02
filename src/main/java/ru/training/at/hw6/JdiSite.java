package ru.training.at.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.pages.JdiHomePage;
import ru.training.at.hw6.pages.JdiMetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("/index.html")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html")
    public static JdiMetalsColorsPage jdiMetalsColorsPage;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(User user) {
        jdiHomePage.loginToSite(user);
    }
}
