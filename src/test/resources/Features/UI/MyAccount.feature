Feature: My Account

  @wip
  Scenario Outline: 1. Verify my account page
    Given I am on the "<Options>" page
    When I login with my details
    Then I am successfully on expected page

    Examples:
    | Options   |
    | my account|