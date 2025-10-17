package com.automation.config;

import com.automation.utils.EnvReader;

/**
 * Development environment configuration
 * Contains settings specific to development environment
 */
public class DevEnvironment implements EnvironmentConfig {
    
    // Singleton instance for thread-safe access
    private static volatile DevEnvironment instance;
    
    /**
     * Private constructor to prevent instantiation
     */
    private DevEnvironment() {
    }
    
    /**
     * Get singleton instance of DevEnvironment
     * 
     * @return DevEnvironment instance
     */
    public static DevEnvironment getInstance() {
        // Double-checked locking for thread safety
        if (instance == null) {
            synchronized (DevEnvironment.class) {
                if (instance == null) {
                    instance = new DevEnvironment();
                }
            }
        }
        return instance;
    }
    
    @Override
    public String getBaseUrl() {
        // Get from environment variable or use default
        return EnvReader.getEnv("APP_DEV_URL", "https://dev.saucedemo.com");
    }
    
    @Override
    public String getApiBaseUrl() {
        // Get from environment variable or use default
        return EnvReader.getEnv("API_DEV_URL", "https://api-dev.saucedemo.com");
    }
    
    @Override
    public String getEnvironmentName() {
        return "dev";
    }
    
    @Override
    public int getImplicitWait() {
        // Dev environment can have longer waits for debugging
        return Integer.parseInt(EnvReader.getEnv("IMPLICIT_WAIT", "15"));
    }
    
    @Override
    public int getPageLoadTimeout() {
        // Dev environment can have longer timeouts
        return Integer.parseInt(EnvReader.getEnv("PAGE_LOAD_TIMEOUT", "40"));
    }
    
    @Override
    public boolean isCiMode() {
        // Dev environment is typically not CI
        return Boolean.parseBoolean(EnvReader.getEnv("CI_MODE", "false"));
    }
    
    @Override
    public int getRetryCount() {
        // More retries in dev for debugging
        return Integer.parseInt(EnvReader.getEnv("RETRY_FAILED_TESTS", "2"));
    }
}

