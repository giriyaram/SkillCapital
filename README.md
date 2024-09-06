# Skill Capital - Java Spring Boot CRM Application

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

## Table of Contents
- [About the Project](#about-the-project)
- [Features](#features)
- [Built With](#built-with)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuring the Database](#configuring-the-database)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## About the Project

**Skill Capital** is a robust CRM (Customer Relationship Management) application built with Java Spring Boot. The application is designed to manage leads efficiently, allowing users to create, update, and delete leads. Additionally, the system provides comprehensive analytics, offering insights into lead management performance.

The application also integrates **Spring Security** with JWT (JSON Web Token) to ensure secure authentication and authorization.

### Features
- **Lead Management**: Create, update, and delete leads within the system.
- **Analytics**: Visualize key metrics and analytics for lead management.
- **Spring Security with JWT**: Secure user authentication and authorization.
- **RESTful API**: Expose endpoints for managing leads and retrieving analytics.

## Built With
- **Java Spring Boot**: Backend framework
- **Spring Security**: Authentication and authorization
- **JWT (JSON Web Token)**: Token-based authentication
- **Maven**: Dependency management
- **PostgreSQL**: Database


## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17+**: [Download and Install Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Maven**: [Download and Install Maven](https://maven.apache.org/install.html)
- **PostgreSQL**: [Download and Install PostgreSQL](https://www.postgresql.org/download/)
- **Node.js** (if applicable for frontend): [Download and Install Node.js](https://nodejs.org/)

### Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/DL-Super30/CRM-java-API.git
   cd skill-capital 
   ```
2. **Install Backend Dependencies**
   ```sh
   mvn clean install
   ```

### Configuring the Database

To configure the database, you'll need to update the Spring Boot application's application.properties file with your database credentials.

1. Open the application.properties file located in src/main/resources/.

2. Update the Database Configuration with your PostgreSQL credentials:

```sh 
spring.datasource.url=jdbc:postgresql://localhost:5432/skillcapital
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect 
```

3. Create the PostgreSQL Database:

- Open PostgreSQL shell and create a database:

```sh
CREATE DATABASE skillcapital;
```

### Running the Application
Once the dependencies are installed and the database is configured, you can run the application.

1. Run the Spring Boot Application
```sh
mvn spring-boot:run
```
2. Access the Application

- The application will be available at http://localhost:8081.

## Usage
Once the application is running, you can perform the following actions:

- **Create a Lead**: Add new leads to the CRM.
- **Update a Lead**: Modify existing lead information.
- **Delete a Lead**: Remove leads from the system.
- **View Analytics**: Access detailed analytics and reports on leads.

## API Endpoints

Here are some key API endpoints:

### Leads Management

- `POST /api/leads/create-lead`: Create a new lead.
- `GET /api/leads/getAllLead`: Retrieve all leads.
- `GET /api/leads/{id}`: Retrieve a specific lead by ID.
- `PUT /api/leads/updateLead`: Update a lead by ID.
- `DELETE /api/leads/{id}`: Delete a lead by ID.
- `GET /api/leads/{status}/leadstatus`: Retrieve lead status.
- `GET /api/leads/leads/count`: Retrieve leads count.

### Auth Controller
- `POST /api/v1/auth/login`: Authenticate a user and receive a JWT token.
- `POST /api/v1/auth/sign-up`: Register a user and receive a JWT token.

## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make to **Skill Capital** are greatly appreciated.

1. **Fork the Project**
2. **Create your Feature Branch** (`git checkout -b feature/AmazingFeature`)
3. **Commit your Changes** (`git commit -m 'Add some AmazingFeature'`)
4. **Push to the Branch** (`git push origin feature/AmazingFeature`)
5. **Open a Pull Request**

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Giri Yaram - [@twitter](https://x.com/GiriYaram/)  [@LinkedIn](https://linkedin.com/in/giri-yaram/) - giriyaram2@gmail.com

**Project Link:** [https://github.com/DL-Super30/CRM-java-API/tree/dev-giri](https://github.com/DL-Super30/CRM-java-API/tree/dev-giri)
