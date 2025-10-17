# Quick Start Guide

This guide will help you get started with the Selenium E2E BDD Framework quickly.

## Prerequisites Check

```bash
# Check Java version (should be 11 or higher)
java -version

# Check Maven version (should be 3.6 or higher)
mvn -version

# Check if Chrome is installed
google-chrome --version  # Linux
/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --version  # macOS
```

## Setup Steps

### 1. Clone and Navigate
```bash
git clone https://github.com/yourusername/selenium-e2e-bdd-framework-starter.git
cd selenium-e2e-bdd-framework-starter
```

### 2. Install Dependencies
```bash
mvn clean install -DskipTests
```

### 3. Run Your First Test
```bash
# Run all tests
mvn clean verify

# Run only smoke tests
mvn clean verify -Dcucumber.filter.tags="@smoke"
```

### 4. View Test Reports
After tests complete, open the Serenity report:

**macOS:**
```bash
open target/site/serenity/index.html
```

**Windows:**
```bash
start target/site/serenity/index.html
```

**Linux:**
```bash
xdg-open target/site/serenity/index.html
```

## Running Tests with Different Browsers

```bash
# Chrome (default)
mvn clean verify -Dwebdriver.driver=chrome

# Firefox
mvn clean verify -Dwebdriver.driver=firefox

# Edge
mvn clean verify -Dwebdriver.driver=edge
```

## Running Specific Tests

### By Tag
```bash
# Smoke tests only
mvn clean verify -Dcucumber.filter.tags="@smoke"

# Login tests only
mvn clean verify -Dcucumber.filter.tags="@login"

# Regression tests only
mvn clean verify -Dcucumber.filter.tags="@regression"

# Exclude certain tests
mvn clean verify -Dcucumber.filter.tags="not @skip"
```

### By Feature File
```bash
# Run only Login feature
mvn clean verify -Dcucumber.features="src/test/resources/features/Login.feature"

# Run only Products feature
mvn clean verify -Dcucumber.features="src/test/resources/features/Products.feature"
```

## IDE Setup

### IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → Select project folder
3. Wait for Maven to import dependencies
4. Install Cucumber for Java plugin (File → Settings → Plugins)
5. Right-click on `TestRunner.java` → Run

### Eclipse
1. Open Eclipse
2. File → Import → Maven → Existing Maven Projects
3. Select project folder
4. Install Cucumber Eclipse Plugin from Marketplace
5. Right-click on `TestRunner.java` → Run As → JUnit Test

### VS Code
1. Open VS Code
2. Open project folder
3. Install extensions:
   - Extension Pack for Java
   - Cucumber (Gherkin) Full Support
4. Open `TestRunner.java` and click Run

## Common Commands

```bash
# Clean build
mvn clean

# Compile only (no tests)
mvn compile

# Compile test code
mvn test-compile

# Run tests without generating report
mvn test

# Run tests with Serenity report
mvn clean verify

# Generate report from existing test results
mvn serenity:aggregate

# Skip tests during build
mvn clean install -DskipTests

# Run tests in parallel (2 threads)
mvn clean verify -Dparallel.tests=2
```

## Environment Configuration

### Change Base URL
```bash
mvn clean verify -Dwebdriver.base.url="https://your-test-environment.com"
```

### Change Environment
```bash
# Dev environment
mvn clean verify -Denvironment=dev

# Staging environment
mvn clean verify -Denvironment=staging

# Production environment
mvn clean verify -Denvironment=prod
```

## Troubleshooting

### Issue: Tests fail immediately
**Solution:** Check if Chrome browser is installed and WebDriverManager can download drivers (requires internet).

### Issue: "No tests were found"
**Solution:** Ensure feature files are in `src/test/resources/features/` and runner is in the correct package.

### Issue: Compilation errors
**Solution:** Run `mvn clean install -DskipTests` to download all dependencies.

### Issue: Browser doesn't close after test
**Solution:** This is normal behavior when debugging. Serenity automatically closes browsers after test completion.

## Writing Your First Test

### 1. Create Feature File
Create `MyFirst.feature` in `src/test/resources/features/`:

```gherkin
Feature: My First Test
  
  @smoke
  Scenario: Verify homepage loads
    Given user is on the login page
    Then user should see the login page
```

### 2. Run Your Test
```bash
mvn clean verify -Dcucumber.filter.tags="@smoke"
```

### 3. View Results
Open `target/site/serenity/index.html` to see detailed test results.

## Next Steps

1. Read the full [README.md](README.md) for detailed documentation
2. Explore the example feature files in `src/test/resources/features/`
3. Review page objects in `src/test/java/com/automation/pages/`
4. Customize `serenity.conf` for your application
5. Add your own test scenarios

## Getting Help

- Check logs in `target/logs/test-execution.log`
- Review Serenity reports for detailed failure analysis
- Check screenshots in `target/site/serenity/screenshots/` for failures
- Read Serenity documentation: https://serenity-bdd.info
- Read Cucumber documentation: https://cucumber.io/docs

---

**Happy Testing! 🚀**

