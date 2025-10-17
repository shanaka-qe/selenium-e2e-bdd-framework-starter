# Framework Setup Guide

Comprehensive setup instructions for the Selenium E2E BDD Framework.

## ⚠️ Important: This is a Starter Template

This repository is a **starter template** providing a complete framework architecture with best practices. You can use it as-is for demo purposes or customize it for your specific application.

## 🔧 System Requirements

### Required Software

| Software | Minimum Version | Recommended Version | Download Link |
|----------|----------------|---------------------|---------------|
| Java JDK | 11 | 11 or 17 | [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/) |
| Maven | 3.6 | 3.9+ | [Apache Maven](https://maven.apache.org/download.cgi) |
| Git | 2.x | Latest | [Git Downloads](https://git-scm.com/downloads) |
| Chrome | Latest | Latest | [Google Chrome](https://www.google.com/chrome/) |

### Optional Software

- **IDE**: IntelliJ IDEA (recommended), Eclipse, or VS Code
- **Firefox/Edge**: For cross-browser testing
- **Docker**: For containerized test execution

## 🚀 Installation Steps

### Step 1: Verify Prerequisites

```bash
# Check Java installation
java -version
# Should show: java version "11.x.x" or higher

# Check Maven installation
mvn -version
# Should show: Apache Maven 3.6.x or higher

# Check Git installation
git --version
# Should show: git version 2.x.x

# Check Chrome installation
google-chrome --version  # Linux
"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" --version  # macOS
```

### Step 2: Clone Repository

```bash
# Clone the repository
git clone https://github.com/your username/selenium-e2e-bdd-framework-starter.git

# Navigate to project directory
cd selenium-e2e-bdd-framework-starter
```

### Step 3: Install Dependencies

```bash
# Install all Maven dependencies
mvn clean install -DskipTests

# This will download:
# - Selenium WebDriver
# - Serenity BDD
# - Cucumber
# - REST Assured
# - All other dependencies
```

### Step 4: Configure Environment

```bash
# Copy environment template
cp env.example .env

# Edit .env file with your settings (optional for demo)
nano .env  # or use any text editor
```

### Step 5: Verify Setup

```bash
# Compile the project
mvn clean compile

# Compile tests
mvn test-compile

# Run smoke tests
mvn verify -P smoke
```

## 🎯 IDE Setup

### IntelliJ IDEA (Recommended)

1. **Import Project**
   - File → Open → Select project folder
   - IntelliJ will automatically detect Maven project

2. **Install Plugins**
   - File → Settings → Plugins
   - Search and install:
     - Cucumber for Java
     - Gherkin
     - Lombok

3. **Configure JDK**
   - File → Project Structure → Project
   - Set Project SDK to Java 11+

4. **Enable Annotation Processing**
   - File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors
   - Check "Enable annotation processing"

5. **Run Tests from IDE**
   - Right-click `TestRunner.java` → Run
   - Or right-click feature file → Run Feature

### Eclipse

1. **Import Maven Project**
   - File → Import → Maven → Existing Maven Projects
   - Select project directory

2. **Install Plugins**
   - Help → Eclipse Marketplace
   - Search and install:
     - Cucumber Eclipse Plugin
     - TestNG (if needed)

3. **Configure JDK**
   - Right-click project → Properties → Java Build Path
   - Add JDK 11+ to Libraries

4. **Run Tests**
   - Right-click `TestRunner.java` → Run As → JUnit Test

### VS Code

1. **Open Project**
   - File → Open Folder → Select project directory

2. **Install Extensions**
   - Extension Pack for Java
   - Cucumber (Gherkin) Full Support
   - Maven for Java
   - Test Runner for Java

3. **Configure Java**
   - Open Command Palette (Ctrl+Shift+P)
   - Java: Configure Java Runtime
   - Select Java 11+

4. **Run Tests**
   - Open `TestRunner.java`
   - Click "Run" above test class

## 🔐 Environment Configuration

### Configuration Priority

The framework reads configuration in this order:

1. **System Properties** (`-Dkey=value`)
2. **.env File** (project root)
3. **System Environment Variables**
4. **Default Values** (in code)

### Example .env Configuration

```properties
# Application URLs
APP_BASE_URL=https://www.saucedemo.com
APP_DEV_URL=https://dev.saucedemo.com

# Browser settings
BROWSER=chrome
HEADLESS=false

# Test settings
ENVIRONMENT=dev
CI_MODE=false

# Timeouts
IMPLICIT_WAIT=10
PAGE_LOAD_TIMEOUT=30
```

### Using Different Environments

```bash
# Development environment
mvn verify -P dev

# Staging environment
mvn verify -P staging

# Production environment
mvn verify -P prod
```

## 🧪 Running Tests

### Basic Test Execution

```bash
# Run all tests
mvn clean verify

# Run smoke tests only
mvn verify -P smoke

# Run regression tests
mvn verify -P regression

# Run API tests
mvn verify -P api
```

### Advanced Options

```bash
# Run with specific browser
mvn verify -Dwebdriver.driver=firefox

# Run headless
mvn verify -DHEADLESS=true

# Run specific feature
mvn verify -Dcucumber.features="src/test/resources/features/Login.feature"

# Run with specific tags
mvn verify -Dcucumber.filter.tags="@smoke and @login"
```

## 📊 Viewing Reports

### Serenity Reports

```bash
# After test execution, open reports
open target/site/serenity/index.html    # macOS
start target/site/serenity/index.html   # Windows
xdg-open target/site/serenity/index.html # Linux
```

### Report Features

- ✅ Test execution summary
- ✅ Screenshots for failed tests
- ✅ Step-by-step execution details
- ✅ Performance metrics
- ✅ Tag-based filtering

## 🐛 Troubleshooting

### Common Issues

#### Issue: "Java version not supported"
**Solution:**
```bash
# Install Java 11 or higher
# Update JAVA_HOME environment variable
export JAVA_HOME=/path/to/java11  # Unix/Mac
set JAVA_HOME=C:\path\to\java11   # Windows
```

#### Issue: "Maven command not found"
**Solution:**
```bash
# Add Maven to PATH
export PATH=$PATH:/path/to/maven/bin  # Unix/Mac

# Or download Maven from https://maven.apache.org/
```

#### Issue: "WebDriver not found"
**Solution:**
The framework uses WebDriverManager for automatic driver management.
Ensure internet connectivity during first run.

#### Issue: "Tests fail with timeout"
**Solution:**
```bash
# Increase timeout in .env
IMPLICIT_WAIT=15
PAGE_LOAD_TIMEOUT=45

# Or in command line
mvn verify -DIMPLICIT_WAIT=15
```

#### Issue: "Browser doesn't open"
**Solution:**
1. Verify browser is installed
2. Check browser version compatibility
3. Clear WebDriverManager cache: `rm -rf ~/.cache/selenium/`

#### Issue: "Compilation errors"
**Solution:**
```bash
# Clean and reinstall
mvn clean install -DskipTests -U

# Force update dependencies
mvn clean install -U
```

### Getting Help

- Check [documentations/troubleshooting.md](documentations/troubleshooting.md)
- Review [README.md](README.md)
- Check existing GitHub issues
- Create new issue with error details

## 🔄 Updating Framework

### Update Dependencies

```bash
# Check for dependency updates
mvn versions:display-dependency-updates

# Update specific dependency in pom.xml
# Then run:
mvn clean install -DskipTests
```

### Pull Latest Changes

```bash
# If using from GitHub
git pull origin main

# Reinstall dependencies
mvn clean install -DskipTests
```

## 🚀 Next Steps

After successful setup:

1. ✅ Read [GETTING_STARTED.md](GETTING_STARTED.md) for quick start
2. ✅ Review example tests in `src/test/resources/features/`
3. ✅ Explore page objects in `src/test/java/com/automation/pages/`
4. ✅ Read [documentations/architecture.md](documentations/architecture.md)
5. ✅ Customize for your application

## 📞 Support

- **Documentation**: See `documentations/` folder
- **Issues**: GitHub Issues
- **Discussions**: GitHub Discussions

---

**Setup Complete!** 🎉  
You're ready to start testing!

