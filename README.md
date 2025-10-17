# Selenium E2E BDD Framework with Serenity and Cucumber

**Author:** Shanaka Fernando  
**LinkedIn:** https://www.linkedin.com/in/shanaka-qe/

A comprehensive, production-ready Selenium test automation framework using BDD (Behavior-Driven Development) with Serenity BDD and Cucumber. This framework follows industry best practices and design patterns for maintainable, scalable test automation.

## 🎯 Features

- ✅ **BDD Framework**: Cucumber with Serenity BDD for behavior-driven testing
- ✅ **Design Patterns**: Page Object Model, Factory Pattern, Singleton Pattern
- ✅ **Clear Layer Separation**: Feature files, Step Definitions, Steps, and Page Objects
- ✅ **Comprehensive Reporting**: Serenity BDD's detailed HTML reports with screenshots
- ✅ **CI/CD Integration**: GitHub Actions workflow for automated test execution
- ✅ **Cross-Browser Support**: Chrome, Firefox, Edge with automatic driver management
- ✅ **Parallel Execution**: ThreadSafe design for concurrent test execution
- ✅ **Logging**: SLF4J with Logback for detailed test execution logs
- ✅ **Utility Classes**: Reusable helpers for common operations
- ✅ **Configuration Management**: Externalized configuration using Serenity.conf

## 📖 Documentation

This README provides an overview of the framework. For more detailed information, refer to:

- **[Quick Start Guide](documentations/quick_start.md)** - Fast-track setup and first test execution
- **[Architecture Guide](documentations/architecture.md)** - Detailed technical architecture, design patterns, and data flow diagrams
- **[Complete File Index](documentations/index.md)** - Navigation guide with complete file reference and quick commands
- **[Project Summary](documentations/project_summary.md)** - Completion status, statistics, and technology stack details

## 📁 Project Structure

```
selenium-e2e-bdd-framework-starter/
├── .github/
│   └── workflows/
│       └── test-execution.yml          # GitHub Actions CI/CD workflow
├── documentations/                      # Additional documentation
│   ├── architecture.md                 # Technical architecture details
│   ├── index.md                        # Complete file reference guide
│   ├── project_summary.md              # Project completion summary
│   └── quick_start.md                  # Quick start guide
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── automation/
│       │           ├── factory/         # Factory Pattern for driver management
│       │           │   └── DriverFactory.java
│       │           ├── pages/           # Page Object Model (Layer 4)
│       │           │   ├── BasePage.java
│       │           │   ├── LoginPage.java
│       │           │   └── ProductsPage.java
│       │           ├── runners/         # Test Runners
│       │           │   └── TestRunner.java
│       │           ├── stepdefinitions/ # Step Definitions - Glue Code (Layer 3)
│       │           │   ├── Hooks.java
│       │           │   ├── LoginStepDefinitions.java
│       │           │   └── ProductsStepDefinitions.java
│       │           ├── steps/           # Business Logic Layer (Layer 2)
│       │           │   ├── LoginSteps.java
│       │           │   └── ProductsSteps.java
│       │           └── utils/           # Utility Classes
│       │               ├── ConfigReader.java
│       │               └── WaitHelper.java
│       └── resources/
│           ├── features/                # Feature Files - BDD Scenarios (Layer 1)
│           │   ├── Login.feature
│           │   └── Products.feature
│           └── logback-test.xml         # Logging configuration
├── .gitignore                           # Git ignore file
├── pom.xml                              # Maven dependencies and build configuration
├── serenity.conf                        # Serenity BDD configuration
└── README.md                            # Project documentation
```

## 🏗️ Architecture & Layers

This framework follows a **4-layer architecture** for clean separation of concerns.

For a detailed explanation of the architecture, design patterns, and data flow, see the **[Architecture Guide](documentations/architecture.md)**.

### Layer 1: Feature Files (BDD Scenarios)
- Written in Gherkin syntax (Given-When-Then)
- Business-readable test scenarios
- Located in `src/test/resources/features/`

### Layer 2: Step Definitions (Glue Code)
- Maps Gherkin steps to Java methods
- Acts as a bridge between feature files and business logic
- Located in `src/test/java/com/automation/stepdefinitions/`

### Layer 3: Steps (Business Logic)
- Contains reusable business logic and test steps
- Uses Serenity's `@Step` annotation for reporting
- Located in `src/test/java/com/automation/steps/`

### Layer 4: Page Objects (UI Interactions)
- Implements Page Object Model design pattern
- Encapsulates web elements and page actions
- Located in `src/test/java/com/automation/pages/`

## 🔧 Prerequisites

- **Java Development Kit (JDK)**: Version 11 or higher
- **Maven**: Version 3.6 or higher
- **Git**: For version control
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code (with Java extensions)
- **Web Browser**: Chrome (default), Firefox, or Edge

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/selenium-e2e-bdd-framework-starter.git
cd selenium-e2e-bdd-framework-starter
```

### 2. Install Dependencies

```bash
mvn clean install -DskipTests
```

### 3. Run Tests

#### Run all tests:
```bash
mvn clean verify
```

#### Run with specific browser:
```bash
mvn clean verify -Dwebdriver.driver=chrome
mvn clean verify -Dwebdriver.driver=firefox
mvn clean verify -Dwebdriver.driver=edge
```

#### Run specific tags:
```bash
# Run only smoke tests
mvn clean verify -Dcucumber.filter.tags="@smoke"

