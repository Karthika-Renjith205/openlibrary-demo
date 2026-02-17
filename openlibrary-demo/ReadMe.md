# Java API Automation Framework

https://github.com/Karthika-Renjith205/openlibrary-demo

This is a **Java Maven API Automation Framework** built using **RestAssured** for validating RESTful API requests. The framework also integrates **Allure Reports** for detailed test reporting and GitHub Actions for CI/CD.

---

## **Project Structure**

Java-Api-Automation/
├── src
│ ├── main/java         # API clients and utilities
│ └── test/java         # Step definitions for BDD tests
│ └── test/resources            #  configuration files
│       └── features            # .feature files for API scenarios
├── target              # Maven build output
├── pom.xml             # Maven configuration
└── .github/workflows   # CI/CD GitHub Actions pipeline

### **Prerequisites**

- Java 17 or higher  
- Maven 3.x  
- Git  
- Optional: VS code / IntelliJ IDEA / Eclipse IDE

---

### **Clone the repository**

bash
git clone https://github.com/<username>/<repo>.git
cd <repo>

Run Tests Locally : mvn clean test

Test results will be generated in: target/allure-results

Generate Allure Report: mvn allure:report

HTML report will be created in: target/site/allure-maven-plugin

Open in browser:  open target/site/allure-maven-plugin/index.html

CI/CD Integration
-------------------

The framework is integrated with GitHub Actions.

Workflow triggers on:
on:
  pull_request:
    branches: [ main ]
