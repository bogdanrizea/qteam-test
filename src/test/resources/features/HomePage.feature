Feature: Adding to cart and checkout

  Scenario: User can add to cart from home page and successfully finalize order
    Given a user selects M and Blue for item number 1 on page
    When  client clicks on Add to Cart Button
    Then the shopping cart should show 1 item count
    When client clicks on the shopping cart icon
    And client clicks on the Proceed to Checkout button
    Then the Shipping page should be loaded
    When the client types in a valid email
    And the client types in his first name
    And the client types in his last name
    And the client types in his address
    And the client types in his city
    And the client types in his post code
    And the client types in his phone number
    And the client selects Romania in the country dropdown
    And the client checks Fixed shipping method radio button
    And the client selects Bucureşti in the country dropdown
    And the client clicks on the Next button
    Then the Review & Payments page should be loaded
    When the client clicks on the Place Order button
    Then the Success page should be loaded
    And order number should be present