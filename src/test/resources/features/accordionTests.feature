@test
Feature: Using playwright to complete test challenge- tabs
  Scenario Outline: tabs/accordion test 1
    Given I am on testing page
    And click on "Tabs" challenge
    And complete "<testNumber>" for tabs challenge

    Examples:
    | testNumber |
    | task1      |
#    | task2      |
#    | task3      |