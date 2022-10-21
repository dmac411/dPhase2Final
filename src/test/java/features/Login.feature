Feature: Login to Saucedemo.com

  @sanity @Release @Patch
  Scenario: Login and verify home page for "standard_user"
    Given I have launched the application
    When I enter standard user name "standard_user" and password as "secret_sauce"
    And I click on the login button
    Then I verify I am on the products page

  @sanity @Regression @Patch @Release
  Scenario: Login with incorrect password message validation
    Given I have launched the application
    When I enter standard user name "standard_user" and incorrrect password as "secret_sauce999"
    And I click on the login button
    Then error message appears

  @sanity @Regression @Patch @Release
  Scenario: Login with Locked Out User message validation
    Given I have launched the application
    When I enter Locked Out user "locked_out_user" with correct password as "secret_sauce"
    And I click on the login button
    Then error message "Epic sadface: Sorry, this user has been locked out." is displayed

  @sanity @Regression @Patch @Release
  Scenario Outline: Login with incorrect password message validation
    Given I have launched the application
    When I enter the username as "<UserName>" and Password as "<Password>"
    And I click on the login button
    Then I should get the error message "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | UserName | Password |
      | Jackie   | BadSauce |
      | Foxy     | Brown    |
