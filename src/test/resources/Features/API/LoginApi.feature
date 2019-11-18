Feature: LoginApi

  @demo
  Scenario: 1. Verify Login api post request success
    Given I have made a post with login details
    Then I have a success with response


  @demo
  Scenario: 2. Verify Login api post request fails
    Given I have made a post with login invalid details
    Then I have a success with response