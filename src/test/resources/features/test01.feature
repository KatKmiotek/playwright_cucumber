@next
Feature: Checking Next online shop website
  Scenario Outline: Confirming behaviour of UI on main page
    Given I am on Next home page
    And check if all elements of navBar are present
    And check "<section>" navbar link



    Examples:
    | section |
    | boys    |
#    | girls   |
#    | baby    |