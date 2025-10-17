# Project Index - Complete File Reference

Quick navigation guide to all files in the Selenium E2E BDD Framework.

---

## 📖 Documentation Files (Start Here!)

| File | Purpose | Lines | Read First |
|------|---------|-------|------------|
| `../README.md` | Main documentation, project overview, features, installation | 300+ | ⭐⭐⭐ |
| `quick_start.md` | Quick start guide, setup, first test | 150+ | ⭐⭐⭐ |
| `architecture.md` | Technical architecture, design patterns, data flow | 400+ | ⭐⭐ |
| `project_summary.md` | Completion status, statistics, highlights | 350+ | ⭐⭐ |
| `index.md` | This file - navigation guide | - | ⭐ |

**Reading Order:** `quick_start.md` → `../README.md` → `architecture.md` → `project_summary.md` → `index.md`

---

## ⚙️ Configuration Files

| File | Purpose | Format |
|------|---------|--------|
| `pom.xml` | Maven dependencies, plugins, build config | XML |
| `serenity.conf` | Serenity BDD configuration, browser settings | HOCON |
| `serenity.properties` | Additional Serenity properties | Properties |
| `logback-test.xml` | Logging configuration for SLF4J | XML |
| `.gitignore` | Git ignore rules | Text |

### Key Configuration Sections

**pom.xml:**
- Lines 17-36: Dependency versions
- Lines 38-159: Dependencies (Serenity, Cucumber, Selenium, etc.)
- Lines 161-213: Maven plugins (Compiler, Failsafe, Serenity)

**serenity.conf:**
- Lines 4-22: WebDriver configuration
- Lines 24-43: Serenity report settings
- Lines 45-56: Environment-specific URLs

---

## 🧪 Test Layer 1: Feature Files (Gherkin)

| File | Scenarios | Tags | Purpose |
|------|-----------|------|---------|
| `src/test/resources/features/Login.feature` | 3 | @smoke, @regression, @login, @negative | Login functionality tests |
| `src/test/resources/features/Products.feature` | 3 | @smoke, @regression, @products, @cart, @logout | Products page tests |

### Scenario Breakdown

**Login.feature:**
1. Successful login with valid credentials
2. Login fails with invalid credentials  
3. Login fails with locked out user

**Products.feature:**
1. User can view products after login
2. User can add product to shopping cart
3. User can logout from application

---

## 🔗 Test Layer 2: Step Definitions (Glue Code)

| File | Purpose | Step Methods | Annotations |
|------|---------|--------------|-------------|
| `src/test/java/com/automation/stepdefinitions/LoginStepDefinitions.java` | Maps login steps to Java methods | 10 | @Given, @When, @Then |
| `src/test/java/com/automation/stepdefinitions/ProductsStepDefinitions.java` | Maps product steps to Java methods | 8 | @When, @Then |
| `src/test/java/com/automation/stepdefinitions/Hooks.java` | Before/After scenario hooks | 2 | @Before, @After |

### Key Methods

**LoginStepDefinitions:**
- `userIsOnTheLoginPage()` - Navigate to login page
- `userEntersValidUsernameAndPassword()` - Login with credentials
- `userShouldSeeAnErrorMessage()` - Verify error display

**ProductsStepDefinitions:**
- `userShouldBeOnTheProductsPage()` - Verify products page
- `userAddsFirstProductToCart()` - Add product to cart
- `userLogsOut()` - Perform logout

---

## 🎯 Test Layer 3: Steps (Business Logic)

| File | Purpose | Methods | Uses @Step |
|------|---------|---------|------------|
| `src/test/java/com/automation/steps/LoginSteps.java` | Login business logic & assertions | 8 | Yes |
| `src/test/java/com/automation/steps/ProductsSteps.java` | Products business logic & assertions | 8 | Yes |

### Key Methods

**LoginSteps:**
- `navigateToLoginPage()` - Navigate to login
- `loginWithCredentials()` - Perform login
- `verifyLoginPageDisplayed()` - Verify page loaded
- `verifyErrorMessageContains()` - Assert error message

**ProductsSteps:**
- `verifyProductsPageDisplayed()` - Verify products page
- `addFirstProductToCart()` - Add product
- `verifyCartBadgeCount()` - Verify cart count
- `logout()` - Logout action

---

## 📄 Test Layer 4: Page Objects (UI Interaction)

| File | Purpose | Elements | Methods |
|------|---------|----------|---------|
| `src/test/java/com/automation/pages/BasePage.java` | Base class with common methods | 0 | 5 |
| `src/test/java/com/automation/pages/LoginPage.java` | Login page elements & actions | 5 | 9 |
| `src/test/java/com/automation/pages/ProductsPage.java` | Products page elements & actions | 7 | 10 |

