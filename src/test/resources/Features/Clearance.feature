Feature: Clearance
  Select clearance category 4. Select the 7 item displayed
  ( Currently its Black Sewn Through Disc Playsuit) 5. Add to Bag 6. Select Size
  7. Allow Notifications 8. Select the Bag 9. Select Pay 10. Sign In and Register screen is displayed

  @regression
  Scenario Outline: 1. Verify Clearance page add to bag
    Given I'm on the "<Category>" screen
    When I add "<Item>" to bag & click pay
    Then I am on the Sign In and Register screen

    Examples:
    | Category | Item                                            |
    |Clearance | Black Satin Diamante Cut Out Bodycon Mini Dress |