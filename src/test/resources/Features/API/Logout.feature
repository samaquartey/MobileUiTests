Feature: Logout

  Scenario: 1. verify logout api request success
    Given I have done a get on the logout api endpoint
    Then my request is a success.