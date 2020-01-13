Feature: Clearance
  As a user I view product display page
  from clearance product list by clicking on
  any selected product, and product display
  page has product info.

  @regression
  Scenario Outline: 1. Verify Clearance page add to bag
    Given I'm on the "<Category>" screen
    When I click on any item
    Then I am on the product display page

    Examples:
    | Category |
    |Clearance |