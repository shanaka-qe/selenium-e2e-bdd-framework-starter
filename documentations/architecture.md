# Framework Architecture

This document provides a detailed overview of the framework's architecture and design patterns.

## 🏗️ 4-Layer Architecture

The framework follows a strict 4-layer architecture to ensure separation of concerns, maintainability, and scalability.

```
┌─────────────────────────────────────────────────────────────┐
│                     LAYER 1: FEATURE FILES                  │
│                    (Gherkin - Business Layer)                │
│  Location: src/test/resources/features/                     │
│  Purpose: Business-readable test scenarios                  │
├─────────────────────────────────────────────────────────────┤
│                LAYER 2: STEP DEFINITIONS                     │
│                  (Glue Code - Mapping Layer)                 │
│  Location: src/test/java/com/automation/stepdefinitions/    │
│  Purpose: Map Gherkin steps to Java methods                 │
├─────────────────────────────────────────────────────────────┤
│                    LAYER 3: STEPS                            │
│              (Business Logic - Orchestration Layer)          │
│  Location: src/test/java/com/automation/steps/              │
│  Purpose: Implement test logic and assertions               │
├─────────────────────────────────────────────────────────────┤
│                 LAYER 4: PAGE OBJECTS                        │
│               (UI Interaction - Technical Layer)             │
│  Location: src/test/java/com/automation/pages/              │
│  Purpose: Encapsulate page elements and actions             │
└─────────────────────────────────────────────────────────────┘
```

## 📋 Layer Details

### Layer 1: Feature Files
**Purpose:** Define test scenarios in business language

**Example:**
```gherkin
Feature: User Login
  Scenario: Successful login
    Given user is on the login page
    When user enters valid username "standard_user" and password "secret_sauce"
    Then user should be on the products page
```

**Key Points:**
- Written in Gherkin (Given-When-Then)
- No technical implementation details
- Readable by non-technical stakeholders
- Located in `src/test/resources/features/`

### Layer 2: Step Definitions (Glue Code)
**Purpose:** Connect Gherkin steps to Java code

**Example:**
```java
@When("user enters valid username {string} and password {string}")
public void userEntersValidUsernameAndPassword(String username, String password) {
    loginSteps.loginWithCredentials(username, password);
}
```

**Key Points:**
- Uses Cucumber annotations (@Given, @When, @Then)
- Minimal logic - just delegates to Steps layer
- Extracts parameters from Gherkin steps
- Located in `src/test/java/com/automation/stepdefinitions/`

### Layer 3: Steps (Business Logic)
**Purpose:** Implement test logic and orchestrate page objects

**Example:**
```java
@Step("Login with username: {0}")
public void loginWithCredentials(String username, String password) {
    loginPage.performLogin(username, password);
    logger.info("User logged in with username: {}", username);
}
```

**Key Points:**
- Uses Serenity's @Step annotation for reporting
- Contains assertions and verifications
- Coordinates multiple page object calls
- Provides detailed logging
- Located in `src/test/java/com/automation/steps/`

### Layer 4: Page Objects
**Purpose:** Encapsulate UI elements and low-level interactions

**Example:**
```java
@FindBy(id = "user-name")
private WebElement usernameField;

public void enterUsername(String username) {
    enterText(usernameField, username);
}
```

**Key Points:**
- Implements Page Object Model pattern
- Uses @FindBy annotations for element location
- No assertions - only actions and state checks
- Inherits common methods from BasePage
- Located in `src/test/java/com/automation/pages/`

## 🎨 Design Patterns

### 1. Page Object Model (POM)
**Location:** `src/test/java/com/automation/pages/`

**Structure:**
```
BasePage.java (Abstract base class)
├── LoginPage.java
└── ProductsPage.java
```

**Benefits:**
- Reduces code duplication
- Improves maintainability
- Separates test logic from UI structure
- Easy to update when UI changes

### 2. Factory Pattern
**Location:** `src/test/java/com/automation/factory/DriverFactory.java`

**Purpose:** Create WebDriver instances based on browser type

**Implementation:**
```java
public static WebDriver initializeDriver() {
    String browserType = ConfigReader.getBrowser();
    switch (browserType) {
        case "chrome": return createChromeDriver();
        case "firefox": return createFirefoxDriver();
        case "edge": return createEdgeDriver();
        default: return createChromeDriver();
    }
}
```

**Benefits:**
- Centralized driver creation
- Easy to add new browsers
- Browser-specific configuration

### 3. Singleton Pattern
**Location:** `DriverFactory.java` (ThreadLocal implementation)

**Implementation:**
```java
private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
```

**Benefits:**
- One driver instance per thread
- Thread-safe for parallel execution
- Prevents resource conflicts

## 🔧 Supporting Components

### Utilities
**Location:** `src/test/java/com/automation/utils/`

