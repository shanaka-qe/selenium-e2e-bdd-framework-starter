# Getting Started - Quick Setup Guide

Get up and running with the Selenium E2E BDD Framework in under 10 minutes!

## ⚡ Quick Start (5 Minutes)

### Step 1: Prerequisites Check

```bash
# Verify Java (need 11+)
java -version

# Verify Maven (need 3.6+)
mvn -version

# Verify Git
git --version
```

**Don't have these installed?** See [SETUP.md](SETUP.md) for installation instructions.

### Step 2: Clone & Install

```bash
# Clone repository
git clone https://github.com/yourusername/selenium-e2e-bdd-framework-starter.git
cd selenium-e2e-bdd-framework-starter

# Install dependencies (takes 2-3 minutes)
mvn clean install -DskipTests
```

### Step 3: Run Your First Test

```bash
# Run smoke tests (takes 1-2 minutes)
mvn verify -P smoke
```

You should see tests executing! 🎉

### Step 4: View Results

```bash
# Open Serenity report
open target/site/serenity/index.html           # macOS
start target/site/serenity/index.html          # Windows
xdg-open target/site/serenity/index.html       # Linux
```

**That's it!** You've run your first tests.

---

## 📚 Understanding the Framework

### Project Structure

```
selenium-e2e-bdd-framework-starter/
├── src/test/
│   ├── java/com/automation/
│   │   ├── pages/          # Page Object Model (Layer 4)
│   │   ├── steps/          # Business Logic (Layer 3)
│   │   ├── stepdefinitions/# Glue Code (Layer 2)
│   │   ├── api/            # API Testing utilities
│   │   ├── config/         # Environment configurations
│   │   ├── utils/          # Helper utilities
│   │   └── factory/        # Driver factory
│   └── resources/
│       └── features/       # BDD Scenarios (Layer 1)
├── documentations/         # Comprehensive docs
├── pom.xml                 # Maven configuration
└── env.example             # Environment template
```

### The 4-Layer Architecture

1. **Feature Files** (Gherkin) - Business-readable tests
2. **Step Definitions** - Maps Gherkin to Java  
3. **Steps** - Business logic and assertions
4. **Page Objects** - UI interactions

## 🎯 Common Commands

### Running Tests

```bash
# All tests
mvn clean verify

# Smoke tests (fast)
mvn verify -P smoke

# Regression tests (complete)
mvn verify -P regression

# API tests
mvn verify -P api

# Specific feature
mvn verify -Dcucumber.features="src/test/resources/features/Login.feature"

# Specific tags
mvn verify -Dcucumber.filter.tags="@login"
```

### Different Browsers

```bash
# Firefox
mvn verify -Dwebdriver.driver=firefox

# Edge
mvn verify -Dwebdriver.driver=edge

# Headless Chrome
mvn verify -DHEADLESS=true
```

### Different Environments

```bash
# Development
mvn verify -P dev

# Staging
mvn verify -P staging

# Production
mvn verify -P prod
```

## 🧪 Example Test Walkthrough

### 1. Feature File (`Login.feature`)

```gherkin
Feature: User Login
  
  @smoke @login
  Scenario: Successful login
    Given user is on the login page
    When user enters valid username "standard_user" and password "secret_sauce"
    Then user should be on the products page
```

### 2. Step Definitions (`LoginStepDefinitions.java`)

```java
@When("user enters valid username {string} and password {string}")
public void userEntersCredentials(String username, String password) {
    loginSteps.loginWithCredentials(username, password);
}
```

### 3. Steps (`LoginSteps.java`)

```java
@Step("Login with username: {0}")
public void loginWithCredentials(String username, String password) {
    loginPage.performLogin(username, password);
}
```

### 4. Page Object (`LoginPage.java`)

```java
public void performLogin(String username, String password) {
    enterText(usernameField, username);
    enterText(passwordField, password);
    clickElement(loginButton);
}
```

