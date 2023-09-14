# Person Management System

The Person Management System is a Java-based RESTful web service that provides
functionalities for managing individual person records, including their personal information and addresses.

Table of Contents

Description
Technologies Used
Project Structure
API Endpoints
Getting Started
Contributing
License

Description

The Person Management System is designed to handle CRUD (Create, Read, Update, Delete) operations for individuals (persons).
It allows you:

Create: Add new person records with details such as name, email, phone number, address, date of birth, and automatically calculate their age.
Retrieve: Fetch person records by their ID, email, name, or phone number.
Update: Modify existing person records.
Delete: Remove person records from the system.

The system ensures data integrity and provides error handling for various scenarios, making
it a reliable solution for managing personal information.


Technologies Used

The project is built using the following technologies and frameworks:

Java: The core programming language.
Spring Boot: A popular framework for building Java applications.
Spring Data JPA: Simplifies database access using Java Persistence API.
Spring Boot Validation: Provides validation for incoming data.
MySQL: A relational database management system for data storage.
ModelMapper: Simplifies object mapping and transformation.
Lombok: Reduces boilerplate code by generating common methods.
Maven: A build automation tool for managing dependencies and building the project.

Project Structure

The project is organized into several packages:

com.raphael.hng.hngtask2.controller: Contains the REST API controllers.
com.raphael.hng.hngtask2.data.model: Defines the data models for Person and Address.
com.raphael.hng.hngtask2.service: Contains the business logic and service implementations.
resources: Contains configuration files, including application.properties.
pom.xml: Maven project configuration.

API Endpoints

The REST API exposes the following endpoints:

POST /api/person/add: Create a new person record.
GET /api/person/by-id/{id}: Retrieve a person by their ID.
GET /api/person/email/{email}: Retrieve a person by their email address.
GET /api/person/by-name/{name}: Retrieve a list of persons by their name.
GET /api/person/phone/{phone_number}: Retrieve a person by their phone number.
PUT /api/person/update/{id}: Update an existing person record.
DELETE /api/person/by-id/{id}: Delete a person by their ID.

Each endpoint serves a specific purpose in managing person data within the system.

Getting Started

To run this project locally, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Java 17 and Maven installed.
3. Configure the MySQL database connection by modifying the application.yml file in the resources folder.
4. Build and run the project using Maven:

# mvn spring-boot:run

The API will be accessible at http://localhost:7012.

Contributing
If you'd like to contribute to this project, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test thoroughly.
4. Create a pull request with a clear description of your changes.
5. Be open to feedback and code reviews.

Thank you!
