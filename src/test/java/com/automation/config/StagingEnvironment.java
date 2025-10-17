package com.automation.config;

import com.automation.utils.EnvReader;

/**
 * Staging environment configuration
 * Contains settings specific to staging environment
 */
public class StagingEnvironment implements EnvironmentConfig {
    
    // Singleton instance for thread-safe access
    private static volatile StagingEnvironment instance;
    
    /**
     * Private constructor to prevent instantiation
     */
    private StagingEnvironment() {
    }
    
    /**
     * Get singleton instance of StagingEnvironment
     * 
     * @return StagingEnvironment instance
     */
    public static StagingEnvironment getInstance() {
        // Double-checked locking for thread safety
        if (instance == null) {
            synchronized (StagingEnvironment.class) {
                if (instance == null) {
                    instance = new StagingEnvironment();
                }
            }
        }
        return instance;
    }
    
    @Override
    public String getBaseUrl() {
        // Get from environment variable or use default
        return EnvReader.getEnv("APP_STAGING_URL", "https://staging.saucedemo.com");
    }
    
    @Override
    public String getApiBaseUrl() {
        // Get from environment variable or use default
        return EnvReader.getEnv("API_STAGING_URL", "https://api-staging.saucedemo.com");
    }
    
    @Override
    public String getEnvironmentName() {
        return "staging";
    }
    
    @Override
    public int getImplicitWait() {
        // Staging uses standard waits
        return Integer.parseInt(EnvReader.getEnv("IMPLICIT_WAIT", "10"));
    }
    
    @Override
    public int getPageLoadTimeout() {
        // Staging uses standard timeouts
        return Integer.parseInt(EnvReader.getEnv("PAGE_LOAD_TIMEOUT", "30"));
    }
    
    @Override
    public boolean isCiMode() {
        // Staging often runs in CI
        return Boolean.parseBoolean(EnvReader.getEnv("CI_MODE", "false"));
    }
    
    @Override
    public int getRetryCount() {
        // Standard retry count for staging
        return Integer.parseInt(EnvReader.getEnv("RETRY_FAILED_TESTS", "1"));
    }
}

