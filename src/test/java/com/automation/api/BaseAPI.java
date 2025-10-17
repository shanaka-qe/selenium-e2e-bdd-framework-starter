package com.automation.api;

import com.automation.config.EnvironmentFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Base API class for REST API testing
 * Provides common methods and utilities for API testing with REST Assured
 */
public class BaseAPI {
    
    // Logger for logging API requests and responses
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // Base URI for API requests
    protected String baseUri;
    
    /**
     * Constructor initializes base URI from environment configuration
     */
    public BaseAPI() {
        this.baseUri = EnvironmentFactory.getEnvironment().getApiBaseUrl();
        RestAssured.baseURI = this.baseUri;
        logger.info("BaseAPI initialized with URI: {}", this.baseUri);
    }
    
    /**
     * Get base request specification with common settings
     * 
     * @return RequestSpecification with default settings
     */
    protected RequestSpecification getBaseRequest() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all(); // Log all request details
    }
    
    /**
     * Perform GET request
     * 
     * @param endpoint API endpoint path
     * @return Response object
     */
    protected Response get(String endpoint) {
        logger.info("GET request to: {}", endpoint);
        Response response = getBaseRequest()
                .when()
                .get(endpoint)
                .then()
                .log().all() // Log all response details
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
    
    /**
     * Perform GET request with query parameters
     * 
     * @param endpoint API endpoint path
     * @param queryParams Query parameters as map
     * @return Response object
     */
    protected Response get(String endpoint, Map<String, Object> queryParams) {
        logger.info("GET request to: {} with params: {}", endpoint, queryParams);
        Response response = getBaseRequest()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
    
    /**
     * Perform POST request
     * 
     * @param endpoint API endpoint path
     * @param body Request body object
     * @return Response object
     */
    protected Response post(String endpoint, Object body) {
        logger.info("POST request to: {}", endpoint);
        Response response = getBaseRequest()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
    
    /**
     * Perform PUT request
     * 
     * @param endpoint API endpoint path
     * @param body Request body object
     * @return Response object
     */
    protected Response put(String endpoint, Object body) {
        logger.info("PUT request to: {}", endpoint);
        Response response = getBaseRequest()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
    
    /**
     * Perform DELETE request
     * 
     * @param endpoint API endpoint path
     * @return Response object
     */
    protected Response delete(String endpoint) {
        logger.info("DELETE request to: {}", endpoint);
        Response response = getBaseRequest()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
    
    /**
     * Perform PATCH request
     * 
     * @param endpoint API endpoint path
     * @param body Request body object
     * @return Response object
     */
    protected Response patch(String endpoint, Object body) {
        logger.info("PATCH request to: {}", endpoint);
        Response response = getBaseRequest()
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .log().all()
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
    
    /**
     * Get request with authentication header
     * 
     * @param endpoint API endpoint path
     * @param token Authentication token
     * @return Response object
     */
    protected Response getWithAuth(String endpoint, String token) {
        logger.info("GET request with auth to: {}", endpoint);
        Response response = getBaseRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
    
    /**
     * POST request with authentication header
     * 
     * @param endpoint API endpoint path
     * @param body Request body object
     * @param token Authentication token
     * @return Response object
     */
    protected Response postWithAuth(String endpoint, Object body, String token) {
        logger.info("POST request with auth to: {}", endpoint);
        Response response = getBaseRequest()
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
        
        logger.info("Response status: {}", response.getStatusCode());
        return response;
    }
}