### BasePage Methods (Inherited by all pages)
- `clickElement()` - Click with wait
- `enterText()` - Enter text with wait
- `getElementText()` - Get text with wait
- `isElementDisplayed()` - Check visibility

### LoginPage Methods
- `navigateToLoginPage()` - Open login page
- `enterUsername()` - Enter username
- `enterPassword()` - Enter password
- `performLogin()` - Complete login
- `getErrorMessage()` - Get error text

### ProductsPage Methods
- `isProductsPageDisplayed()` - Check page loaded
- `addFirstProductToCart()` - Add product
- `getCartBadgeCount()` - Get cart count
- `performLogout()` - Complete logout
- `getProductCount()` - Count products

---

## 🏭 Factory & Utilities

| File | Purpose | Pattern | Key Methods |
|------|---------|---------|-------------|
| `src/test/java/com/automation/factory/DriverFactory.java` | WebDriver creation & management | Factory, Singleton | 7 |
| `src/test/java/com/automation/utils/ConfigReader.java` | Configuration management | Utility | 6 |
| `src/test/java/com/automation/utils/WaitHelper.java` | Explicit wait operations | Helper | 5 |

### DriverFactory Methods
- `initializeDriver()` - Create WebDriver
- `createChromeDriver()` - Chrome instance
- `createFirefoxDriver()` - Firefox instance
- `createEdgeDriver()` - Edge instance
- `getDriver()` - Get current driver
- `quitDriver()` - Quit and cleanup

### ConfigReader Methods
- `getProperty()` - Get config value
- `getBaseUrl()` - Get base URL
- `getBrowser()` - Get browser type
- `getImplicitWait()` - Get timeout

### WaitHelper Methods
- `waitForVisibility()` - Wait for visible
- `waitForClickability()` - Wait for clickable
- `waitForInvisibility()` - Wait for invisible

---

## 🏃 Test Runner

| File | Purpose | Framework | Configuration |
|------|---------|-----------|---------------|
| `src/test/java/com/automation/runners/TestRunner.java` | Execute Cucumber tests | JUnit 4 + Serenity | @CucumberOptions |

### Runner Configuration
- **Features:** `src/test/resources/features`
- **Glue:** `com.automation.stepdefinitions`
- **Tags:** Configurable filter
- **Plugins:** Pretty, HTML, JSON, JUnit reports

---

## 🔄 CI/CD

| File | Purpose | Triggers | Steps |
|------|---------|----------|-------|
| `.github/workflows/test-execution.yml` | GitHub Actions workflow | Push, PR, Manual | 10 |

### Workflow Steps
1. Checkout code
2. Setup JDK 11
3. Install Chrome
4. Verify Maven
5. Clean and compile
6. Run tests
7. Generate Serenity reports
8. Upload test reports
9. Upload screenshots (on failure)
10. Publish test results

---

## 📊 Project Statistics

| Metric | Count |
|--------|-------|
| **Total Files** | 23 |
| **Java Files** | 12 |
| **Feature Files** | 2 |
| **Configuration Files** | 5 |
| **Documentation Files** | 5 |
| **Java Code Lines** | 1,436 |
| **Documentation Lines** | 1,250+ |
| **Test Scenarios** | 6 |
| **Page Objects** | 3 |
| **Step Definitions** | 18+ |

---

## 🗂️ Directory Structure

```
selenium-e2e-bdd-framework-starter/
│
├── .github/workflows/
│   └── test-execution.yml          # CI/CD pipeline
│
├── documentations/                  # Additional documentation
│   ├── architecture.md             # Technical architecture details
│   ├── index.md                    # This file - complete reference
│   ├── project_summary.md          # Project completion summary
│   └── quick_start.md              # Quick start guide
│
├── src/test/
│   ├── java/com/automation/
│   │   ├── factory/
│   │   │   └── DriverFactory.java  # WebDriver factory
│   │   ├── pages/
│   │   │   ├── BasePage.java       # Base page object
│   │   │   ├── LoginPage.java      # Login page object
│   │   │   └── ProductsPage.java   # Products page object
│   │   ├── runners/
│   │   │   └── TestRunner.java     # Test runner
│   │   ├── stepdefinitions/
│   │   │   ├── Hooks.java          # Before/After hooks
│   │   │   ├── LoginStepDefinitions.java
│   │   │   └── ProductsStepDefinitions.java
│   │   ├── steps/
│   │   │   ├── LoginSteps.java     # Login business logic
│   │   │   └── ProductsSteps.java  # Products business logic
│   │   └── utils/
│   │       ├── ConfigReader.java   # Config utility
│   │       └── WaitHelper.java     # Wait utility
│   │
│   └── resources/
│       ├── features/
│       │   ├── Login.feature       # Login scenarios
│       │   └── Products.feature    # Products scenarios
│       ├── logback-test.xml        # Logging config
│       └── serenity.properties     # Serenity props
│
├── .gitignore                      # Git ignore
├── documentations/                 # Documentation folder
│   ├── architecture.md             # Architecture docs
│   ├── index.md                    # This file
│   ├── project_summary.md          # Project summary
│   └── quick_start.md              # Quick start guide
├── pom.xml                         # Maven config
├── README.md                       # Main documentation
└── serenity.conf                   # Serenity config
```

