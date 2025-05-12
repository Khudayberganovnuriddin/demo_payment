# Spring Boot Project

## Overview

This project is a hybrid application built using **Jakarta EE**, **Spring Data JPA**, **Spring MVC**, and **Java 21**. It is designed for enterprise-level development with **Lombok** to eliminate boilerplate code.

## Features

- **Jakarta EE**: For enterprise-grade APIs.
- **Spring Data JPA**: Simplified data access and persistence.
- **Spring MVC**: Handles web routing and application logic.
- **Lombok**: Simplifies repetitive boilerplate code.
- **Java 21**: Incorporates modern Java features.
- Relational database support.

## Requirements

Before running the application, make sure the following tools and environment are set up:

- **JDK**: Java 21
- **Gradle**: Any recent version
- **Database**: PostgreSQL (or any compatible relational database)
- **IDE**: IntelliJ IDEA 2025.1.1 Ultimate Edition is recommended

## How to Run the Project

3. **Build the Project**:
   Use the following command to build the project with Gradle:
   ```bash
   ./gradlew clean build
   ```

4. **Run the Project**:
   You can run the application using Gradle:
   ```bash
   ./gradlew bootRun
   ```
   Alternatively, you can also start the application directly through IntelliJ by running the `@SpringBootApplication` main class.

5. **Access the Application**:
    - Once the application starts, open your browser and navigate to:
      ```
      http://localhost:8081
      ```

## Running the Application with Docker and Docker Compose

### Prerequisites
Ensure the following are installed and set up on your local system:
- **Docker**: Version 20.10 or later
- **Docker Compose**: Version 1.29 or later

### Step 1: Build and Start the Application
1. Navigate to the project root directory where the `Dockerfile` and `docker-compose.yml` reside.
2. Run the following command to build and start the containers:
   ```bash
   docker-compose up --build
   ```
   This command will:
   - Build the application using the multi-stage `Dockerfile`.
   - Start two containers: the application and a PostgreSQL database.

   > **Note**: The application runs on `http://localhost:8081` and is connected to the database running on `localhost:5432`.

### Step 2: Verify the Application
1. Open a web browser and navigate to:
   ```
   http://localhost:8081
   ```
   to access the application.
2. To ensure the database connection is live, use any database client (e.g., pgAdmin, DBeaver) and connect to the database with the following credentials:
   - Host: `localhost`
   - Port: `5432`
   - Username: `postgres`
   - Password: `hayot_db`
   - Database: `postgres`

### Step 3: Stopping the Application
To stop the containers, press `Ctrl+C` in the terminal where `docker-compose` is running. Alternatively, you can stop all running containers with:


### Step 4: Persistent Database Volumes
The `volumes` section in `docker-compose.yml` ensures the database data persists even when the container is stopped or removed:
- Volume Name: `postgres_data`
- Path: `/var/lib/postgresql/data` in the container
  This allows you to retain your development database data.

### Additional Notes
1. **Environment Variables**:
   All database connection details are provided via environment variables in `docker-compose.yml`. If needed, update these values before starting the application.
2. **Health Checks**:
   Ensure that the Postgres container starts and is healthy before the application container. If needed, you can modify the `depends_on` section for additional health checks in advanced production setups.
3. **Exposed Ports**:
   - App: `8081`
   - PostgreSQL Database: `5432`

### Troubleshooting
1. **Port Conflicts**:
   - If port `8081` or `5432` is already in use, edit the `ports` section in `docker-compose.yml` to use different host ports, e.g.:
     ```yaml
     app:
       ports:
         - "8082:8081"
     postgres:
       ports:
         - "5433:5432"
     ```
2. **Docker Networking Issues**:
   - If the application container cannot connect to the database, ensure the `SPRING_DATASOURCE_URL` matches the `postgres` service name in `docker-compose.yml`.

### Cleaning Up Docker Resources
To remove all containers, networks, and volumes used by the project:

## How to Create Tables for Entities

When `spring.jpa.hibernate.ddl-auto=update` is enabled in your configuration, Hibernate will automatically generate the tables based on the JPA entities. If you wish to create the tables manually, here are the SQL statements:

-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

```
-- Table Definition
CREATE TABLE "public"."transactions" (
"id" uuid NOT NULL,
"operation_type" varchar NOT NULL CHECK ((operation_type)::text = ANY ((ARRAY['PAYMENT'::character varying, 'TRANSFER'::character varying, 'EXCHANGE'::character varying])::text[])),
"user_id" uuid,
"service_id" uuid,
"transaction_amount" float8 NOT NULL,
"transaction_currency" varchar NOT NULL,
"status" varchar NOT NULL CHECK ((status)::text = ANY ((ARRAY['NEW'::character varying, 'FINISHED'::character varying, 'PERFORMING'::character varying, 'CANCELLED'::character varying, 'NOT_PERFORMED'::character varying])::text[])),
"performed_at" timestamptz,
"failed_at" timestamptz,
PRIMARY KEY ("id")
);
```

```
-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."users" (
    "id" uuid NOT NULL,
    "first_name" varchar NOT NULL,
    "last_name" varchar NOT NULL,
    "middle_name" varchar,
    "phone_number" varchar,
    "status" varchar NOT NULL CHECK ((status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'INACTIVE'::character varying, 'ARCHIVED'::character varying, 'DISABLED'::character varying])::text[])),
    "balance" float8,
    PRIMARY KEY ("id")
);
```

### **User Table**

### Notes
- Primary keys are configured as `UUID`.
- Indexes can be added for frequently queried fields like `user_id`.

## Troubleshooting

1. **Database Connection Issues**:
    - Ensure your PostgreSQL instance is running and the credentials in your `application.yml` are correct.

2. **Port Conflict (8080)**:
    - To change the port, edit `application.yml` or add the following:
      ```yaml
      server:
        port: 8081
      ```

3. **Gradle Issues**:
    - If Gradle dependencies fail to resolve, retry with:
      ```bash
      ./gradlew --refresh-dependencies
      ```

## License

This project is licensed under the [MIT License](./LICENSE).

## Contact

- **Author**: Nuriddin Khudayberganov
- **Email**: khudayberganovnuriddin@gmail.com
- **GitHub**: https://github.com/Khudayberganovnuriddin/demo_payment

