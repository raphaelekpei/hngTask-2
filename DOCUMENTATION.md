# Project Documentation for hngTask-2

## Overview
This project is a Java Spring Boot application that provides API endpoints for managing person records.
It includes features for adding, updating, retrieving and deleting person information.
This documentation provides details about the API endpoints, standard request and response formats, sample usage, known limitations, and setup instructions.

# Table of Contents
1. Endpoints and Request/Response Formats
2. Sample API Usage
3. Known Limitations and Assumptions
4. Local Setup and Deployment Instructions
 
### Endpoints

POST /api
GET /api/{id}
PUT /api/{id}
DELETE /api/{id}

### 2. Sample API Usage

## Add Person

# Request:

POST /api

{
  "name": "Ekpei Raphael",
  "email": "ekpeiraphael020@gmail.com",
  "phoneNumber": "+2349093837491",
  "address": {
    "houseNumber": 37,
    "streetName": "Ajasa Street",
    "city": "Olodi-Apapa",
    "state": "Lagos",
    "country": "Nigeria"
  }
}

# Response:

{
  "id": 1,
  "message": "User with id 1 successfully created",
  "isSuccess": "true",
}

## Retrieving a Person by ID

# Request:
GET /api/1

# Response:

{
  "id": 1,
  "message": "User with id 1 successfully retrieved",
  "isSuccess": "true",
}


### Update Person by ID

# Request:
UPDATE /api/1
Content-Type: application/json
{
  "name": "Ekpei Raphael",
  "email": "ekpeiraphael020@gmail.com",
  "phoneNumber": "+2349093837491",
  "address": {
    "houseNumber": 37,
    "streetName": "Ajasa Street",
    "city": "Olodi-Apapa",
    "state": "Lagos",
    "country": "Nigeria"
}
}

# Response:

{
  "id": 1,
  "message": "User with id 1 successfully updated",
  "isSuccess": "true",
}

### Delete Person by ID

# Request:
DELETE /api/1
Content-Type: application/json

# Response:

{
  "id": 1,
  "message": "User with id 1 successfully deleted",
  "isSuccess": "true",
}

#### Known Limitations and Assumptions
- This API assumes that person records are unique based on their email addresses. 
- Age calculation is based on the provided date of birth and the current date, and it may not be 100% accurate for leap years.
- Error handling and validation messages are not detailed in the sample responses.

#### Local Setup and Deployment Instructions
To set up and deploy the hngTask-2 API locally or on a server, follow these steps:

1. Clone the repository: git clone <repository_url>
2. Navigate to the project directory: cd hngTask-2
3. Configure the database settings in application.yml
4. Build the project: ./mvnw clean install or mvn clean install (if using Maven).
5. Run the application: ./mvnw spring-boot:run or mvn spring-boot:run. 

The API will be accessible at http://localhost:7012.

Thank you for using the hngTask-2 API! If you have any questions or encounter issues, please refer to the documentation or contact the project maintainers.
