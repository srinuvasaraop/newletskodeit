@1234
Feature: checking dropdown functionality
  Scenario: select a dropdown button passing through gherkin
    Given user on homepage
    When user sends fruit name name
    |honda|
    Then validate "Honda" item is selected
    Then validate particular item is selected