---

## 🎯 Quick Command Reference

### Build & Test
```bash
mvn clean install -DskipTests      # Install dependencies
mvn clean compile                   # Compile code
mvn clean test-compile             # Compile tests
mvn clean verify                    # Run all tests
mvn serenity:aggregate             # Generate reports
```

### Run Specific Tests
```bash
mvn verify -Dcucumber.filter.tags="@smoke"      # Smoke tests
mvn verify -Dcucumber.filter.tags="@regression" # Regression tests
mvn verify -Dcucumber.filter.tags="@login"      # Login tests
```

### Browser Selection
```bash
mvn verify -Dwebdriver.driver=chrome     # Chrome
mvn verify -Dwebdriver.driver=firefox    # Firefox
mvn verify -Dwebdriver.driver=edge       # Edge
```

### Reports
```bash
open target/site/serenity/index.html           # macOS
start target/site/serenity/index.html          # Windows
xdg-open target/site/serenity/index.html       # Linux
```

---

## 🔍 Finding Things Quickly

### Need to...

**Understand the project?**
→ Start with `../README.md`

**Run your first test?**
→ Follow `quick_start.md` for fast-track setup

**Understand architecture?**
→ Read `architecture.md`

**See what's included?**
→ Check `project_summary.md`

**Add a new test?**
→ Copy from `Login.feature` example

**Create new page object?**
→ Extend `BasePage.java`

**Add new utility?**
→ Follow pattern in `utils/` package

**Configure settings?**
→ Edit `serenity.conf`

**Change dependencies?**
→ Update `pom.xml`

**Setup CI/CD?**
→ Use `.github/workflows/test-execution.yml`

---

## 📋 File Type Summary

### Documentation (5 files)
- README.md (in root)
- quick_start.md (in documentations/)
- architecture.md (in documentations/)
- project_summary.md (in documentations/)
- index.md (in documentations/)

### Configuration (5 files)
- pom.xml
- serenity.conf
- serenity.properties
- logback-test.xml
- .gitignore

### Feature Files (2 files)
- Login.feature
- Products.feature

### Java Source (12 files)
- 1 Factory
- 3 Page Objects
- 1 Test Runner
- 3 Step Definitions
- 2 Steps Classes
- 2 Utilities

### CI/CD (1 file)
- test-execution.yml

**Total: 25 files**

---

## ✅ Checklist for Getting Started

- [ ] Read ../README.md
- [ ] Install Java 11+
- [ ] Install Maven 3.6+
- [ ] Install Chrome browser
- [ ] Clone repository
- [ ] Run `mvn clean install -DskipTests`
- [ ] Run `mvn clean verify`
- [ ] Open Serenity report
- [ ] Explore example tests
- [ ] Add your first test
- [ ] Review architecture.md
- [ ] Check project_summary.md
- [ ] Explore index.md for navigation

---

## 🎓 Learning Path

### Level 1: Beginner
1. Read ../README.md for overview
2. Run example tests (see Getting Started section)
3. View Serenity reports
4. Understand feature files
5. Run tests with different tags

### Level 2: Intermediate
1. Study page objects in src/test/java/com/automation/pages/
2. Understand 4-layer architecture (see architecture.md)
3. Review index.md for complete file reference
4. Add new test scenario
5. Create new page object

### Level 3: Advanced
1. Study architecture.md thoroughly
2. Understand design patterns implementation
3. Modify framework utilities
4. Setup parallel execution
5. Customize CI/CD pipeline

---

## 📞 Need Help?

### Internal Documentation
- General questions → ../README.md
- Getting started → quick_start.md
- Technical details → architecture.md
- Project info → project_summary.md
- Navigation → index.md (this file)

### External Resources
- Serenity BDD: https://serenity-bdd.info
- Cucumber: https://cucumber.io/docs
- Selenium: https://selenium.dev/documentation

### Logs & Reports
- Test logs: `target/logs/test-execution.log`
- Serenity reports: `target/site/serenity/index.html`
- Screenshots: `target/site/serenity/screenshots/`
- Cucumber JSON: `target/cucumber-reports.json`

---

**Last Updated:** October 2025  
**Framework Version:** 1.0.0  
**Status:** ✅ Production Ready

---

*Happy Testing! 🚀*

