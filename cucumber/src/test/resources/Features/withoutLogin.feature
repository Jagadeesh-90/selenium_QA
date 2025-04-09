Feature: Searching items for products in amazon without login

 Background:
    Given the user is on the Amazon landing page

 Scenario: Clicking the 3rd deal
   When User clicking on today deals
   And User click on third deal
   And Add minimum quantity of item
   Then verify the cart item with minimum quantity

 Scenario: Search for mobiles
   When  User search for "mobiles"
   And User click on search button
   And User scroll down to last mobile
   Then verify the Last mobile displayed

 Scenario: Navigate to mobiles
   When  User will navigate to navbar
   And User click on mobiles
   And User will click on mobiles section
   And User will click on first brand
   Then  verify the mobiles on first page

