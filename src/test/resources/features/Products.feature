# Feature file for Products/Inventory functionality
# This file describes the products page behavior in Gherkin language

Feature: Products and Shopping Cart
  As a logged-in user
  I want to be able to view and add products to cart
  So that I can make purchases

  # Background runs before each scenario
  Background:
    Given user is on the login page
    When user enters valid username "standard_user" and password "secret_sauce"
    Then user should be on the products page

  # Scenario 1: View products on products page
  @smoke @regression @products
  Scenario: User can view products after login
    Then user should see page title "Products"
    And user should see products displayed

  # Scenario 2: Add product to cart
  @smoke @regression @products @cart
  Scenario: User can add product to shopping cart
    When user adds first product to cart
    Then cart badge should show "1" item

  # Scenario 3: Logout from application
  @regression @logout
  Scenario: User can logout from application
    When user logs out
    Then user should see the login page

