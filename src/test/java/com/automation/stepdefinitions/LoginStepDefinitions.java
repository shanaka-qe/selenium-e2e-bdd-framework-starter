package com.automation.stepdefinitions;

import com.automation.steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/**
 * Step Definitions for Login Feature
 * This class maps Gherkin steps (Given/When/Then) to Java methods
 * Acts as glue code between feature files and step implementation
 */
public class LoginStepDefinitions {
    
    // Steps class instance for login business logic
    // Created in no-argument constructor for Cucumber compatibility
    private LoginSteps loginSteps;
    
    /**
     * No-argument constructor required by Cucumber
     * Initializes the LoginSteps instance
     */
    public LoginStepDefinitions() {
        this.loginSteps = new LoginSteps();
    }
    
    /**
     * Step definition: User is on the login page
     * Maps to Gherkin: Given user is on the login page
     */
    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        // Navigate to login page using steps class
        loginSteps.navigateToLoginPage();
    }
    
    /**
     * Step definition: User enters valid credentials
     * Maps to Gherkin: When user enters valid username and password
     */
    @When("user enters valid username {string} and password {string}")
    public void userEntersValidUsernameAndPassword(String username, String password) {
        // Login with credentials using steps class
        loginSteps.loginWithCredentials(username, password);
    }
    
    /**
     * Step definition: User enters invalid credentials
     * Maps to Gherkin: When user enters invalid username and password
     */
    @When("user enters invalid username {string} and password {string}")
    public void userEntersInvalidUsernameAndPassword(String username, String password) {
        // Login with credentials using steps class
        loginSteps.loginWithCredentials(username, password);
    }
    
    /**
     * Step definition: User enters username
     * Maps to Gherkin: When user enters username
     */
    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        // Enter username using steps class
        loginSteps.enterUsername(username);
    }
    
    /**
     * Step definition: User enters password
     * Maps to Gherkin: And user enters password
     */
    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        // Enter password using steps class
        loginSteps.enterPassword(password);
    }
    
    /**
     * Step definition: User clicks login button
     * Maps to Gherkin: And user clicks login button
     */
    @When("user clicks login button")
    public void userClicksLoginButton() {
        // Click login button using steps class
        loginSteps.clickLoginButton();
    }
    
    /**
     * Step definition: User should see login page
     * Maps to Gherkin: Then user should see the login page
     */
    @Then("user should see the login page")
    public void userShouldSeeTheLoginPage() {
        // Verify login page is displayed using steps class
        loginSteps.verifyLoginPageDisplayed();
    }
    
    /**
     * Step definition: User should see error message
     * Maps to Gherkin: Then user should see an error message
     */
    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() {
        // Verify error message is displayed using steps class
        loginSteps.verifyErrorMessageDisplayed();
    }
    
    /**
     * Step definition: Error message should contain text
     * Maps to Gherkin: And error message should contain
     */
    @Then("error message should contain {string}")
    public void errorMessageShouldContain(String expectedText) {
        // Verify error message contains expected text using steps class
        loginSteps.verifyErrorMessageContains(expectedText);
    }
}

