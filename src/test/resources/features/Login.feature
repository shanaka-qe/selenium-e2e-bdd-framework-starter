# Feature file for Login functionality
# This file describes the login behavior in Gherkin language
# Feature files follow the Given-When-Then format for BDD

Feature: User Login
  As a user of the application
  I want to be able to login with my credentials
  So that I can access the application features

  # Background runs before each scenario
  Background:
    Given user is on the login page

  # Scenario 1: Successful login with valid credentials
  @smoke @regression @login
  Scenario: Successful login with valid credentials
    When user enters valid username "standard_user" and password "secret_sauce"
    Then user should be on the products page
    And user should see page title "Products"
    And user should see products displayed

  # Scenario 2: Login with invalid credentials
  @regression @login @negative
  Scenario: Login fails with invalid credentials
    When user enters invalid username "invalid_user" and password "invalid_pass"
    Then user should see an error message
    And error message should contain "Username and password do not match"

  # Scenario 3: Login with locked out user
  @regression @login @negative
  Scenario: Login fails with locked out user
    When user enters valid username "locked_out_user" and password "secret_sauce"
    Then user should see an error message
    And error message should contain "Sorry, this user has been locked out"

