package com.automation.stepdefinitions;

import com.automation.steps.ProductsSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step Definitions for Products Feature
 * This class maps Gherkin steps (Given/When/Then) to Java methods
 * Acts as glue code between feature files and step implementation
 */
public class ProductsStepDefinitions {
    
    // Steps class instance for products business logic
    // Created in no-argument constructor for Cucumber compatibility
    private ProductsSteps productsSteps;
    
    /**
     * No-argument constructor required by Cucumber
     * Initializes the ProductsSteps instance
     */
    public ProductsStepDefinitions() {
        this.productsSteps = new ProductsSteps();
    }
    
    /**
     * Step definition: User should be on products page
     * Maps to Gherkin: Then user should be on the products page
     */
    @Then("user should be on the products page")
    public void userShouldBeOnTheProductsPage() {
        // Verify products page is displayed using steps class
        productsSteps.verifyProductsPageDisplayed();
    }
    
    /**
     * Step definition: User should see page title
     * Maps to Gherkin: And user should see page title
     */
    @Then("user should see page title {string}")
    public void userShouldSeePageTitle(String expectedTitle) {
        // Verify page title using steps class
        productsSteps.verifyPageTitle(expectedTitle);
    }
    
    /**
     * Step definition: User should see products displayed
     * Maps to Gherkin: And user should see products displayed
     */
    @Then("user should see products displayed")
    public void userShouldSeeProductsDisplayed() {
        // Verify products are displayed using steps class
        productsSteps.verifyProductsAreDisplayed();
    }
    
    /**
     * Step definition: User adds first product to cart
     * Maps to Gherkin: When user adds first product to cart
     */
    @When("user adds first product to cart")
    public void userAddsFirstProductToCart() {
        // Add first product to cart using steps class
        productsSteps.addFirstProductToCart();
    }
    
    /**
     * Step definition: Cart badge should show count
     * Maps to Gherkin: Then cart badge should show count
     */
    @Then("cart badge should show {string} item")
    public void cartBadgeShouldShowItem(String expectedCount) {
        // Verify cart badge count using steps class
        productsSteps.verifyCartBadgeCount(expectedCount);
    }
    
    /**
     * Step definition: User clicks shopping cart
     * Maps to Gherkin: When user clicks shopping cart
     */
    @When("user clicks shopping cart")
    public void userClicksShoppingCart() {
        // Click shopping cart using steps class
        productsSteps.clickShoppingCart();
    }
    
    /**
     * Step definition: User logs out
     * Maps to Gherkin: When user logs out
     */
    @When("user logs out")
    public void userLogsOut() {
        // Perform logout using steps class
        productsSteps.logout();
    }
    
    /**
     * Step definition: User clicks menu button
     * Maps to Gherkin: When user clicks menu button
     */
    @When("user clicks menu button")
    public void userClicksMenuButton() {
        // Click menu button using steps class
        productsSteps.clickMenuButton();
    }
}

