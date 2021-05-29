package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw6.entities.User;

public class JdiLoginForm extends Form<User> {
    @FindBy(id = "name")
    public TextField loginName;

    @FindBy(id = "password")
    public TextField loginPassword;

    @FindBy(id = "login-button")
    public Button loginButton;
}
