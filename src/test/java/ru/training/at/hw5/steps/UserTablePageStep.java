package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;

public class UserTablePageStep extends StepBase {

    @Then("\"User Table\" page should be opened")
    public void userTableTitleCheck() {
        userTablePage.checkPageTitle();
    }

    @Then("{int} Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdownsDisplayed(int number) {
        switch (number) {
            case 1:
                userTablePage.checkElementDisplayed(userTablePage.numberTypeDropdowns.get(0));
                break;
            case 2:
                userTablePage.checkElementDisplayed(userTablePage.numberTypeDropdowns.get(1));
                break;
            case 3:
                userTablePage.checkElementDisplayed(userTablePage.numberTypeDropdowns.get(2));
                break;
            case 4:
                userTablePage.checkElementDisplayed(userTablePage.numberTypeDropdowns.get(3));
                break;
            case 5:
                userTablePage.checkElementDisplayed(userTablePage.numberTypeDropdowns.get(4));
                break;
            case 6:
                userTablePage.checkElementDisplayed(userTablePage.numberTypeDropdowns.get(5));
                break;
            default:
                break;
        }
    }

    @Then("{string} should be displayed on Users Table on User Table Page")
    public void checkUsernamesDisplayed(String userName) {
        switch (userName) {
            case "Roman":
                userTablePage.checkElementDisplayed(userTablePage.firstUserName);;
                break;
            case "Sergey Ivan":
                userTablePage.checkElementDisplayed(userTablePage.secondUserName);
                break;
            case "Vladzimir":
                userTablePage.checkElementDisplayed(userTablePage.thirdUserName);
                break;
            case "Helen Bennet":
                userTablePage.checkElementDisplayed(userTablePage.fourthUserName);
                break;
            case "Yoshi Tannamuri":
                userTablePage.checkElementDisplayed(userTablePage.fifthUserName);
                break;
            case "Giovanni Rovelli":
                userTablePage.checkElementDisplayed(userTablePage.sixthUserName);
                break;
            default:
                break;
        }
    }

    @Then("{string} texts under images should be displayed on Users Table on User Table Page")
    public void checkDescriptionTextDisplayed(String descriptionText) {
        switch (descriptionText) {
            case "Wolverine":
                userTablePage.checkElementDisplayed(userTablePage.firstUserDescriptionText);;
                break;
            case "Spider Man":
                userTablePage.checkElementDisplayed(userTablePage.secondUserDescriptionText);
                break;
            case "Punisher":
                userTablePage.checkElementDisplayed(userTablePage.thirdUserDescriptionText);
                break;
            case "Captain America some description":
                userTablePage.checkElementDisplayed(userTablePage.fourthUserDescriptionText);
                break;
            case "Cyclope some description":
                userTablePage.checkElementDisplayed(userTablePage.fifthUserDescriptionText);
                break;
            case "Hulksome description":
                userTablePage.checkElementDisplayed(userTablePage.sixthUserDescriptionText);
                break;
            default:
                break;
        }
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxesDisplayed(int count) {
        userTablePage.checkCheckboxesCount(count);
    }

    @Then("droplist should contain {string} in column Type for user Roman")
    public void checkDroplistValues(String option) {
        switch (option) {
            case "Admin":
                userTablePage.checkOptionText(userTablePage.dropDownValues.get(0), "Admin");
                break;
            case "User":
                userTablePage.checkOptionText(userTablePage.dropDownValues.get(1), "User");
                break;
            case "Manager":
                userTablePage.checkOptionText(userTablePage.dropDownValues.get(2), "Manager");
                break;
            default:
                break;
        }
    }

    @Then("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipForSergey() {
        userTablePage.selectVip(userTablePage.firstUserCheckbox);
    }
}
