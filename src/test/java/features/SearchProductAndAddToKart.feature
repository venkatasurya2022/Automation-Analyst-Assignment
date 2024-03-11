Feature: Add Laptops to cart on Flipkart

  Scenario Outline: Add Laptop to cart in "<browser>"
    Given I open the "<browser>" browser
    When I navigate to Flipkart website
    And I search for "Laptop"
    And I click on the first Laptop
    And I add the Laptop to the cart and close browser

    Examples: 
      | browser |
      | Chrome  |
      | Firefox |
      | Edge    |
