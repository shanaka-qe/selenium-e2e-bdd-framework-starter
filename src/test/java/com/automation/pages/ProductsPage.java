package com.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Page Object class for Products Page
 * Contains all web elements and actions for the products/inventory page
 * Extends BasePage to inherit common methods
 */
public class ProductsPage extends BasePage {
    
    // Web Elements - using Serenity's @FindBy annotation for element location
    
    // Page title - located by class name
    @FindBy(className = "title")
    private WebElement pageTitle;
    
    // Shopping cart icon - located by class name
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartIcon;
    
    // List of all "Add to cart" buttons - located by CSS selector
    @FindBy(css = "[data-test^='add-to-cart']")
    private List<WebElement> addToCartButtons;
    
    // First product's "Add to cart" button - located by id
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;
    
    // Shopping cart badge showing item count - located by class name
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;
    
    // Hamburger menu button - located by id
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;
    
    // Logout link in the menu - located by id
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    
    /**
     * Constructor to initialize ProductsPage with WebDriver
     * 
     * @param driver the WebDriver instance
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Check if products page is displayed
     * Verifies by checking if page title is visible
     * 
     * @return true if products page title is visible, false otherwise
     */
    public boolean isProductsPageDisplayed() {
        // Use BasePage method to check element visibility
        boolean isDisplayed = isElementDisplayed(pageTitle);
        
        // Log the result
        logger.info("Products page displayed: {}", isDisplayed);
        
        return isDisplayed;
    }
    
    /**
     * Get the page title text
     * 
     * @return the page title text
     */
    public String getPageTitle() {
        // Use BasePage method to get element text with wait
        String title = getElementText(pageTitle);
        
        // Log the title
        logger.info("Page title: {}", title);
        
        return title;
    }
    
    /**
     * Add first product (backpack) to cart
     */
    public void addFirstProductToCart() {
        // Use BasePage method to click with wait
        clickElement(addBackpackToCartButton);
        
        // Log the action
        logger.info("Added first product (backpack) to cart");
    }
    
    /**
     * Get the cart badge count (number of items in cart)
     * 
     * @return the number of items in cart as string
     */
    public String getCartBadgeCount() {
        // Use BasePage method to get element text with wait
        String count = getElementText(cartBadge);
        
        // Log the count
        logger.info("Cart badge count: {}", count);
        
        return count;
    }
    
    /**
     * Click on shopping cart icon to navigate to cart page
     */
    public void clickShoppingCart() {
        // Use BasePage method to click with wait
        clickElement(shoppingCartIcon);
        
        // Log the action
        logger.info("Clicked shopping cart icon");
    }
    
    /**
     * Click hamburger menu button
     */
    public void clickMenuButton() {
        // Use BasePage method to click with wait
        clickElement(menuButton);
        
        // Log the action
        logger.info("Clicked menu button");
    }
    
    /**
     * Click logout link from the menu
     * Note: Menu must be opened first using clickMenuButton()
     */
    public void clickLogout() {
        // Use BasePage method to click with wait
        clickElement(logoutLink);
        
        // Log the action
        logger.info("Clicked logout link");
    }
    
    /**
     * Perform logout action (opens menu and clicks logout)
     */
    public void performLogout() {
        // Click menu button to open menu
        clickMenuButton();
        
        // Wait a moment for menu to open
        waitFor(1); // Serenity's built-in wait method
        
        // Click logout link
        clickLogout();
        
        // Log the complete action
        logger.info("Performed logout");
    }
    
    /**
     * Get total number of products displayed on the page
     * 
     * @return the count of "Add to cart" buttons (equals number of products)
     */
    public int getProductCount() {
        // Get size of the list of add to cart buttons
        int count = addToCartButtons.size();
        
        // Log the count
        logger.info("Total products on page: {}", count);
        
        return count;
    }
}

