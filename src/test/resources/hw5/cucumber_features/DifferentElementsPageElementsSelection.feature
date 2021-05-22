Feature: Different elements page
  In order to set up different settings
  As a user
  I want to select different elements

  Scenario: Different Elements Page Selections Test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different elements" button in Service dropdown
    And I select checkbox "Water"
    And I select checkbox "Wind"
    And I select radio "Selen"
    And I select color "Yellow" in colors
    Then checkbox "Water" selected
    And 1 log row has "Water: condition changed to true" text in log section
    And checkbox "Wind" selected
    And 1 log row has "Wind: condition changed to true" text in log section
    And radio "Selen" selected
    And 1 log row has "metal: value changed to Selen" text in log section
    And color "Yellow" selected
    And 1 log row has "Colors: value changed to Yellow" text in log section