@19989
Feature:checking iframe functionality

  Scenario Outline:selecting random course
    Given user on homepage
    When  When user sends "<coursename>"
    Then validate the particular  "<coursename>" is selected
    Examples:
      | coursename                  |
      | Selenium WebDriver Advanced |

