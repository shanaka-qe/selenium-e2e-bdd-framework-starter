# Selenium E2E BDD Framework with Serenity and Cucumber

![Java](https://img.shields.io/badge/Java-11-blue?style=flat-square&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.15.0-green?style=flat-square&logo=selenium)
![Serenity BDD](https://img.shields.io/badge/Serenity%20BDD-4.1.20-orange?style=flat-square)
![Cucumber](https://img.shields.io/badge/Cucumber-7.14.0-brightgreen?style=flat-square&logo=cucumber)
![REST Assured](https://img.shields.io/badge/REST%20Assured-5.4.0-blue?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.6+-red?style=flat-square&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

**Enterprise-grade test automation framework for multi-application testing with Selenium, Serenity BDD, Cucumber, and REST Assured**

**Author:** Shanaka Fernando  
**LinkedIn:** https://www.linkedin.com/in/shanaka-qe/

A comprehensive, production-ready Selenium test automation framework using BDD (Behavior-Driven Development) with Serenity BDD and Cucumber. This framework follows industry best practices and design patterns for maintainable, scalable test automation.

## 🎯 Features

- ✅ **BDD Framework**: Cucumber with Serenity BDD for behavior-driven testing
- ✅ **API Testing**: REST Assured integration for comprehensive API testing
- ✅ **Design Patterns**: Page Object Model, Factory Pattern, Singleton Pattern
- ✅ **Clear Layer Separation**: Feature files, Step Definitions, Steps, and Page Objects
- ✅ **Environment Management**: Dev, Staging, Prod configurations with .env support
- ✅ **Comprehensive Reporting**: Serenity BDD's detailed HTML reports with screenshots
- ✅ **Multi-Platform CI/CD**: GitHub Actions, GitLab CI, and Jenkins pipelines
- ✅ **Cross-Browser Support**: Chrome, Firefox, Edge with automatic driver management
- ✅ **Parallel Execution**: ThreadSafe design for concurrent test execution
- ✅ **Logging**: SLF4J with Logback for detailed test execution logs
- ✅ **Utility Classes**: Reusable helpers for common operations
- ✅ **Maven Profiles**: Smoke, Regression, API test execution profiles
- ✅ **Configuration Management**: Externalized configuration with environment variables

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
│       │           ├── api/             # REST API Testing
│       │           │   ├── ApiSteps.java
│       │           │   └── BaseAPI.java
│       │           ├── config/          # Environment Configuration
│       │           │   ├── DevEnvironment.java
│       │           │   ├── EnvironmentConfig.java
│       │           │   ├── EnvironmentFactory.java
│       │           │   ├── ProdEnvironment.java
│       │           │   └── StagingEnvironment.java
│       │           ├── factory/         # Factory Pattern for driver management
│       │           │   └── DriverFactory.java
│       │           ├── pages/           # Page Object Model (Layer 4)
│       │           │   ├── BasePage.java
│       │           │   ├── LoginPage.java
│       │           │   └── ProductsPage.java
│       │           ├── runners/         # Test Runners
│       │           │   └── TestRunner.java
│       │           ├── stepdefinitions/ # Step Definitions - Glue Code (Layer 2)
│       │           │   ├── ApiStepDefinitions.java
│       │           │   ├── Hooks.java
│       │           │   ├── LoginStepDefinitions.java
│       │           │   └── ProductsStepDefinitions.java
│       │           ├── steps/           # Business Logic Layer (Layer 3)
│       │           │   ├── LoginSteps.java
│       │           │   └── ProductsSteps.java
│       │           └── utils/           # Utility Classes
│       │               ├── ConfigReader.java
│       │               ├── EnvReader.java
│       │               └── WaitHelper.java
│       └── resources/
│           ├── features/                # Feature Files - BDD Scenarios (Layer 1)
│           │   ├── API.feature
│           │   ├── Login.feature
│           │   └── Products.feature
│           ├── logback-test.xml         # Logging configuration
│           └── serenity.properties      # Additional Serenity properties
├── .gitignore                           # Git ignore file
├── .gitlab-ci.yml                       # GitLab CI/CD pipeline
├── CONTRIBUTING.md                      # Contribution guidelines
├── env.example                          # Environment variables template
├── GETTING_STARTED.md                   # Getting started guide
├── Jenkinsfile                          # Jenkins pipeline configuration
├── LICENSE                              # MIT License
├── pom.xml                              # Maven dependencies and build configuration
├── README.md                            # Main project documentation
├── serenity.conf                        # Serenity BDD configuration
└── SETUP.md                             # Detailed setup instructions
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

### 3. Configure Environment (Optional)

```bash
# Copy environment template
cp env.example .env

# Edit with your settings (optional for demo)
nano .env
```

### 4. Run Tests

#### Run all tests:
```bash
mvn clean verify
```

#### Run with Maven profiles:
```bash
# Smoke tests (recommended for first run)
mvn verify -P smoke

# Regression tests
mvn verify -P regression

# API tests only
mvn verify -P api
```

#### Run with different environments:
```bash
# Development environment
mvn verify -P dev

# Staging environment
mvn verify -P staging

# Production environment
mvn verify -P prod
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

# Run API tests
mvn clean verify -Dcucumber.filter.tags="@api"

# Run login tests
mvn clean verify -Dcucumber.filter.tags="@login"
```

#### Run specific feature file:
```bash
mvn clean verify -Dcucumber.features="src/test/resources/features/Login.feature"
```

### 5. View Test Reports

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

### API Feature
- ✅ Verify API health check endpoint
- ✅ Create new resource via API POST request

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

The framework supports multiple environments with separate configurations:

```bash
# Copy environment template
cp env.example .env

# Edit environment variables
nano .env
```

### Environment Variables (`.env`)
```properties
APP_BASE_URL=https://www.saucedemo.com
API_BASE_URL=https://api.example.com
BROWSER=chrome
HEADLESS=false
TEST_USERNAME=standard_user
TEST_PASSWORD=secret_sauce
```

### Run Tests by Environment

```bash
# Development environment
mvn clean verify -P dev

# Staging environment
mvn clean verify -P staging

# Production environment
mvn clean verify -P prod

# CI environment (headless)
mvn clean verify -P ci
```

### Maven Profiles

```bash
# Smoke tests (fast, critical paths)
mvn verify -P smoke

# Regression tests (comprehensive)
mvn verify -P regression

# API tests only
mvn verify -P api
```

## 📊 CI/CD Integration

The framework includes comprehensive CI/CD configurations for multiple platforms:

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

### GitLab CI/CD

The `.gitlab-ci.yml` configuration provides:

- ✅ Multi-stage pipeline (build, test, report)
- ✅ Automated test execution on commits
- ✅ Serenity report generation and archiving
- ✅ Configurable test execution profiles
- ✅ Docker-based execution environment

### Jenkins

The `Jenkinsfile` provides:

- ✅ Declarative pipeline configuration
- ✅ Automated builds and test execution
- ✅ Test report publishing
- ✅ Email notifications on failures
- ✅ Parameterized builds for different environments

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

### Core Framework
- **Serenity BDD**: 4.1.20
- **Cucumber**: 7.14.0
- **Selenium WebDriver**: 4.15.0
- **WebDriverManager**: 5.6.2

### API Testing
- **REST Assured**: 5.4.0
- **JSON Path**: 5.4.0
- **JSON Schema Validator**: 5.4.0

### Testing & Assertions
- **JUnit**: 4.13.2 / 5.10.1
- **AssertJ**: 3.24.2

### Logging
- **SLF4J**: 2.0.9
- **Logback**: 1.4.14

### Utilities
- **Gson**: 2.10.1
- **Jackson**: 2.16.0
- **dotenv-java**: 3.0.0

For complete dependency details and technology stack information, see the **[Project Summary](documentations/project_summary.md)**.

## 🤝 Contributing

Contributions are welcome! Please read our [Contributing Guidelines](CONTRIBUTING.md) for details on:

- Code of Conduct
- Development workflow
- Coding standards
- Commit message conventions
- Pull request process

Quick start:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Open a Pull Request

See [CONTRIBUTING.md](CONTRIBUTING.md) for complete guidelines.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Author

Created with ❤️ for the test automation community

## 🙏 Acknowledgments

- Serenity BDD Team for the excellent reporting framework
- Cucumber Team for BDD support
- Selenium Community for WebDriver

## 📚 Additional Resources

### Framework Documentation
- **[Quick Start Guide](documentations/quick_start.md)** - Fast-track setup and execution
- **[Setup Guide](SETUP.md)** - Comprehensive installation instructions
- **[Getting Started](GETTING_STARTED.md)** - Step-by-step beginner's guide
- **[Complete File Index](documentations/index.md)** - Quick navigation to all project files
- **[Architecture Guide](documentations/architecture.md)** - Deep dive into framework design
- **[Project Summary](documentations/project_summary.md)** - Statistics and completion details

### External Resources
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Serenity BDD Documentation](https://serenity-bdd.info)
- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [REST Assured Documentation](https://rest-assured.io)

---

**Happy Testing! 🚀**

