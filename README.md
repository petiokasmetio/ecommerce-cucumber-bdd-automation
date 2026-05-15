# eCommerce Cucumber BDD Automation

Java-based UI test automation project using Selenium WebDriver, Cucumber BDD, Gherkin, TestNG and Maven.

This project demonstrates behavior-driven test automation for common e-commerce/admin workflows such as login and customer management.

## Disclaimer

This project is created for QA automation practice, learning and portfolio demonstration purposes.

It does not contain real customer data, real production credentials, real business data or confidential project information.

Any test data used in this repository is synthetic and intended only for demonstration purposes.

## Overview

The project demonstrates how Cucumber BDD can be used to describe and automate business-readable test scenarios.

The automation is organized around Gherkin feature files, step definitions, page classes and test runners.

The main goal of this project is to show a structured BDD automation approach for UI-based application testing.

## Key Features

- Cucumber BDD test automation
- Gherkin feature files
- Selenium WebDriver UI automation
- Java-based step definitions
- Maven project structure
- TestNG test execution
- Page Object style organization
- Login flow automation
- Customer management flow automation
- Configurable test settings
- Logging configuration
- Generated reports excluded from version control

## Technologies Used

- Java
- Selenium WebDriver
- Cucumber
- Gherkin
- TestNG
- Maven
- Log4j
- Properties-based configuration

## Automated Test Areas

The project includes BDD scenarios for areas such as:

```text
Login functionality
Customer management
Form interactions
UI validation
End-to-end user flows
```

## BDD Approach

Test scenarios are written in Gherkin syntax, making them easier to understand by both technical and non-technical stakeholders.

Example Gherkin structure:

```gherkin
Feature: Login

  Scenario: Successful login with valid credentials
    Given the user opens the application login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be successfully logged in
```

## Project Structure

```text
ecommerce-cucumber-bdd-automation
├── Features
│   ├── Customers.feature
│   └── Login.feature
├── src
│   └── test
│       └── java
│           └── ...
├── config.properties
├── log4j.properties
├── pom.xml
├── README.md
└── .gitignore
```

## Main Components

### Feature Files

The `Features` folder contains Gherkin scenarios that describe the expected behavior of the application.

Examples:

```text
Login.feature
Customers.feature
```

### Step Definitions

Step definition classes connect Gherkin steps with Java automation code.

They translate business-readable scenarios into executable Selenium actions.

### Page Objects

Page classes are used to organize UI elements and actions.

This helps keep test logic more readable, reusable and maintainable.

### Configuration

The project uses configuration files for environment and runtime settings, such as browser configuration, application URL and other test setup values.

### Logging

Log4j configuration is included to support logging during test execution.

## How to Run

Make sure the following are installed:

- Java
- Maven
- Google Chrome or another supported browser

Clone the repository:

```bash
git clone https://github.com/petiokasmetio/ecommerce-cucumber-bdd-automation.git
cd ecommerce-cucumber-bdd-automation
```

Run the tests:

```bash
mvn clean test
```

## Generated Reports and Logs

Generated reports, logs and runtime output are excluded from version control.

The following folders/files are ignored:

```text
target/
test-output/
junit_xml_output/
json_output/
Log/
*.log
```

## QA Skills Demonstrated

This project demonstrates:

- BDD test automation
- Cucumber and Gherkin usage
- Selenium WebDriver UI automation
- Java test automation
- TestNG test execution
- Maven-based project setup
- Page Object style organization
- feature file design
- step definition implementation
- configuration handling
- logging setup
- e-commerce/admin workflow testing
- practical QA automation mindset

## Current Project Status

Current version:

- Java Maven project
- Selenium WebDriver automation
- Cucumber BDD feature files
- TestNG execution
- login flow scenarios
- customer management scenarios
- configuration and logging support

## Limitations

Current limitations:

- no CI/CD pipeline yet
- no advanced reporting setup yet
- no screenshots on failure yet
- limited cross-browser support
- limited negative scenarios
- test stability depends on UI/application availability
- generated reports are not committed to the repository

## Potential Future Improvements

Possible next improvements:

- add GitHub Actions build pipeline
- add Allure or Cucumber HTML reporting
- add screenshots on failure
- improve Page Object Model structure
- add more negative test scenarios
- add cross-browser execution
- add headless browser execution
- add test data management
- add environment-based configuration
- add retry logic for unstable UI behavior
- add more business-readable Gherkin scenarios

## Author

Petar Nikolov

Test Automation Engineering Analyst with experience in ERP and banking systems, Java/Python automation, Selenium, API testing, Cucumber BDD, QA tooling, XML test data generation and business-critical software testing.