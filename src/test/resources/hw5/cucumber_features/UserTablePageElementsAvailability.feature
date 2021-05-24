Feature: User table page
  In order to see a specific view
  As a user
  I want to open User Table page with my account conditions

  Background:
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown

  Scenario Outline: User Table Page test check table
    Then "User Table" page should be opened
    And <Number> Type Dropdowns should be displayed on Users Table on User Table Page
    And "<User>" should be displayed on Users Table on User Table Page
    And "<Description>" texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    Examples:
    | Number | User             | Description                      |
    | 1      | Roman            | Wolverine                        |
    | 2      | Sergey Ivan      | Spider Man                       |
    | 3      | Vladzimir        | Punisher                         |
    | 4      | Helen Bennett    | Captain America some description |
    | 5      | Yoshi Tannamuri  | Cyclope some description         |
    | 6      | Giovanni Rovelli | Hulksome description             |

  Scenario Outline: User Table Page test check dropdown list
    Then "User Table" page should be opened
    And droplist should contain "<Dropdown Values>" in column Type for user Roman
    Examples:
    | Dropdown Values |
    | Admin           |
    | User            |
    | Manager         |
