# Feature file for API testing
# Demonstrates REST API testing capabilities with REST Assured

Feature: API Testing
  As a QA engineer
  I want to test API endpoints
  So that I can verify backend functionality

  # Scenario 1: GET request example
  @smoke @api @get
  Scenario: Verify API GET request returns success
    Given I have the API base URL
    When I send a GET request to "/api/users"
    Then the response status code should be 200
    And the response content type should be "application/json"
    And the response time should be less than 2000 milliseconds

  # Scenario 2: POST request example
  @api @post
  Scenario: Verify API POST request creates resource
    Given I have the API base URL
    When I send a POST request to "/api/users" with body:
      """
      {
        "name": "John Doe",
        "email": "john.doe@example.com"
      }
      """
    Then the response status code should be 201
    And the response should contain field "id"

  # Scenario 3: Response validation example
  @regression @api
  Scenario: Verify API response contains expected data
    Given I have the API base URL
    When I send a GET request to "/api/users/1"
    Then the response status code should be 200
    And the response field "id" should equal 1
    And the response content type should be "application/json"

