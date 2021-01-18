# Testing a Java Spring Boot REST API with Karate
This project contain some examples about web service tests with the Karate framework.

## Karate Framework
Karate is the only open-source tool to combine API test-automation, mocks, performance-testing and even UI automation into a single, unified framework. The BDD syntax popularized by Cucumber is language-neutral, and easy for even non-programmers. Powerful JSON & XML assertions are built-in, and you can run tests in parallel for speed.

Test execution and report generation feels like any standard Java project. But there's also a stand-alone executable for teams not comfortable with Java. You don't have to compile code. Just write tests in a simple, readable syntax - carefully designed for HTTP, JSON, GraphQL and XML. And you can mix API and UI test-automation within the same test script.

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
Tests consist of a Java class that might be recognized by the designated test framework used and a feature file that describes our interaction with the service under test.

### Feature Files
Karate features are written in a DSL and will be stored in src/test/java/ so that feature files and Java tests are matched by their name and package structure.

</br>
<b>test\java\feature\assign\assign-post.feature</b>

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

</br>
<b>test\java\feature\assing\AssignTest.java</b>

```java 
package feature.assign;

import com.intuit.karate.junit5.Karate;

public class AssignTest {
	@Karate.Test
	Karate testAssing() {
		return Karate.run("assign-post").relativeTo(getClass());
	}
}
```

## Run Tests
Using Maven in the command line as follows:

```cmd
$ mvn test 
```