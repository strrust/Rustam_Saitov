package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw6.entities.MetalsColorsTestData;
import ru.training.at.hw6.forms.JdiMetalsColorsForm;

public class JdiMetalsColorsPage extends WebPage {
    public JdiMetalsColorsForm jdiMetalsColorsForm;

    @UI("//ul[@class='panel-body-list results']/li")
    public WebList results;

    public void fillInMetalsColorsForm(MetalsColorsTestData data) {
        jdiMetalsColorsForm.fill(data);
    }
}
