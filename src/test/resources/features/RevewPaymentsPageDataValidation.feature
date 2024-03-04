Feature: Shipping Page data validation and and required fields
  Test that user cannot proceed without filling out all of the required information with valid data

  Background:

    Given client adds product to cart and goes to checkout
    Then the Shipping page should be loaded
    When the client types in a valid email
    And the client types in his first name
    And the client types in his last name
    And the client types in his address
    And the client types in his city
    And the client types in his post code
    And the client types in his phone number
    And the client selects United States in the country dropdown
    And the client selects California in the Province dropdown
    And the client checks Fixed shipping method radio button
    And the client clicks on the Next button
    Then the Review & Payments page should be loaded

  Scenario:
    When the client unchecks the My billing and shipping address checkbox
    And clicks the Update button
    Then a message requiring to input First Name should appear
    Then a message requiring to input Last Name should appear
    Then a message requiring to input Address should appear
    Then a message requiring to input City should appear
    Then a message requiring to input Post Code should appear
    Then a message requiring to input Phone Number should appear
