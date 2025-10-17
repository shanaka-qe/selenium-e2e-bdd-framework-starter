package com.automation.config;

import com.automation.utils.EnvReader;

/**
 * Production environment configuration
 * Contains settings specific to production environment
 */
public class ProdEnvironment implements EnvironmentConfig {
    
    // Singleton instance for thread-safe access
    private static volatile ProdEnvironment instance;
    
    /**
     * Private constructor to prevent instantiation
     */
    private ProdEnvironment() {
    }
    
    /**
     * Get singleton instance of ProdEnvironment
     * 
     * @return ProdEnvironment instance
     */
    public static ProdEnvironment getInstance() {
        // Double-checked locking for thread safety
        if (instance == null) {
            synchronized (ProdEnvironment.class) {
                if (instance == null) {
                    instance = new ProdEnvironment();
                }
            }
        }
        return instance;
    }
    
    @Override
    public String getBaseUrl() {
        // Get from environment variable or use default
        return EnvReader.getEnv("APP_PROD_URL", "https://www.saucedemo.com");
    }
    
    @Override
    public String getApiBaseUrl() {
        // Get from environment variable or use default
        return EnvReader.getEnv("API_BASE_URL", "https://api.saucedemo.com");
    }
    
    @Override
    public String getEnvironmentName() {
        return "prod";
    }
    
    @Override
    public int getImplicitWait() {
        // Production uses optimized waits
        return Integer.parseInt(EnvReader.getEnv("IMPLICIT_WAIT", "10"));
    }
    
    @Override
    public int getPageLoadTimeout() {
        // Production uses standard timeouts
        return Integer.parseInt(EnvReader.getEnv("PAGE_LOAD_TIMEOUT", "30"));
    }
    
    @Override
    public boolean isCiMode() {
        // Production testing can run in CI
        return Boolean.parseBoolean(EnvReader.getEnv("CI_MODE", "false"));
    }
    
    @Override
    public int getRetryCount() {
        // Minimal retries in production
        return Integer.parseInt(EnvReader.getEnv("RETRY_FAILED_TESTS", "0"));
    }
}

