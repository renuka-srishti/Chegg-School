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

## List of APIs supported by back-end
- List all students in a school
  - API: /api/listAllStudentsInSchool/{schoolId}
  - Method: GET

- Update user
  - API: /api/updateUser
  - Method: POST

- List all courses
  - API: /api/listAllCourses
  - Method: GET

- Add a course
  - API: /api/addCourse
  - Method: POST

- List all courses in a school
  - API: /api/listAllCoursesInSchool/{schoolId}
  - Method: GET

- Remove student from school
  - API: /api/removeStudentFromSchool
  - Method: POST

- Add a user
  - API: /api/addUser
  - Method: POST

- Delete a user
  - API: /api/deleteUser
  - Method: GET

- List all users
  - API: /api/listAllUsers
  - Method: GET

- Add a school
  - API: /api/addSchool
  - Method: POST

- List all professors
  - API: /api/listAllProfessors
  - Method: GET

- List all students
  - API: /api/listAllStudents
  - Method: GET

- Add students to a school
  - API: /api/addStudentsToSchool
  - Method: POST

- Add professors to a school
  - API: /api/addProfessorsToSchool
  - Method: POST

- Add courses to a school
  - API: /api/addCoursesToSchool
  - Method: POST

- Delete a course
  - API: /api/deleteCourse
  - Method: POST

- List all professors in a school
  - API: /api/listAllProfessorsInSchool/{schoolId}
  - Method: GET

- List all courses
  - API: /api/listAllCourses
  - Method: GET

- Assign course to professor in a school
  - API: /api/assignCourseToProfessorInSchool
  - Method: POST

- Delete a school
  - API: /api/deleteSchool
  - Method: POST

- List all schools
  - API: /api/listAllSchools
  - Method: GET

- Update a course
  - API: /api/updateCourse
  - Method: POST

### Data
Dummy data is available in cheggschooldb file.