1. **ConfigReader.java**
   - Reads configuration from serenity.conf
   - Provides centralized configuration management
   - Supports environment-specific settings

2. **WaitHelper.java**
   - Implements explicit wait strategies
   - Provides reusable wait methods
   - Improves test reliability

### Hooks
**Location:** `src/test/java/com/automation/stepdefinitions/Hooks.java`

**Purpose:** Manage test lifecycle (Before/After scenarios)

**Features:**
- Scenario logging
- Setup and teardown operations
- Status tracking

### Test Runner
**Location:** `src/test/java/com/automation/runners/TestRunner.java`

**Purpose:** Configure and execute Cucumber tests

**Configuration:**
- Feature file location
- Step definition package (glue)
- Tag filters
- Report plugins
- Test options

## 📊 Data Flow

```
User/CI/CD Trigger
    ↓
Test Runner (TestRunner.java)
    ↓
Feature File (Login.feature)
    ↓
Step Definitions (LoginStepDefinitions.java)
    ↓
Steps (LoginSteps.java)
    ↓
Page Objects (LoginPage.java)
    ↓
WebDriver (DriverFactory.java)
    ↓
Browser (Chrome/Firefox/Edge)
    ↓
Application Under Test
    ↓
Serenity Report Generation
```

## 🎯 Best Practices Implemented

### 1. Separation of Concerns
- Each layer has a single responsibility
- Clear boundaries between layers
- No business logic in page objects
- No UI details in step definitions

### 2. DRY (Don't Repeat Yourself)
- BasePage for common methods
- Utility classes for reusable functions
- Centralized configuration management

### 3. Explicit Waits
- WaitHelper for all wait operations
- No Thread.sleep() calls
- Reliable element interactions

### 4. Logging
- SLF4J with Logback
- Detailed step logging
- Error tracking
- Performance monitoring

### 5. Configuration Management
- Externalized configuration (serenity.conf)
- Environment-specific settings
- Command-line overrides
- Default values

### 6. Error Handling
- Try-catch blocks where appropriate
- Meaningful error messages
- Screenshot capture on failures
- Detailed failure reports

## 🔄 Test Execution Flow

### 1. Initialization Phase
```
1. Maven loads dependencies
2. Test Runner reads configuration
3. Cucumber locates feature files
4. WebDriverManager downloads drivers
5. DriverFactory creates WebDriver instance
```

### 2. Execution Phase
```
For each scenario:
1. @Before hook executes (Hooks.java)
2. Cucumber reads scenario steps
3. Step Definitions map to Steps methods
4. Steps coordinate Page Objects
5. Page Objects interact with browser
6. Assertions verify expected results
7. @After hook executes (Hooks.java)
```

### 3. Reporting Phase
```
1. Serenity collects test results
2. Screenshots captured (on failure)
3. HTML reports generated
4. JSON/XML reports created
5. Reports available in target/site/serenity/
```

## 📦 Package Structure

```
com.automation
├── factory               # Factory pattern for driver creation
│   └── DriverFactory
├── pages                # Page Object Model
│   ├── BasePage
│   ├── LoginPage
│   └── ProductsPage
├── runners              # Test runners
│   └── TestRunner
├── stepdefinitions      # Cucumber glue code
│   ├── Hooks
│   ├── LoginStepDefinitions
│   └── ProductsStepDefinitions
├── steps                # Business logic layer
│   ├── LoginSteps
│   └── ProductsSteps
└── utils                # Utility classes
    ├── ConfigReader
    └── WaitHelper
```

## 🚀 Scalability Considerations

### Adding New Tests
1. Create feature file in `features/`
2. Add step definitions (if new steps needed)
3. Create steps class for new functionality
4. Develop page objects for new pages
5. Run and verify tests

### Adding New Pages
1. Create page class extending BasePage
2. Define elements using @FindBy
3. Implement page-specific methods
4. Use in Steps layer

### Adding New Utilities
1. Create utility class in `utils/`
2. Add static methods for reusability
3. Document usage
4. Use across framework

## 🔒 Thread Safety

The framework is designed for parallel execution:

- **ThreadLocal WebDriver:** Each thread has its own driver instance
- **Serenity Thread Safety:** Built-in thread management
- **Stateless Design:** No shared mutable state
- **Page Object Injection:** Serenity manages page object lifecycle

## 📚 Documentation Standards

All code includes:
- Class-level JavaDoc
- Method-level JavaDoc
- Inline comments explaining complex logic
- Parameter descriptions
- Return value descriptions

---

**For more information, see:**
- [README.md](../README.md) - General project overview
- [Quick Start Guide](quick_start.md) - Fast-track setup and execution
- [Complete File Index](index.md) - Navigation guide with all file references
- [Project Summary](project_summary.md) - Statistics and completion details
- [serenity.conf](../serenity.conf) - Configuration reference

