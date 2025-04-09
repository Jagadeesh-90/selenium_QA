Feature: Product search and account management on Amazon after login

  Background:
    Given the user is on the Amazon homepage
    When the user clicks on the login button
    And the user enters a valid email address
    And the user clicks on the continue button
    And the user enters a valid password
    And the user clicks on the sign In button
    Then the user should be redirected to the homepage

  Scenario: Browse mobiles category
    When the user navigates to the navigation bar
    And the user clicks on the mobiles
    And the user selects the mobiles section
    And the user click on prime checkBox
    Then mobile products should be visible on the first page

  Scenario: View last year's orders
    When the user clicks on my orders
    And the user selects the filter for last year's orders
    Then the user should see the orders from the previous year

  Scenario: View payment details
    When the user clicks on my account
    And the user selects my payments
    Then the payment details should be displayed

  Scenario: Add a new address
    When the user clicks on my account
    And the user selects your Addresses
    And the user clicks on add address
    And the user enters a valid full name
    And the user enters a valid mobile number
    And the user enters a valid PIN code
    And the user enters a valid door number
    And the user enters a valid area address
    And the user enters a valid landmark
    And the user enters a valid area address
    And the user clicks on submit address
    Then the new address should be added successfully
