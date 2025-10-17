package com.automation.api;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * API Steps class containing reusable API testing methods
 * Provides business logic layer for API operations
 */
public class ApiSteps extends BaseAPI {
    
    // Logger for logging API step activities
    private static final Logger logger = LoggerFactory.getLogger(ApiSteps.class);
    
    // Store last response for assertions
    private Response lastResponse;
    
    /**
     * Perform GET request and store response
     * 
     * @param endpoint API endpoint
     */
    @Step("Perform GET request to: {0}")
    public void performGetRequest(String endpoint) {
        lastResponse = get(endpoint);
        logger.info("GET request completed to: {}", endpoint);
    }
    
    /**
     * Perform POST request and store response
     * 
     * @param endpoint API endpoint
     * @param body Request body
     */
    @Step("Perform POST request to: {0}")
    public void performPostRequest(String endpoint, Object body) {
        lastResponse = post(endpoint, body);
        logger.info("POST request completed to: {}", endpoint);
    }
    
    /**
     * Verify response status code
     * 
     * @param expectedStatusCode Expected HTTP status code
     */
    @Step("Verify response status code is: {0}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertThat(lastResponse.getStatusCode())
                .as("Response status code should match expected value")
                .isEqualTo(expectedStatusCode);
        
        logger.info("Status code verified: {}", expectedStatusCode);
    }
    
    /**
     * Verify response contains expected field
     * 
     * @param fieldPath JSON path to field
     */
    @Step("Verify response contains field: {0}")
    public void verifyResponseContainsField(String fieldPath) {
        Object fieldValue = lastResponse.jsonPath().get(fieldPath);
        
        assertThat(fieldValue)
                .as("Response should contain field: " + fieldPath)
                .isNotNull();
        
        logger.info("Field {} found in response with value: {}", fieldPath, fieldValue);
    }
    
    /**
     * Verify response field value
     * 
     * @param fieldPath JSON path to field
     * @param expectedValue Expected field value
     */
    @Step("Verify response field {0} equals: {1}")
    public void verifyResponseFieldValue(String fieldPath, Object expectedValue) {
        Object actualValue = lastResponse.jsonPath().get(fieldPath);
        
        assertThat(actualValue)
                .as("Field " + fieldPath + " should have expected value")
                .isEqualTo(expectedValue);
        
        logger.info("Field {} verified with value: {}", fieldPath, expectedValue);
    }
    
    /**
     * Verify response time is within limit
     * 
     * @param maxTimeInMs Maximum response time in milliseconds
     */
    @Step("Verify response time is less than: {0} ms")
    public void verifyResponseTime(long maxTimeInMs) {
        long actualTime = lastResponse.getTime();
        
        assertThat(actualTime)
                .as("Response time should be within acceptable limit")
                .isLessThan(maxTimeInMs);
        
        logger.info("Response time verified: {} ms (limit: {} ms)", actualTime, maxTimeInMs);
    }
    
    /**
     * Verify response content type
     * 
     * @param expectedContentType Expected content type
     */
    @Step("Verify response content type is: {0}")
    public void verifyContentType(String expectedContentType) {
        String actualContentType = lastResponse.getContentType();
        
        assertThat(actualContentType)
                .as("Content type should match expected value")
                .contains(expectedContentType);
        
        logger.info("Content type verified: {}", expectedContentType);
    }
    
    /**
     * Get last response for further processing
     * 
     * @return Last API response
     */
    public Response getLastResponse() {
        return lastResponse;
    }
}

