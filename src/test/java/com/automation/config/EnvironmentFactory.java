package com.automation.config;

import com.automation.utils.EnvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory class for creating environment-specific configurations
 * Implements Factory Design Pattern for environment selection
 */
public class EnvironmentFactory {
    
    // Logger for logging environment selection
    private static final Logger logger = LoggerFactory.getLogger(EnvironmentFactory.class);
    
    // Singleton instance of current environment config
    private static EnvironmentConfig currentEnvironment;
    
    /**
     * Get the current environment configuration
     * Reads ENVIRONMENT variable and returns appropriate config
     * 
     * @return EnvironmentConfig instance based on ENVIRONMENT variable
     */
    public static EnvironmentConfig getEnvironment() {
        // If environment already loaded, return it
        if (currentEnvironment != null) {
            return currentEnvironment;
        }
        
        // Read environment name from environment variable or system property
        String envName = getEnvironmentName();
        
        // Log environment selection
        logger.info("Initializing environment: {}", envName);
        
        // Create appropriate environment based on name
        switch (envName.toLowerCase()) {
            case "dev":
            case "development":
                currentEnvironment = DevEnvironment.getInstance();
                break;
            case "staging":
            case "stage":
                currentEnvironment = StagingEnvironment.getInstance();
                break;
            case "prod":
            case "production":
                currentEnvironment = ProdEnvironment.getInstance();
                break;
            default:
                // Default to dev if environment not recognized
                logger.warn("Unknown environment: {}. Defaulting to dev", envName);
                currentEnvironment = DevEnvironment.getInstance();
        }
        
        // Log selected environment details
        logger.info("Environment configured:");
        logger.info("  - Name: {}", currentEnvironment.getEnvironmentName());
        logger.info("  - Base URL: {}", currentEnvironment.getBaseUrl());
        logger.info("  - API URL: {}", currentEnvironment.getApiBaseUrl());
        logger.info("  - CI Mode: {}", currentEnvironment.isCiMode());
        
        return currentEnvironment;
    }
    
    /**
     * Get environment name from environment variable or system property
     * 
     * @return Environment name (defaults to "dev")
     */
    private static String getEnvironmentName() {
        // First check system property (passed via -Denvironment=dev)
        String envFromSystem = System.getProperty("environment");
        if (envFromSystem != null && !envFromSystem.isEmpty()) {
            return envFromSystem;
        }
        
        // Then check environment variable
        String envFromEnv = EnvReader.getEnv("ENVIRONMENT", "dev");
        return envFromEnv;
    }
    
    /**
     * Reset environment (useful for testing)
     * Forces re-initialization on next getEnvironment() call
     */
    public static void resetEnvironment() {
        currentEnvironment = null;
        logger.info("Environment configuration reset");
    }
}

