package com.automation.config;

/**
 * Base interface for environment-specific configurations
 * Defines contract for all environment configurations (Dev, Staging, Prod)
 */
public interface EnvironmentConfig {
    
    /**
     * Get the base URL for the application
     * 
     * @return Base URL as String
     */
    String getBaseUrl();
    
    /**
     * Get the API base URL
     * 
     * @return API base URL as String
     */
    String getApiBaseUrl();
    
    /**
     * Get the environment name
     * 
     * @return Environment name (dev, staging, prod)
     */
    String getEnvironmentName();
    
    /**
     * Get implicit wait timeout
     * 
     * @return Timeout in seconds
     */
    int getImplicitWait();
    
    /**
     * Get page load timeout
     * 
     * @return Timeout in seconds
     */
    int getPageLoadTimeout();
    
    /**
     * Check if running in CI mode
     * 
     * @return true if CI mode, false otherwise
     */
    boolean isCiMode();
    
    /**
     * Get retry count for failed tests
     * 
     * @return Number of retries
     */
    int getRetryCount();
}