## 🛠️ Customizing for Your App

### 1. Update Environment Settings

```bash
# Copy template
cp env.example .env

# Edit with your app details
nano .env
```

### 2. Create Your Page Object

```java
// src/test/java/com/automation/pages/YourPage.java
public class YourPage extends BasePage {
    @FindBy(id = "your-element")
    private WebElement yourElement;
    
    public void clickYourElement() {
        clickElement(yourElement);
    }
}
```

### 3. Create Your Feature

```gherkin
# src/test/resources/features/YourFeature.feature
Feature: Your Feature
  
  @smoke
  Scenario: Your test scenario
    Given I am on your page
    When I click your element
    Then I see expected result
```

### 4. Run Your Test

```bash
mvn verify -Dcucumber.features="src/test/resources/features/YourFeature.feature"
```

## 📊 Understanding Reports

### Serenity Report Sections

- **Dashboard** - Overall test summary
- **Test Results** - Detailed test outcomes
- **Features** - Feature-wise organization
- **Requirements** - Traceability
- **Tags** - Tag-based filtering

### Report Features

✅ Screenshots for failed tests  
✅ Step-by-step execution details  
✅ Performance metrics  
✅ Failure analysis  
✅ Historical trends  

## 🚀 What's Next?

### For Beginners

1. ✅ Run example tests
2. ✅ Explore feature files
3. ✅ Review page objects
4. ✅ Read [documentations/architecture.md](documentations/architecture.md)
5. ✅ Modify an existing test

### For Intermediate Users

1. ✅ Create new page object
2. ✅ Add new feature file
3. ✅ Implement step definitions
4. ✅ Run with different browsers
5. ✅ Customize configuration

### For Advanced Users

1. ✅ Extend framework utilities
2. ✅ Add API testing
3. ✅ Setup CI/CD pipeline
4. ✅ Implement parallel execution
5. ✅ Customize reporting

## 🎓 Learning Resources

### Internal Documentation

- [README.md](README.md) - Project overview
- [SETUP.md](SETUP.md) - Detailed setup guide
- [documentations/architecture.md](documentations/architecture.md) - Architecture details
- [documentations/index.md](documentations/index.md) - Complete file reference

### External Resources

- [Selenium Docs](https://www.selenium.dev/documentation/)
- [Cucumber Docs](https://cucumber.io/docs/cucumber/)
- [Serenity BDD Docs](https://serenity-bdd.info)
- [REST Assured Docs](https://rest-assured.io)

## 💡 Pro Tips

### Tip 1: Use Maven Profiles

```bash
# Instead of long commands
mvn verify -Dcucumber.filter.tags="@smoke" -Dwebdriver.driver=chrome

# Use profiles
mvn verify -P smoke
```

### Tip 2: IDE Integration

- Run tests directly from IDE
- Debug step-by-step
- Quick feature file navigation
- Autocomplete for step definitions

### Tip 3: Parallel Execution

```bash
# Run tests in parallel (future enhancement)
mvn verify -DPARALLEL_EXECUTION=true -DTHREAD_COUNT=3
```

### Tip 4: CI/CD Integration

See `.github/workflows/` for GitHub Actions examples

## ❓ Troubleshooting Quick Fixes

### Tests Won't Run?

```bash
# Clean and rebuild
mvn clean install -DskipTests
```

### Browser Won't Open?

```bash
# Check browser installation
google-chrome --version

# Clear driver cache
rm -rf ~/.cache/selenium/
```

### Compilation Errors?

```bash
# Force update dependencies
mvn clean install -U -DskipTests
```

## 📞 Getting Help

- **Documentation**: `documentations/` folder
- **Examples**: `src/test/resources/features/`
- **Issues**: GitHub Issues
- **Questions**: GitHub Discussions

---

##🎉 You're Ready!

You've completed the quick start guide. Time to explore and customize the framework for your needs!

**Happy Testing!** 🚀

