# Chegg Engineering Intern - Programming Assignment - Summer 2022

## Project Dependencies

Project has below dependencies:
- Java JDK 11
- Maven 3.6.3
- Spring Boot 2.6.2
- PostgreSQL

## Features Implemented

Along with the CRUD functionalities on User, this project also implements the **ability to manage school and course data, also manage how they are related to the user** 

## Technologies/Libraries Used
All the libraries and dependencies can be found in `pom.xml` file. Below are the major ones:

- Spring Boot
- JPA
- Spring Validation
- PostgreSQL
- Lombok
- JUnit 5

## Design
This project uses JPA to define following relationship between models as follows:
  1. Course - School : ManyToMany
  2. Course - Student : ManyToMany
  3. Professor - School : ManyToMany
  4. School - Student : OneToMany

## About the Code

- All the repositories are defined in `repository` package.
- All the controllers are defined in `controller` package.
  - JavaDocs are available on each controller.
  - There is a central `ExceptionHandlingController` where all the exception handling logic is defined for the entire server.
- All the services/business_logics are defined in `service` package.
- All the custom exceptions are defined in `exception` package.
- All the DTOs are defined in `dto` package.
- All the models are defined in `model` package.
- Junit tests are written for each service.

## Running the application locally
- Install PostgreSQL.
- Create a database and update the details in `application.properties` file. For starter, you can create a db with `cheggschooldb` name.
- The easiest way to run this project is to download [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) and open this project by using `File -> Open -> CheggSchoolSystem`. It will take a couple of minutes to download all the dependencies using maven. Once they are downloaded run `CheggSchoolApplication`.

**Project URL:** [http://127.0.0.1:8080/](http://127.0.0.1:8080/)

## How to?
- Create Dummy data by opening [http://127.0.0.1:8080/dummyData](http://127.0.0.1:8080/dummyData).

## List of APIs supported by back-end
- Add a student
    - API: 
    - Method: POST
    - Request JSON Body:     
  ```json
  {
    "name": "Renuka",
    "email": "renuka@gmail.com",
    "schoolName": "Test School",
    "isProfessor": FALSE
  }
    ```
  
- Add a professor
  - API: 
  - Method: POST
  - Request JSON Body:
  ```json
  {
    "name": "Srishti",
    "email": "srishti@gmail.com",
    "schoolName": "Test School"
    "courseTaught": ["SubA", "SubB", "SubC", "SubD"],
    "isProfessor": TRUE
  }
    ```
  
- Update user: Student
  - API: 
  - Method: POST
  - Request JSON Body:
  ```json
  
    ```
  
- Update a user: Professor
  - API: 
  - Method: 
  
- List the users: Students
  - API: 
  - Method: 

- List the users: Professors
  - API: 
  - Method: 

- Delete a user: Professor
  - API: 
  - Method: 

- Delete a user: Student
  - API: 
  - Method: 

- Find all the students in the given school
  - API: 
  - Method: 
  - Request JSON Body:
  ```json
  
    ```
  
- Find Students
  - API: 
  - Method: 
  - Request JSON Body:
  ```json
  
    ```

- Find Professors
  - API: 
  - Method: 
  - Request JSON Body:
  ```json
  
    ```

- Find all the courses taught by a Professor
  - API: 
  - Method: 

- Find all the courses taken by a student
  - API: 
  - Method: 

- Create Dummy Data for testing.
  - API: 
  - Method: GET

**Note:** A postman collection is available with all the APIs.
