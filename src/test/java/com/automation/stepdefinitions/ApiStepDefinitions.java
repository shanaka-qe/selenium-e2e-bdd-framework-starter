package com.automation.stepdefinitions;

import com.automation.api.ApiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/**
 * Step Definitions for API Testing Feature
 * Maps Gherkin steps to API testing methods
 */
public class ApiStepDefinitions {
    
    // API Steps instance for API business logic
    // Serenity automatically manages dependency injection
    private final ApiSteps apiSteps;
    
    /**
     * Constructor with dependency injection
     * 
     * @param apiSteps the ApiSteps instance
     */
    public ApiStepDefinitions(ApiSteps apiSteps) {
        this.apiSteps = apiSteps;
    }
    
    /**
     * Step definition: API base URL is set
     * Maps to Gherkin: Given I have the API base URL
     */
    @Given("I have the API base URL")
    public void iHaveTheApiBaseUrl() {
        // Base URL is automatically configured in BaseAPI constructor
        // This step serves as a readability step in feature files
    }
    
    /**
     * Step definition: Send GET request
     * Maps to Gherkin: When I send a GET request to {endpoint}
     */
    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        // Perform GET request using API steps
        apiSteps.performGetRequest(endpoint);
    }
    
    /**
     * Step definition: Send POST request
     * Maps to Gherkin: When I send a POST request to {endpoint} with body
     */
    @When("I send a POST request to {string} with body:")
    public void iSendAPostRequestToWithBody(String endpoint, String body) {
        // Perform POST request using API steps
        apiSteps.performPostRequest(endpoint, body);
    }
    
    /**
     * Step definition: Verify status code
     * Maps to Gherkin: Then the response status code should be {code}
     */
    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        // Verify status code using API steps
        apiSteps.verifyStatusCode(expectedStatusCode);
    }
    
    /**
     * Step definition: Verify response contains field
     * Maps to Gherkin: And the response should contain field {field}
     */
    @Then("the response should contain field {string}")
    public void theResponseShouldContainField(String fieldPath) {
        // Verify field exists in response
        apiSteps.verifyResponseContainsField(fieldPath);
    }
    
    /**
     * Step definition: Verify response field value
     * Maps to Gherkin: And the response field {field} should equal {value}
     */
    @Then("the response field {string} should equal {int}")
    public void theResponseFieldShouldEqual(String fieldPath, int expectedValue) {
        // Verify field value in response
        apiSteps.verifyResponseFieldValue(fieldPath, expectedValue);
    }
    
    /**
     * Step definition: Verify response time
     * Maps to Gherkin: And the response time should be less than {time} milliseconds
     */
    @Then("the response time should be less than {int} milliseconds")
    public void theResponseTimeShouldBeLessThanMilliseconds(int maxTimeInMs) {
        // Verify response time
        apiSteps.verifyResponseTime(maxTimeInMs);
    }
    
    /**
     * Step definition: Verify content type
     * Maps to Gherkin: And the response content type should be {contentType}
     */
    @Then("the response content type should be {string}")
    public void theResponseContentTypeShouldBe(String expectedContentType) {
        // Verify content type
        apiSteps.verifyContentType(expectedContentType);
    }
}

