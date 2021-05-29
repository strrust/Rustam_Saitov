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
        jdiMetalsColorsForm.fillInMetalsColorsForm(data);
    }

    public void checkResults(MetalsColorsTestData data) {
        int i;
        int summary = data.summary[0] + data.summary[1];
        String elements = data.elements[0];
        String vegetables = data.vegetables[0];

        for (i = 1; i < data.elements.length; i++) {
            elements = elements + ", " + data.elements[i];
        }
        for (i = 1; i < data.vegetables.length; i++) {
            vegetables = vegetables + ", " + data.vegetables[i];
        }
        String colors = data.color;
        String metals = data.metals;

        results.get(1).assertThat().text("Summary: " + summary);
        results.get(2).assertThat().text("Elements: " + elements);
        results.get(3).assertThat().text("Color: " + colors);
        results.get(4).assertThat().text("Metal: " + metals);
        results.get(5).assertThat().text("Vegetables: " + vegetables);
    }

}
