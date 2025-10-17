package com.automation.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import net.thucydides.model.environment.SystemEnvironmentVariables;

/**
 * Utility class for reading configuration properties
 * Centralized configuration management using Serenity's environment variables
 */
public class ConfigReader {
    
    // Environment variables instance for reading serenity.conf properties
    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.currentEnvironmentVariables();
    
    /**
     * Get property value from configuration file or system properties
     * 
     * @param propertyKey the key of the property to retrieve
     * @return the property value as String
     */
    public static String getProperty(String propertyKey) {
        // First try to get from system properties (command line arguments)
        String value = System.getProperty(propertyKey);
        
        // If not found in system properties, get from serenity.conf
        if (value == null) {
            value = environmentVariables.getProperty(propertyKey);
        }
        
        return value;
    }
    
    /**
     * Get property value with a default fallback
     * 
     * @param propertyKey the key of the property to retrieve
     * @param defaultValue the default value if property is not found
     * @return the property value or default value
     */
    public static String getProperty(String propertyKey, String defaultValue) {
        // Get property value using the main method
        String value = getProperty(propertyKey);
        
        // Return default value if property is null or empty
        return (value != null && !value.isEmpty()) ? value : defaultValue;
    }
    
    /**
     * Get base URL from configuration
     * 
     * @return the base URL for the application under test
     */
    public static String getBaseUrl() {
        // Return base URL from webdriver.base.url property
        return getProperty("webdriver.base.url", "https://www.saucedemo.com");
    }
    
    /**
     * Get browser type from configuration
     * 
     * @return the browser type (chrome, firefox, etc.)
     */
    public static String getBrowser() {
        // Return browser type from webdriver.driver property
        return getProperty("webdriver.driver", "chrome");
    }
    
    /**
     * Get implicit wait timeout from configuration
     * 
     * @return the implicit wait timeout in milliseconds
     */
    public static int getImplicitWait() {
        // Get timeout value and convert to integer
        String timeout = getProperty("webdriver.timeouts.implicitlywait", "10000");
        return Integer.parseInt(timeout);
    }
}

