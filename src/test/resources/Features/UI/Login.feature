Feature: Login

  @regression
  Scenario Outline: 1. Verify my account page
    Given I am on the "<Options>" page
    When I login with my details
    Then I am successfully on expected page & have "<Menu>"

    Examples:
    | Options   | Menu                                  |
    | my account| Address Book-My Account-Order History |