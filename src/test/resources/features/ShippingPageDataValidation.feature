Feature: Shipping Page data validation and and required fields
  Test that user cannot proceed without filling out all of the required information with valid data

  Background:
    Given client adds product to cart and goes to checkout
    Then the Shipping page should be loaded

  Scenario:
    And the client selects California in the Province dropdown
    When the client checks Fixed shipping method radio button
    And the client clicks on the Next button
    Then a message requiring to input Email should be displayed
    And a message requiring to input First Name should be displayed
    And a message requiring to input Last Name should be displayed
    And a message requiring to input Address should be displayed
    And a message requiring to input City should be displayed
    And a message requiring to input Post Code should be displayed
    And a message requiring to input Phone Number should be displayed
