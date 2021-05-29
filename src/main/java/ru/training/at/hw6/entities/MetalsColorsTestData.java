package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;

public class MetalsColorsTestData extends DataClass<MetalsColorsTestData> {
    public int[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public MetalsColorsTestData(int[] summary, String[] elements,
                                String color, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }
}
