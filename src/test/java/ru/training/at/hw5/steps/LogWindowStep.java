package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;

public class LogWindowStep extends StepBase {

    @Then("1 log row has {string} text in log section")
    public void checkLog(String logOption) {
        switch (logOption) {
            case "Water: condition changed to true":
                logRowsWindow.checkLogExistence(logRowsWindow.waterLog);
                break;
            case "Wind: condition changed to true":
                logRowsWindow.checkLogExistence(logRowsWindow.windLog);
                break;
            case "metal: value changed to Selen":
                logRowsWindow.checkLogExistence(logRowsWindow.selenLog);
                break;
            case "Colors: value changed to Yellow":
                logRowsWindow.checkLogExistence(logRowsWindow.yellowLog);
                break;
            default:
                break;
        }
    }
}
