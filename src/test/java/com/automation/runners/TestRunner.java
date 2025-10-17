package com.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Test Runner class for executing Cucumber tests with Serenity BDD
 * This class configures and runs all feature files
 * Uses JUnit 4 to run Cucumber scenarios
 */
@RunWith(CucumberWithSerenity.class)  // Run tests with Serenity BDD integration
@CucumberOptions(
    // Location of feature files
    features = "src/test/resources/features",
    
    // Package containing step definitions (glue code)
    glue = {"com.automation.stepdefinitions"},
    
    // Tags to filter which scenarios to run
    // Use @smoke to run only smoke tests, @regression for all regression tests
    // Leave empty or use "not @skip" to run all tests
    tags = "",
    
    // Pretty print format for console output
    plugin = {
        "pretty",                                    // Pretty format in console
        "html:target/cucumber-reports.html",        // HTML report
        "json:target/cucumber-reports.json",        // JSON report for CI/CD
        "junit:target/cucumber-reports.xml"         // JUnit XML report
    },
    
    // Generate snippets for undefined steps
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    
    // Don't print test output in color
    monochrome = false
)
public class TestRunner {
    // This class remains empty
    // Configuration is done through annotations
    // Execution is handled by JUnit and Cucumber
}

