package com.automation.steps;

import com.automation.pages.ProductsPage;
import net.serenitybdd.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Steps class for Products/Inventory functionality
 * Contains business logic and reusable step methods for product operations
 * This layer separates business logic from step definitions
 */
public class ProductsSteps {
    
    // Logger for logging step activities
    private static final Logger logger = LoggerFactory.getLogger(ProductsSteps.class);
    
    // Page object instance for products page interactions
    private final ProductsPage productsPage;
    
    /**
     * Constructor with dependency injection
     * Serenity automatically injects page objects
     * 
     * @param productsPage the ProductsPage instance
     */
    public ProductsSteps(ProductsPage productsPage) {
        this.productsPage = productsPage;
    }
    
    /**
     * Verify that products page is displayed
     */
    @Step("Verify products page is displayed")
    public void verifyProductsPageDisplayed() {
        // Get page display status from page object
        boolean isDisplayed = productsPage.isProductsPageDisplayed();
        
        // Assert that products page is displayed using AssertJ
        assertThat(isDisplayed)
            .as("Products page should be displayed")
            .isTrue();
        
        // Log the verification
        logger.info("Verified products page is displayed");
    }
    
    /**
     * Verify the page title matches expected value
     * 
     * @param expectedTitle the expected page title
     */
    @Step("Verify page title is: {0}")
    public void verifyPageTitle(String expectedTitle) {
        // Get page title from page object
        String actualTitle = productsPage.getPageTitle();
        
        // Assert that page title matches expected title using AssertJ
        assertThat(actualTitle)
            .as("Page title should match expected value")
            .isEqualTo(expectedTitle);
        
        // Log the verification
        logger.info("Verified page title is: {}", expectedTitle);
    }
    
    /**
     * Add first product to shopping cart
     */
    @Step("Add first product to cart")
    public void addFirstProductToCart() {
        // Call page object method to add product
        productsPage.addFirstProductToCart();
        
        // Log the step
        logger.info("User added first product to cart");
    }
    
    /**
     * Verify cart badge shows expected item count
     * 
     * @param expectedCount the expected number of items in cart
     */
    @Step("Verify cart badge shows count: {0}")
    public void verifyCartBadgeCount(String expectedCount) {
        // Get cart badge count from page object
        String actualCount = productsPage.getCartBadgeCount();
        
        // Assert that cart badge count matches expected count using AssertJ
        assertThat(actualCount)
            .as("Cart badge should show expected item count")
            .isEqualTo(expectedCount);
        
        // Log the verification
        logger.info("Verified cart badge count is: {}", expectedCount);
    }
    
    /**
     * Click on shopping cart icon
     */
    @Step("Click shopping cart icon")
    public void clickShoppingCart() {
        // Call page object method to click cart
        productsPage.clickShoppingCart();
        
        // Log the step
        logger.info("User clicked shopping cart icon");
    }
    
    /**
     * Perform logout from the application
     */
    @Step("Logout from application")
    public void logout() {
        // Call page object method to perform logout
        productsPage.performLogout();
        
        // Log the step
        logger.info("User logged out from application");
    }
    
    /**
     * Verify products are displayed on the page
     */
    @Step("Verify products are displayed")
    public void verifyProductsAreDisplayed() {
        // Get product count from page object
        int productCount = productsPage.getProductCount();
        
        // Assert that at least one product is displayed using AssertJ
        assertThat(productCount)
            .as("At least one product should be displayed")
            .isGreaterThan(0);
        
        // Log the verification
        logger.info("Verified {} products are displayed", productCount);
    }
    
    /**
     * Click menu button to open navigation menu
     */
    @Step("Click menu button")
    public void clickMenuButton() {
        // Call page object method to click menu
        productsPage.clickMenuButton();
        
        // Log the step
        logger.info("User clicked menu button");
    }
}

