package com.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for Login Page
 * Contains all web elements and actions for the login page
 * Extends BasePage to inherit common methods
 */
public class LoginPage extends BasePage {
    
    // Web Elements - using Serenity's @FindBy annotation for element location
    
    // Username input field - located by id attribute
    @FindBy(id = "user-name")
    private WebElement usernameField;
    
    // Password input field - located by id attribute
    @FindBy(id = "password")
    private WebElement passwordField;
    
    // Login button - located by id attribute
    @FindBy(id = "login-button")
    private WebElement loginButton;
    
    // Error message container - located by CSS selector
    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;
    
    // Logo element to verify page loaded - located by class name
    @FindBy(className = "login_logo")
    private WebElement loginLogo;
    
    /**
     * Constructor to initialize LoginPage with WebDriver
     * 
     * @param driver the WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Navigate to the login page
     * Opens the base URL in the browser
     */
    public void navigateToLoginPage() {
        // Open the application URL (configured in serenity.conf)
        open();
        
        // Log the navigation action
        logger.info("Navigated to login page");
    }
    
    /**
     * Enter username in the username field
     * 
     * @param username the username to enter
     */
    public void enterUsername(String username) {
        // Use BasePage method to enter text with wait
        enterText(usernameField, username);
        
        // Log the action
        logger.info("Entered username: {}", username);
    }
    
    /**
     * Enter password in the password field
     * 
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        // Use BasePage method to enter text with wait
        enterText(passwordField, password);
        
        // Log the action (masking password for security)
        logger.info("Entered password: ****");
    }
    
    /**
     * Click the login button
     */
    public void clickLoginButton() {
        // Use BasePage method to click with wait
        clickElement(loginButton);
        
        // Log the action
        logger.info("Clicked login button");
    }
    
    /**
     * Perform complete login action
     * 
     * @param username the username to login with
     * @param password the password to login with
     */
    public void performLogin(String username, String password) {
        // Enter username
        enterUsername(username);
        
        // Enter password
        enterPassword(password);
        
        // Click login button
        clickLoginButton();
        
        // Log the complete action
        logger.info("Performed login with username: {}", username);
    }
    
    /**
     * Check if login page is displayed
     * 
     * @return true if login logo is visible, false otherwise
     */
    public boolean isLoginPageDisplayed() {
        // Use BasePage method to check element visibility
        boolean isDisplayed = isElementDisplayed(loginLogo);
        
        // Log the result
        logger.info("Login page displayed: {}", isDisplayed);
        
        return isDisplayed;
    }
    
    /**
     * Get error message text if login fails
     * 
     * @return the error message text
     */
    public String getErrorMessage() {
        // Use BasePage method to get element text with wait
        String error = getElementText(errorMessage);
        
        // Log the error message
        logger.info("Error message: {}", error);
        
        return error;
    }
    
    /**
     * Check if error message is displayed
     * 
     * @return true if error message is visible, false otherwise
     */
    public boolean isErrorMessageDisplayed() {
        // Use BasePage method to check element visibility
        return isElementDisplayed(errorMessage);
    }
}

