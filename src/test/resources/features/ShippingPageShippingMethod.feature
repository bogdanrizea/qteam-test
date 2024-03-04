Feature: Shipping Page data validation and and required fields
  Test that user cannot proceed without filling out all of the required information with valid data

  Background:
    Given client adds product to cart and goes to checkout
    Then the Shipping page should be loaded

  Scenario:
    When the client types in a valid email
    And the client types in his first name
    And the client types in his last name
    And the client types in his address
    And the client types in his city
    And the client types in his post code
    And the client types in his phone number
    And the client selects California in the Province dropdown
    And the client clicks on the Next button
    Then a shipping method is missing message should be displayed
    When the client types in an invalid email
    And clicks outside of input
    Then a message requiring to input a valid email should be displayed
    When the client clears the input
    When the client types in his first name
    And the client clears the First Name input
    Then a message requiring to input First Name should be displayed
    When the client types in his last name
    And the client clears the Last Name input
    Then a message requiring to input Last Name should be displayed
    When the client types in his address
    And the client clears the Address input
    Then a message requiring to input Address should be displayed
    When the client types in his city
    And the client clears the City input
    Then a message requiring to input City should be displayed
    When the client types in his post code
    And the client clears the Post Code input
    Then a message requiring to input Post Code should be displayed
    When the client types in his phone number
    And the client clears the Phone Number input
    Then a message requiring to input Phone Number should be displayed

