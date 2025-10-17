package com.automation.utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for reading environment variables
 * Supports reading from .env file and system environment variables
 * Follows the pattern: System Property > .env file > System Environment > Default Value
 */
public class EnvReader {
    
    // Logger for logging environment variable access
    private static final Logger logger = LoggerFactory.getLogger(EnvReader.class);
    
    // Dotenv instance for reading .env file
    private static Dotenv dotenv;
    
    // Static initialization block to load .env file
    static {
        try {
            // Try to load .env file from project root
            // If .env doesn't exist, dotenv will be null (which is fine)
            dotenv = Dotenv.configure()
                    .ignoreIfMissing() // Don't throw error if .env doesn't exist
                    .load();
            logger.debug(".env file loaded successfully");
        } catch (Exception e) {
            // If loading fails, continue without .env file
            logger.debug("No .env file found, will use system environment variables");
            dotenv = null;
        }
    }
    
    /**
     * Get environment variable value
     * Priority: System Property > .env file > System Environment
     * 
     * @param key Environment variable name
     * @return Environment variable value or null if not found
     */
    public static String getEnv(String key) {
        // First priority: Check system property (passed via -D flag)
        String value = System.getProperty(key);
        if (value != null && !value.isEmpty()) {
            logger.trace("Found {} in system properties", key);
            return value;
        }
        
        // Second priority: Check .env file
        if (dotenv != null) {
            value = dotenv.get(key);
            if (value != null && !value.isEmpty()) {
                logger.trace("Found {} in .env file", key);
                return value;
            }
        }
        
        // Third priority: Check system environment variables
        value = System.getenv(key);
        if (value != null && !value.isEmpty()) {
            logger.trace("Found {} in system environment", key);
            return value;
        }
        
        // Not found anywhere
        logger.trace("Environment variable {} not found", key);
        return null;
    }
    
    /**
     * Get environment variable value with default fallback
     * 
     * @param key Environment variable name
     * @param defaultValue Default value if variable not found
     * @return Environment variable value or default value
     */
    public static String getEnv(String key, String defaultValue) {
        // Get value using main method
        String value = getEnv(key);
        
        // Return default if null or empty
        if (value == null || value.isEmpty()) {
            logger.trace("Using default value for {}: {}", key, defaultValue);
            return defaultValue;
        }
        
        return value;
    }
    
    /**
     * Get environment variable as integer
     * 
     * @param key Environment variable name
     * @param defaultValue Default value if variable not found or invalid
     * @return Environment variable value as integer or default value
     */
    public static int getEnvAsInt(String key, int defaultValue) {
        // Get value as string
        String value = getEnv(key);
        
        // If not found, return default
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        
        // Try to parse as integer
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.warn("Invalid integer value for {}: {}. Using default: {}", key, value, defaultValue);
            return defaultValue;
        }
    }
    
    /**
     * Get environment variable as boolean
     * 
     * @param key Environment variable name
     * @param defaultValue Default value if variable not found
     * @return Environment variable value as boolean or default value
     */
    public static boolean getEnvAsBoolean(String key, boolean defaultValue) {
        // Get value as string
        String value = getEnv(key);
        
        // If not found, return default
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        
        // Parse as boolean (true/false, yes/no, 1/0)
        return value.equalsIgnoreCase("true") || 
               value.equalsIgnoreCase("yes") || 
               value.equals("1");
    }
    
    /**
     * Check if environment variable exists
     * 
     * @param key Environment variable name
     * @return true if variable exists, false otherwise
     */
    public static boolean hasEnv(String key) {
        return getEnv(key) != null;
    }
}

