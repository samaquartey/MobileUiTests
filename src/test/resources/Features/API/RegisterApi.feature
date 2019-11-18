Feature: Register

  @test
  Scenario: 1. Verify register api post success
    Given I have done a register post with user details
    Then new user account created

  @test
  Scenario: 2. Verify register api post failure with bad data
    Given I have done a register post with invalid user details
    Then new user account is not created