# Run regression tests
mvn clean verify -Dcucumber.filter.tags="@regression"

# Run login tests
mvn clean verify -Dcucumber.filter.tags="@login"
```

#### Run specific feature file:
```bash
mvn clean verify -Dcucumber.features="src/test/resources/features/Login.feature"
```

### 4. View Test Reports

After test execution, Serenity generates comprehensive HTML reports:

```bash
# Open the report in your default browser
open target/site/serenity/index.html    # macOS
start target/site/serenity/index.html   # Windows
xdg-open target/site/serenity/index.html # Linux
```

## 🧪 Example Test Scenarios

The framework includes example test scenarios for a demo e-commerce application:

### Login Feature
- ✅ Successful login with valid credentials
- ✅ Login failure with invalid credentials
- ✅ Login failure with locked out user

### Products Feature
- ✅ View products after successful login
- ✅ Add product to shopping cart
- ✅ Logout from application

## 🎨 Design Patterns Implemented

### 1. Page Object Model (POM)
- Separates page elements and actions from test logic
- Improves maintainability and reduces code duplication
- Example: `LoginPage.java`, `ProductsPage.java`

### 2. Factory Pattern
- `DriverFactory.java` creates WebDriver instances based on browser type
- Centralizes driver initialization logic
- Supports multiple browsers (Chrome, Firefox, Edge)

### 3. Singleton Pattern
- ThreadLocal driver management for parallel execution
- Ensures one driver instance per thread

## ⚙️ Configuration

### Serenity Configuration (`serenity.conf`)

```hocon
webdriver {
  driver = chrome
  base.url = "https://www.saucedemo.com"
  timeouts {
    implicitlywait = 10000
    fluentwait = 10000
  }
}
```

### Environment-Specific Configuration

```bash
# Run tests against different environments
mvn clean verify -Denvironment=dev
mvn clean verify -Denvironment=staging
mvn clean verify -Denvironment=prod
```

## 📊 CI/CD Integration

### GitHub Actions

The framework includes a GitHub Actions workflow (`.github/workflows/test-execution.yml`) that:

- ✅ Runs on push to main/develop branches
- ✅ Runs on pull requests to main
- ✅ Supports manual workflow dispatch
- ✅ Installs dependencies and Chrome browser
- ✅ Executes all tests
- ✅ Generates and uploads Serenity reports
- ✅ Uploads screenshots on test failures
- ✅ Publishes test result summaries

## 📝 Logging

Logs are generated using SLF4J with Logback:
- Console output with color coding
- File output: `target/logs/test-execution.log`
- Configurable log levels in `logback-test.xml`

## 🔐 Best Practices Implemented

1. ✅ **Clear Separation of Concerns**: 4-layer architecture
2. ✅ **DRY Principle**: Reusable methods in BasePage and utility classes
3. ✅ **Explicit Waits**: WaitHelper class for reliable element interactions
4. ✅ **Descriptive Naming**: Clear, meaningful names for methods and variables
5. ✅ **Comprehensive Comments**: Detailed inline documentation
6. ✅ **Version Control**: Git with proper .gitignore
7. ✅ **Dependency Management**: Maven with centralized version management
8. ✅ **Reporting**: Serenity BDD's rich HTML reports with screenshots
9. ✅ **Error Handling**: Try-catch blocks where appropriate
10. ✅ **Configuration Management**: Externalized configuration files

## 🛠️ Troubleshooting

### Common Issues and Solutions

#### Issue: WebDriver not found
**Solution**: The framework uses WebDriverManager for automatic driver management. Ensure you have internet connectivity during first run.

#### Issue: Tests fail with timeout
**Solution**: Increase timeout values in `serenity.conf` or check your network connection.

#### Issue: Browser doesn't open
**Solution**: Ensure the browser is installed and update WebDriverManager version in `pom.xml`.

## 📚 Dependencies

- **Serenity BDD**: 4.1.20
- **Cucumber**: 7.14.0
- **Selenium WebDriver**: 4.15.0
- **WebDriverManager**: 5.6.2
- **JUnit**: 4.13.2 / 5.10.1
- **AssertJ**: 3.24.2
- **SLF4J**: 2.0.9
- **Logback**: 1.4.14

For complete dependency details and technology stack information, see the **[Project Summary](documentations/project_summary.md)**.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Author

Created with ❤️ for the test automation community

## 🙏 Acknowledgments

- Serenity BDD Team for the excellent reporting framework
- Cucumber Team for BDD support
- Selenium Community for WebDriver

## 📚 Additional Resources

- **[Quick Start Guide](documentations/quick_start.md)** - Fast-track setup and execution
- **[Complete File Index](documentations/index.md)** - Quick navigation to all project files
- **[Architecture Guide](documentations/architecture.md)** - Deep dive into framework design
- **[Project Summary](documentations/project_summary.md)** - Statistics and completion details

---

**Happy Testing! 🚀**

