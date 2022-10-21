Feature: Homepage Scenarios

  Background: 
    Given I have launched the application
    When I enter standard user name "standard_user" and password as "secret_sauce"
    And I click on the login button

  @Sanity @Patch
  Scenario: Verify products page loaded after successful login
    Then I verify I am on the products page

  @Sanity @Patch
  Scenario: Verify Item added to Cart
    When I click on Add to Cart on product "Sauce Labs Backpack"
    Then Shopping Cart items quantity should be 1
