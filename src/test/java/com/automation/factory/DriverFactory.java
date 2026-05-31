package com.automation.factory;

import com.automation.utils.ConfigReader;
import com.automation.utils.EnvReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Factory class for creating WebDriver instances
 * Implements Factory Design Pattern for browser initialization
 * Handles different browser types and their configurations
 */
public class DriverFactory {
    
    // Logger for logging driver creation activities
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    
    // ThreadLocal to maintain separate WebDriver instance per thread (for parallel execution)
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Check whether headless mode is enabled via the HEADLESS toggle
     * Reads system property, .env file, or system environment (see EnvReader)
     *
     * @return true if headless mode should be used
     */
    private static boolean isHeadless() {
        return EnvReader.getEnvAsBoolean("HEADLESS", false);
    }

    /**
     * Initialize WebDriver based on browser type from configuration
     * 
     * @return WebDriver instance
     */
    public static WebDriver initializeDriver() {
        // Get browser type from configuration file
        String browserType = ConfigReader.getBrowser().toLowerCase();
        
        // Log the browser initialization
        logger.info("Initializing browser: {}", browserType);
        
        // Create WebDriver based on browser type using switch statement
        WebDriver webDriver;
        switch (browserType) {
            case "chrome":
                webDriver = createChromeDriver();
                break;
            case "firefox":
                webDriver = createFirefoxDriver();
                break;
            case "edge":
                webDriver = createEdgeDriver();
                break;
            default:
                // Default to Chrome if browser type is not recognized
                logger.warn("Unknown browser type: {}. Defaulting to Chrome", browserType);
                webDriver = createChromeDriver();
        }
        
        // Configure common driver settings
        configureDriver(webDriver);
        
        // Set driver in ThreadLocal for thread-safe operations
        driver.set(webDriver);
        
        return webDriver;
    }
    
    /**
     * Create Chrome WebDriver instance with options
     * 
     * @return Chrome WebDriver instance
     */
    private static WebDriver createChromeDriver() {
        // Setup ChromeDriver using WebDriverManager (automatic driver management)
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome-specific options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");           // Start browser maximized
        options.addArguments("--disable-infobars");          // Disable info bars
        options.addArguments("--disable-extensions");        // Disable extensions
        options.addArguments("--disable-gpu");               // Disable GPU acceleration
        options.addArguments("--disable-dev-shm-usage");     // Overcome limited resource problems
        options.addArguments("--no-sandbox");                // Bypass OS security model
        options.addArguments("--remote-allow-origins=*");    // Allow remote origins

        // Enable headless mode when HEADLESS toggle is truthy
        if (isHeadless()) {
            logger.info("Running Chrome in headless mode");
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        // Create and return ChromeDriver instance with options
        return new ChromeDriver(options);
    }
    
    /**
     * Create Firefox WebDriver instance with options
     * 
     * @return Firefox WebDriver instance
     */
    private static WebDriver createFirefoxDriver() {
        // Setup FirefoxDriver using WebDriverManager (automatic driver management)
        WebDriverManager.firefoxdriver().setup();
        
        // Configure Firefox-specific options
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");           // Start browser maximized

        // Enable headless mode when HEADLESS toggle is truthy
        if (isHeadless()) {
            logger.info("Running Firefox in headless mode");
            options.addArguments("-headless");
        }

        // Create and return FirefoxDriver instance with options
        return new FirefoxDriver(options);
    }
    
    /**
     * Create Edge WebDriver instance with options
     * 
     * @return Edge WebDriver instance
     */
    private static WebDriver createEdgeDriver() {
        // Setup EdgeDriver using WebDriverManager (automatic driver management)
        WebDriverManager.edgedriver().setup();
        
        // Configure Edge-specific options
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");           // Start browser maximized

        // Enable headless mode when HEADLESS toggle is truthy
        if (isHeadless()) {
            logger.info("Running Edge in headless mode");
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        // Create and return EdgeDriver instance with options
        return new EdgeDriver(options);
    }
    
    /**
     * Configure common driver settings (timeouts, etc.)
     * 
     * @param webDriver the WebDriver instance to configure
     */
    private static void configureDriver(WebDriver webDriver) {
        // Set implicit wait timeout for element location
        int implicitWait = ConfigReader.getImplicitWait() / 1000; // Convert milliseconds to seconds
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        
        // Set page load timeout
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        
        // Set script timeout for asynchronous scripts
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        
        // Delete all cookies
        webDriver.manage().deleteAllCookies();
        
        // Log successful configuration
        logger.info("Driver configured with implicit wait: {} seconds", implicitWait);
    }
    
    /**
     * Get the current WebDriver instance from ThreadLocal
     * 
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    /**
     * Quit the WebDriver and remove from ThreadLocal
     */
    public static void quitDriver() {
        // Get driver from ThreadLocal
        WebDriver webDriver = driver.get();
        
        // Quit driver if it exists
        if (webDriver != null) {
            logger.info("Quitting browser");
            webDriver.quit();
            
            // Remove driver from ThreadLocal
            driver.remove();
        }
    }
}

