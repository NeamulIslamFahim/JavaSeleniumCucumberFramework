# Java Selenium Cucumber Framework

## Description
This project is a Java-based test automation framework utilizing Selenium for web automation and Cucumber for BDD (Behavior-Driven Development).

## Technologies Used
* Java
* Selenium WebDriver
* Cucumber BDD
* Maven (for build automation and dependency management)
* JUnit (for test execution)

## Setup Instructions
1. **Clone the repository:**
   ```bash
   git clone https://github.com/NeamulIslamFahim/JavaSeleniumCucumberFramework.git
   cd JavaSeleniumCucumberFramework
   ```
2. **Install Java Development Kit (JDK):** Ensure you have JDK 8 or higher installed.
3. **Install Maven:** Ensure you have Maven installed and configured in your system's PATH.
4. **Update Maven Dependencies:** Navigate to the project root directory and run:
   ```bash
   mvn clean install
   ```

## How to Run Tests
To execute the Cucumber tests, navigate to the project root directory and run the following Maven command:

```bash
mvn test
```

## Reporting

After running the tests, the following reports are generated:

* **Surefire Reports (XML):** Located at `target/surefire-reports/TEST-TestRunner.xml`
* **Cucumber HTML Report:** Generated with `tech.grasshopper.extentreports-cucumber7-adapter` and `io.cucumber.html-formatter`. The exact location will be provided in the console output after test execution.
