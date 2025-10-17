package com.automation.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hooks class for Cucumber lifecycle management
 * Contains Before and After hooks that run before/after each scenario
 * Used for setup and teardown operations
 */
public class Hooks {
    
    // Logger for logging hook activities
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    
    /**
     * Before hook - executes before each scenario
     * Used for test setup and initialization
     * 
     * @param scenario the current Cucumber scenario
     */
    @Before
    public void beforeScenario(Scenario scenario) {
        // Log scenario start
        logger.info("========================================");
        logger.info("Starting Scenario: {}", scenario.getName());
        logger.info("========================================");
        
        // Store scenario name in Serenity session for reporting
        Serenity.recordReportData().withTitle("Scenario").andContents(scenario.getName());
        
        // Additional setup can be added here
        // Example: Database cleanup, API mocking setup, etc.
    }
    
    /**
     * After hook - executes after each scenario
     * Used for cleanup and teardown operations
     * 
     * @param scenario the current Cucumber scenario
     */
    @After
    public void afterScenario(Scenario scenario) {
        // Check scenario status
        if (scenario.isFailed()) {
            logger.error("Scenario FAILED: {}", scenario.getName());
            logger.error("Status: {}", scenario.getStatus());
        } else {
            logger.info("Scenario PASSED: {}", scenario.getName());
        }
        
        // Log scenario completion
        logger.info("========================================");
        logger.info("Completed Scenario: {}", scenario.getName());
        logger.info("========================================");
        
        // Additional cleanup can be added here
        // Example: Clear test data, close connections, etc.
        // Note: Browser quit is handled by Serenity automatically
    }
}

