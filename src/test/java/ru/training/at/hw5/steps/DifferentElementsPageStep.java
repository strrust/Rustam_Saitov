package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static ru.training.at.hw3.PropertiesLoader.getProperty;

public class DifferentElementsPageStep extends StepBase {

    @When("I select checkbox {string}")
    public void selectWindCheckbox(String checkbox) {
        if (checkbox.equals("Water")) {
            diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.waterCheckbox);
        } else if (checkbox.equals("Wind")) {
            diffElemsPageCheckboxes.checkboxClick(diffElemsPageCheckboxes.windCheckbox);
        }
    }

    @When("I select radio {string}")
    public void selectSelenRadio(String radio) {
        if (radio.equals("Selen")) {
            diffElemsPageRadios.radioClick(diffElemsPageRadios.selenRadio);
        }
    }

    @When("I select color {string} in colors")
    public void selectYellowColor(String colorOption) {
        if (colorOption.equals("Yellow")) {
            diffElemsPageColorsDropdown.selectElementFromColors(getProperty("colorOption"));
        }
    }

    @Then("checkbox {string} selected")
    public void checkCheckboxSelected(String checkbox) {
        if (checkbox.equals("Water")) {
            diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.waterCheckbox);
        } else if (checkbox.equals("Wind")) {
            diffElemsPageCheckboxes.checkboxIsSelected(diffElemsPageCheckboxes.windCheckbox);
        }
    }

    @Then("radio {string} selected")
    public void checkRadioSelected(String radio) {
        if (radio.equals("Selen")) {
            diffElemsPageRadios.radioIsSelected(diffElemsPageRadios.selenRadio);
        }
    }

    @Then("color {string} selected")
    public void checkColorSelected(String radio) {
        if (radio.equals("Yellow")) {
            diffElemsPageColorsDropdown.selectElementFromColors(getProperty("colorOption"));
        }
    }
}
