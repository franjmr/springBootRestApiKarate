# Testing a Java Spring Boot REST API with Karate
This project contain an examples about web service tests with the Karate framework.

## Karate Framework
Karate is a tool that provide an API test-automation, mocks, performance-testing and UI automation as a framework. Use the BDD syntax and XML assertions to write the test and allow to run tests in parallel.

Test execution and report generation feels like any standard Java project.

## Setup
Integrate Karate in the project using Maven as a build tool adding two dependencies to the <b>pom.xml</b> file
```xml
<dependencies>
    <dependency>
        <groupId>com.intuit.karate</groupId>
        <artifactId>karate-apache</artifactId>
        <version>0.9.5</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.intuit.karate</groupId>
        <artifactId>karate-junit5</artifactId>
        <version>0.9.5</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

And add the surefire-plugin to the plugin section:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.2</version>
        </plugin>
    </plugins>
</build>
```
## Karate Tests
Tests consist of Java classes and feature files that describes our interaction with the service under test.

### Feature Files
Karate features are written in a DSL and will be stored in src/test/java/ so that feature files and Java tests are matched by their name and package structure. Example:
- <b>Gherkin:</b>   src/test/java/employee/assingCalendar.feature
- <b>JUnit:</b>     src/test/java/employee/EmployeeTest.java

<b>Gherkin</b>

``` Gherkin
Feature: Assign

  Scenario: Assign Employee Calendar success
    Given url 'http://localhost:9057/api/v1/employeeCalendar/assign'
    And request {PCodigoEmpleado:'M11234',PFechaInicio:'01/01/2020',PFechaFin:'28/01/2020',PCalendario1:'1',PCalendario2:'2',PCalendario3:'3',PSecuencia:1}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Sin error","PSCodigoError":"0"}
```

### JUnit Integration
All we need to do to integrate JUnit is to create a test class addressing our corresponding JUnit runner so that a minimal approach could look like the following class.

<b>JUnit</b>

```java 
package employee;

import com.intuit.karate.junit5.Karate;

public class EmployeeTest {
	@Karate.Test
	Karate assingCalendar() {
		return Karate.run("assingCalendar").relativeTo(getClass());
	}
}
```

## Run Tests
Using Maven in the command line as follows:

```cmd
$ mvn test 
```

## Reports
Karate uses the surefire-plugin to generate standard reports in XML format that may be processed by standard mechanisms of common integration servers. Also generate HTML files to view the tests detail in a browser.

```
target/surefire-reports
├── employee.AssignCalendar.html
├── employee.EmployeeTest.txt
└── TEST-employee.EmployeeTest.xml
```