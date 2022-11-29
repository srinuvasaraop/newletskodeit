Feature:working on select class

  @10045
  Scenario:Testing functionality of select button
    Given user on homepage
    When user sends fruit name name
      | peach  |
      | orange |
    Then sended fruit name will be selected

  @10058
  Scenario Outline:Testing functionality using scenario outline
    Given user on homepage
    When user send "<fruitname>"
    Then sended fruit name will be selected
    Examples:
      | fruitname |
      | peach     |
      | orange    |