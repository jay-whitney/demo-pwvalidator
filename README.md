# Password Validation Demo Application

---

#### Overview:

This is a password validation service written in Java and using Spring Boot, IoC/DI, MVC, and Thymeleaf.
The service checks a text string for compliance to multiple password validation rules. 
The number of rules is extensible, just add additional implementations of the PasswordRule interface.

The rules currently known are:
 
1. Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
2. Must be between 5 and 12 characters in length.
3. Must not contain any sequence of characters immediately followed by the same sequence.

All artifacts are included in the zip file. The project is built using Maven and can be imported 
as a Maven project into Eclipse or IntelliJ. The project is *production ready* as a demo project.

---
 
##### JUnit Test Classes

+ PasswordControllerTest
+ LengthRuleTest
+ LowerCaseAlphaNumericOnlyRuleTest
+ RepeatedSequenceRuleTest
+ PasswordValidatorTest

---

##### Initial maven project was created using Spring Boot Initializer

http://start.spring.io/

+ Group Id: com.demo.pwvalidator
+ Artifact Id: demo-pwvalidator
+ Selected Dependencies: Web, Thymeleaf, DevTools

This dependency was later added to the pom.xml file

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>

Project developed using Spring Tool Suite

---

##### Maven Build Instructions

This project is configured for Java 1.8 so you must have Java 1.8 in your PATH.

Alternatively you can use Java 1.7 if you change the java.version at the bottom of the pom.xml file.

Execute these commands to build and run the unit tests

+ mvn clean
+ mvn test

---

##### Maven Run Instructions

Execute this command to run the application

+ mvn spring-boot:run

To manually exercise the application, open a browser and go to 

+ http://localhost:8080/password

To change the default listening port from 8080, edit application.properties and uncomment server.port=8090


---
