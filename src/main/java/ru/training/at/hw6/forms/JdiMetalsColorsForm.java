package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.MetalsColorsTestData;

public class JdiMetalsColorsForm extends Form<MetalsColorsTestData> {
    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colorsDropdown;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metalsDropdown;

    @JDropdown(root = "div[ui=droplist]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown vegetablesDropdown;

    @UI("a.checkbox > input")
    public Checklist vegetablesCheckList;

    @UI("p.checkbox > input")
    public Checklist elementsCheckList;

    @UI("[name=custom_radio_odd]")
    public RadioButtons oddNumbers;

    @UI("[name=custom_radio_even]")
    public RadioButtons evenNumbers;

    @UI("#submit-button")
    public Button submitButton;

    public void fillInMetalsColorsForm(MetalsColorsTestData data) {
        int i;
        oddNumbers.select(Integer.toString(data.summary[0]));
        evenNumbers.select(Integer.toString(data.summary[1]));
        for (i = 0; i < data.elements.length; i++) {
            elementsCheckList.select(data.elements[i]);
        }
        colorsDropdown.select(data.color);
        metalsDropdown.select(data.metals);
        vegetablesDropdown.expand();
        if (vegetablesCheckList.selected().length() > 0) {
            vegetablesCheckList.select(vegetablesCheckList.selected());
        }
        for (i = 0; i < data.vegetables.length; i++) {
            vegetablesCheckList.select(data.vegetables[i]);
        }
        submitButton.click();

        for (i = 0; i < data.elements.length; i++) {
            elementsCheckList.select(data.elements[i]);
        }
        vegetablesDropdown.expand();
        for (i = 0; i < data.vegetables.length; i++) {
            vegetablesCheckList.select(data.vegetables[i]);
        }
    }
}
