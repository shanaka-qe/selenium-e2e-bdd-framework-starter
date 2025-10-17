package com.automation.steps;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Steps class for Login functionality
 * Contains business logic and reusable step methods for login operations
 * This layer separates business logic from step definitions
 */
public class LoginSteps {
    
    // Logger for logging step activities
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    
    // Page object instance for login page interactions
    private final LoginPage loginPage;
    
    /**
     * Constructor with dependency injection
     * Serenity automatically injects page objects
     * 
     * @param loginPage the LoginPage instance
     */
    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
    
    /**
     * Navigate to the application login page
     * Serenity's @Step annotation creates a step in the report
     */
    @Step("Navigate to the login page")
    public void navigateToLoginPage() {
        // Call page object method to navigate
        loginPage.navigateToLoginPage();
        
        // Log the step
        logger.info("User navigated to login page");
    }
    
    /**
     * Enter username in the login form
     * 
     * @param username the username to enter
     */
    @Step("Enter username: {0}")
    public void enterUsername(String username) {
        // Call page object method to enter username
        loginPage.enterUsername(username);
        
        // Log the step
        logger.info("User entered username: {}", username);
    }
    
    /**
     * Enter password in the login form
     * 
     * @param password the password to enter
     */
    @Step("Enter password")
    public void enterPassword(String password) {
        // Call page object method to enter password
        loginPage.enterPassword(password);
        
        // Log the step (password masked for security)
        logger.info("User entered password");
    }
    
    /**
     * Click the login button
     */
    @Step("Click login button")
    public void clickLoginButton() {
        // Call page object method to click login button
        loginPage.clickLoginButton();
        
        // Log the step
        logger.info("User clicked login button");
    }
    
    /**
     * Perform complete login with username and password
     * 
     * @param username the username to login with
     * @param password the password to login with
     */
    @Step("Login with username: {0}")
    public void loginWithCredentials(String username, String password) {
        // Call page object method for complete login
        loginPage.performLogin(username, password);
        
        // Log the step
        logger.info("User logged in with username: {}", username);
    }
    
    /**
     * Verify that login page is displayed
     */
    @Step("Verify login page is displayed")
    public void verifyLoginPageDisplayed() {
        // Get page display status from page object
        boolean isDisplayed = loginPage.isLoginPageDisplayed();
        
        // Assert that login page is displayed using AssertJ
        assertThat(isDisplayed)
            .as("Login page should be displayed")
            .isTrue();
        
        // Log the verification
        logger.info("Verified login page is displayed");
    }
    
    /**
     * Verify error message is displayed on login page
     */
    @Step("Verify error message is displayed")
    public void verifyErrorMessageDisplayed() {
        // Get error message display status from page object
        boolean isDisplayed = loginPage.isErrorMessageDisplayed();
        
        // Assert that error message is displayed using AssertJ
        assertThat(isDisplayed)
            .as("Error message should be displayed")
            .isTrue();
        
        // Log the verification
        logger.info("Verified error message is displayed");
    }
    
    /**
     * Verify error message contains expected text
     * 
     * @param expectedText the expected text in error message
     */
    @Step("Verify error message contains: {0}")
    public void verifyErrorMessageContains(String expectedText) {
        // Get error message text from page object
        String actualErrorMessage = loginPage.getErrorMessage();
        
        // Assert that error message contains expected text using AssertJ
        assertThat(actualErrorMessage)
            .as("Error message should contain expected text")
            .contains(expectedText);
        
        // Log the verification
        logger.info("Verified error message contains: {}", expectedText);
    }
}

