package com.automation.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Helper class for explicit waits in Selenium
 * Provides reusable wait methods for common wait conditions
 */
public class WaitHelper extends PageObject {
    
    // WebDriver instance for browser interactions
    private final WebDriver driver;
    
    // Default timeout for wait operations (in seconds)
    private static final int DEFAULT_TIMEOUT = 10;
    
    /**
     * Constructor to initialize WaitHelper with WebDriver
     * 
     * @param driver the WebDriver instance
     */
    public WaitHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    
    /**
     * Wait for an element to be visible on the page
     * 
     * @param element the WebElement to wait for
     * @return the visible WebElement
     */
    public WebElement waitForVisibility(WebElement element) {
        // Create WebDriverWait instance with default timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        
        // Wait until element is visible and return it
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * Wait for an element to be clickable
     * 
     * @param element the WebElement to wait for
     * @return the clickable WebElement
     */
    public WebElement waitForClickability(WebElement element) {
        // Create WebDriverWait instance with default timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        
        // Wait until element is clickable and return it
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * Wait for an element to disappear from the page
     * 
     * @param element the WebElement to wait for
     * @return true if element is no longer visible
     */
    public boolean waitForInvisibility(WebElement element) {
        // Create WebDriverWait instance with default timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        
        // Wait until element becomes invisible
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    /**
     * Custom wait with specified timeout
     * 
     * @param element the WebElement to wait for
     * @param timeoutInSeconds custom timeout in seconds
     * @return the visible WebElement
     */
    public WebElement waitForVisibility(WebElement element, int timeoutInSeconds) {
        // Create WebDriverWait instance with custom timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        
        // Wait until element is visible and return it
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}

