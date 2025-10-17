package com.automation.pages;

import com.automation.utils.WaitHelper;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base Page class that all page objects will extend
 * Contains common methods and utilities used across all pages
 * Implements Page Object Model design pattern
 */
public class BasePage extends PageObject {
    
    // Logger for logging page activities
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // Wait helper for explicit waits
    protected WaitHelper waitHelper;
    
    /**
     * Constructor to initialize BasePage with WebDriver
     * 
     * @param driver the WebDriver instance
     */
    public BasePage(WebDriver driver) {
        super(driver);
        // Initialize wait helper with current driver
        this.waitHelper = new WaitHelper(driver);
    }
    
    /**
     * Click on an element with explicit wait
     * 
     * @param element the WebElement to click
     */
    protected void clickElement(WebElement element) {
        // Wait for element to be clickable before clicking
        waitHelper.waitForClickability(element);
        
        // Click the element
        element.click();
        
        // Log the action
        logger.debug("Clicked element: {}", element);
    }
    
    /**
     * Enter text in an input field with explicit wait
     * 
     * @param element the WebElement input field
     * @param text the text to enter
     */
    protected void enterText(WebElement element, String text) {
        // Wait for element to be visible before interacting
        waitHelper.waitForVisibility(element);
        
        // Clear existing text
        element.clear();
        
        // Enter new text
        element.sendKeys(text);
        
        // Log the action
        logger.debug("Entered text '{}' in element: {}", text, element);
    }
    
    /**
     * Get text from an element with explicit wait
     * 
     * @param element the WebElement to get text from
     * @return the text content of the element
     */
    protected String getElementText(WebElement element) {
        // Wait for element to be visible before getting text
        waitHelper.waitForVisibility(element);
        
        // Get and return text
        String text = element.getText();
        
        // Log the action
        logger.debug("Got text '{}' from element: {}", text, element);
        
        return text;
    }
    
    /**
     * Check if an element is displayed on the page
     * 
     * @param element the WebElement to check
     * @return true if element is displayed, false otherwise
     */
    protected boolean isElementDisplayed(WebElement element) {
        try {
            // Wait for element to be visible
            waitHelper.waitForVisibility(element);
            
            // Check if element is displayed
            boolean isDisplayed = element.isDisplayed();
            
            // Log the result
            logger.debug("Element displayed: {}", isDisplayed);
            
            return isDisplayed;
        } catch (Exception e) {
            // Return false if element is not found or not displayed
            logger.debug("Element not displayed: {}", e.getMessage());
            return false;
        }
    }
}

