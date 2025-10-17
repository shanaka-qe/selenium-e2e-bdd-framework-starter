# Contributing to Selenium E2E BDD Framework

Thank you for your interest in contributing to this project! This guide will help you get started with contributing to the Selenium E2E BDD Framework.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [How to Contribute](#how-to-contribute)
- [Development Workflow](#development-workflow)
- [Coding Standards](#coding-standards)
- [Commit Guidelines](#commit-guidelines)
- [Pull Request Process](#pull-request-process)
- [Testing Guidelines](#testing-guidelines)

## 🤝 Code of Conduct

By participating in this project, you agree to maintain a respectful and inclusive environment for all contributors.

### Our Standards

- ✅ Use welcoming and inclusive language
- ✅ Be respectful of differing viewpoints and experiences
- ✅ Gracefully accept constructive criticism
- ✅ Focus on what is best for the community
- ✅ Show empathy towards other community members

### Unacceptable Behavior

- ❌ Trolling, insulting/derogatory comments, and personal attacks
- ❌ Public or private harassment
- ❌ Publishing others' private information without permission
- ❌ Other conduct which could reasonably be considered inappropriate

## 🚀 Getting Started

### Prerequisites

Before contributing, ensure you have:

- ✅ **Java JDK 11+** installed
- ✅ **Maven 3.6+** installed
- ✅ **Git** installed
- ✅ **IDE** (IntelliJ IDEA, Eclipse, or VS Code)
- ✅ Basic understanding of Java and Selenium
- ✅ Familiarity with BDD/Gherkin syntax

### Setup

1. **Fork the repository**
   ```bash
   # Click the "Fork" button on GitHub
   ```

2. **Clone your fork**
   ```bash
   git clone https://github.com/yourusername/selenium-e2e-bdd-framework-starter.git
   cd selenium-e2e-bdd-framework-starter
   ```

3. **Add upstream remote**
   ```bash
   git remote add upstream https://github.com/originalowner/selenium-e2e-bdd-framework-starter.git
   ```

4. **Install dependencies**
   ```bash
   mvn clean install -DskipTests
   ```

5. **Set up environment**
   ```bash
   cp env.example .env
   # Edit .env with your configuration
   ```

6. **Run tests to verify setup**
   ```bash
   mvn clean verify -Dcucumber.filter.tags="@smoke"
   ```

## 🛠️ How to Contribute

### Types of Contributions

We welcome various types of contributions:

- 🐛 **Bug fixes** - Fix existing issues
- ✨ **New features** - Add new functionality
- 📝 **Documentation** - Improve or add documentation
- 🧪 **Tests** - Add or improve test coverage
- 🎨 **Code refactoring** - Improve code quality
- 🔧 **Configuration** - Improve build or configuration
- 💡 **Ideas** - Suggest new features or improvements

### Reporting Bugs

Before creating bug reports, please check existing issues. When creating a bug report, include:

- **Clear title and description**
- **Steps to reproduce**
- **Expected vs actual behavior**
- **Screenshots** (if applicable)
- **Environment details** (OS, Java version, browser version)
- **Error logs or stack traces**

**Bug Report Template:**
```markdown
**Description:**
A clear description of the bug

**Steps to Reproduce:**
1. Go to '...'
2. Click on '...'
3. See error

**Expected Behavior:**
What should happen

**Actual Behavior:**
What actually happens

**Environment:**
- OS: [e.g., Windows 10, macOS 14]
- Java Version: [e.g., 11.0.18]
- Browser: [e.g., Chrome 120]
- Framework Version: [e.g., 1.0.0]

**Logs:**
```
Paste relevant logs here
```
```

### Suggesting Enhancements

Enhancement suggestions are welcome! Include:

- **Clear title and description**
- **Use cases** - Why this enhancement is useful
- **Proposed solution** - How it could be implemented
- **Alternatives** - Other solutions you've considered

## 📝 Development Workflow

### Branching Strategy

We follow a feature branch workflow:

```bash
# Update your fork
git fetch upstream
git checkout main
git merge upstream/main

# Create a feature branch
git checkout -b feature/your-feature-name

# Or for bug fixes
git checkout -b bugfix/issue-number-description
```

### Branch Naming Convention

- `feature/feature-name` - New features
- `bugfix/issue-number-description` - Bug fixes
- `docs/documentation-topic` - Documentation updates
- `refactor/description` - Code refactoring
- `test/test-description` - Test additions

### Making Changes

1. **Make your changes** in your feature branch
2. **Follow coding standards** (see below)
3. **Add tests** for new functionality
4. **Update documentation** if needed
5. **Ensure all tests pass**

```bash
# Run tests
mvn clean verify

# Run specific test suite
mvn verify -Dcucumber.filter.tags="@smoke"
```

## 💻 Coding Standards

### Java Code Style

- ✅ Follow **Java naming conventions**
- ✅ Use **descriptive variable and method names**
- ✅ Write **comprehensive JavaDoc** comments
- ✅ Keep methods **short and focused** (single responsibility)
- ✅ Use **proper exception handling**
- ✅ Follow **DRY principle** (Don't Repeat Yourself)

### Example:

```java
/**
 * Navigate to the login page
 * Opens the application URL and verifies page loaded
 */
@Step("Navigate to the login page")
public void navigateToLoginPage() {
    // Open the application URL
    loginPage.navigateToLoginPage();
    
    // Log the navigation action
    logger.info("User navigated to login page");
}
```

### BDD/Gherkin Style

- ✅ Write **business-readable** scenarios
- ✅ Use **Given-When-Then** format
- ✅ Keep scenarios **independent and isolated**
- ✅ Use **descriptive step names**
- ✅ Add **appropriate tags** (@smoke, @regression, etc.)

### Example:

```gherkin
@smoke @login
Scenario: Successful login with valid credentials
  Given user is on the login page
  When user enters valid username "standard_user" and password "secret_sauce"
  Then user should be on the products page
  And user should see page title "Products"
```

### Documentation Style

- ✅ Use **clear and concise language**
- ✅ Include **code examples**
- ✅ Add **tables** for structured information
- ✅ Use **emojis** sparingly for readability
- ✅ Keep **documentation up-to-date**

## 📦 Commit Guidelines

### Commit Message Format

Follow conventional commits format:

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Build process or auxiliary tool changes
- `ci`: CI/CD changes

### Examples

```bash
# Good commit messages
feat(api): add REST Assured support for API testing
fix(login): resolve authentication timeout issue
docs(readme): update installation instructions
test(products): add test for cart functionality

# Bad commit messages (avoid these)
fix stuff
updated files
changes
```

### Commit Best Practices

- ✅ Write clear, descriptive messages
- ✅ Use present tense ("add feature" not "added feature")
- ✅ Keep subject line under 50 characters
- ✅ Use body to explain "what" and "why" (not "how")
- ✅ Reference issues and pull requests

## 🔄 Pull Request Process

### Before Submitting

1. ✅ Ensure all tests pass locally
2. ✅ Update documentation if needed
3. ✅ Add/update tests for your changes
4. ✅ Follow code style guidelines
5. ✅ Rebase on latest main branch

### Submitting Pull Request

1. **Push your changes**
   ```bash
   git push origin feature/your-feature-name
   ```

2. **Create Pull Request** on GitHub

3. **Fill out PR template** with:
   - Description of changes
   - Related issues
   - Testing performed
   - Screenshots (if applicable)

### PR Template

```markdown
## Description
Brief description of changes

## Related Issues
Fixes #123
Related to #456

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Refactoring

## Testing
- [ ] All existing tests pass
- [ ] New tests added
- [ ] Manual testing performed

## Checklist
- [ ] Code follows project style guidelines
- [ ] Self-review completed
- [ ] Comments added for complex code
- [ ] Documentation updated
- [ ] No new warnings generated
```

### Review Process

- Maintainers will review your PR
- Address any feedback or requested changes
- Once approved, PR will be merged

## 🧪 Testing Guidelines

### Test Coverage

- ✅ Add tests for all new features
- ✅ Update tests for modified functionality
- ✅ Ensure tests are independent and isolated
- ✅ Use appropriate test tags

### Running Tests

```bash
# Run all tests
mvn clean verify

# Run smoke tests
mvn verify -P smoke

# Run regression tests
mvn verify -P regression

# Run API tests
mvn verify -P api

# Run with specific environment
mvn verify -P dev
mvn verify -P staging
```

### Writing Good Tests

```java
// Good test example
@Test
public void shouldLoginSuccessfullyWithValidCredentials() {
    // Given: User is on login page
    loginPage.navigateToLoginPage();
    
    // When: User enters valid credentials
    loginPage.performLogin("standard_user", "secret_sauce");
    
    // Then: User is redirected to products page
    assertThat(productsPage.isDisplayed()).isTrue();
    assertThat(productsPage.getPageTitle()).isEqualTo("Products");
}
```

## 🎓 Learning Resources

### Framework Documentation

- [README.md](README.md) - Project overview
- [documentations/quick_start.md](documentations/quick_start.md) - Quick start guide
- [documentations/architecture.md](documentations/architecture.md) - Architecture details

### External Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [Serenity BDD Documentation](https://serenity-bdd.info)
- [REST Assured Documentation](https://rest-assured.io)

## 💬 Getting Help

### Communication Channels

- **GitHub Issues** - Bug reports and feature requests
- **GitHub Discussions** - General questions and discussions
- **Pull Request Comments** - Code review discussions

### Questions?

If you have questions:

1. Check existing documentation
2. Search closed issues
3. Ask in GitHub Discussions
4. Create a new issue with "question" label

## 🏆 Recognition

Contributors will be recognized in:

- Project README contributors section
- Release notes
- GitHub contributors page

## 📄 License

By contributing, you agree that your contributions will be licensed under the MIT License.

---

**Thank you for contributing to the Selenium E2E BDD Framework!** 🎉

Your contributions help make this framework better for everyone.

