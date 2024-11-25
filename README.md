# openCart_v1.1
Opencart Application Functional Test Hybrid Framework
This repository contains a Hybrid Test Automation Framework designed to test the OpenCart v1.1 web application. The framework integrates the Page Object Model (POM) and Data-Driven Testing approaches to achieve high modularity, maintainability, and reusability.

📁 Folder Structure
Here’s an overview of the folder structure:

src/test/java
│
├── pageObjects/
│   ├── AccountPage.java
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── ProductComparisonPage.java
│   ├── RegistrationPage.java
│   └── SearchPage.java
│
├── testBase/
│   └── BaseClass.java
│
├── testCases/
│   ├── TC_PC_003.java
│   ├── TC_RF_002.java
│   ├── TC_SF_006.java
│   ├── TC_SF_008.java
│   ├── TC_SF_009.java
│   ├── TC001_AccountRegistrationTest.java
│   ├── TC002_LoginTest.java
│   └── TC003_LoginTestDDT.java
│
├── utilities/
│   ├── DataProviders.java
│   ├── ExcelUtilities.java
│   └── ExtentReportManager.java
│
src/test/resources
│   ├── config.properties
│   └── log4j2.xml
│
logs/
reports/
screenshots/
testData/

📜 Description
This framework has been built with Java, Selenium, and TestNG to test the OpenCart v1.1 application. It includes the following features:

Page Object Model (POM):
All page-related actions and locators are abstracted into separate classes under the pageObjects package.

Data-Driven Testing:
Test data is managed using Excel sheets.
The utilities/ExcelUtilities.java class provides methods to fetch and write data from Excel files.
The DataProviders.java class supplies test data dynamically.

TestNG Integration:
Test cases are written using TestNG and organized under the testCases package.
TestNG XML files are included for cross-browser, grouped, and full test suite execution.

Logging:
Configured using Log4j2 (log4j2.xml file).
Logs are saved in the logs folder.

Reports:
Test execution reports are generated using Extent Reports and saved in the reports folder.

Screenshots:
Screenshots for test failures are captured automatically and stored in the screenshots folder.

Hybrid Approach:
Combines POM with reusable utilities and TestNG for efficient testing.

🛠️ Prerequisites
Java JDK 1.8 or higher
Maven (for dependency management)
Selenium WebDriver
TestNG
Browser Drivers (e.g., ChromeDriver, GeckoDriver)

⚙️ Setup Instructions
Clone the Repository:
git clone https://github.com/your-username/your-repo.git

Install Dependencies: Ensure all dependencies are resolved via Maven:
mvn clean install

Configure the Framework:
Update the config.properties file with appropriate values:
execution_env = local/remote
username: your username
password: your password

Update the xml file to pass your desired browser and OS
Example: master_run.xml
>Update the value of parameter tag where name="browser".(<parameter name="browser" value="edge/Your desired browser" />)

Run Tests:
Use TestNG XML files in the root directory to execute test suites:
master_run.xml: Full suite execution.
crossbrowser_run.xml: Cross-browser testing.
group_run.xml: Group-specific tests.

Example command to run:
mvn test -DsuiteXmlFile=master_run.xml

📂 Key Files and Packages
1. pageObjects/
Contains classes for each page of the OpenCart application. These classes use the Page Factory pattern with @FindBy annotations to define WebElement locators.

2. testBase/
BaseClass.java:
Contains common setup and teardown methods, including browser initialization.

3. testCases/
Includes test scripts for different scenarios:
TC_PC_003.java: Product Comparison feature test.
TC_RF_002.java: Registration form validation.
TC_SF_006.java: Search functionality tests.
TC001_AccountRegistrationTest.java: End-to-end account registration.
TC003_LoginTestDDT.java: Data-driven login test.

4. utilities/
DataProviders.java: Supplies test data using @DataProvider.
ExcelUtilities.java: Provides methods for reading/writing Excel files.
ExtentReportManager.java: Configures and manages Extent Reports.

5. resources/
config.properties:
Stores application configurations.
log4j2.xml:
Configures the logging mechanism.

📝 Logging and Reporting
Logs are stored in the logs/ folder.
Extent Reports provide detailed test execution results, saved in the reports/ folder.

🚀 Features
Supports cross-browser testing.
Generates HTML reports with detailed test execution logs.
Automatically captures screenshots on test failures.
Modular design ensures ease of maintenance and scalability.

🤝 Contribution
Feel free to contribute to this framework! Open issues, submit pull requests, or suggest new features.
