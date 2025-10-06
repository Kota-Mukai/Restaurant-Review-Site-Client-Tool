# Restaurant review site admin tool
"Restaurant review site admin tool" is an administrative system that allows administrators to register, edit, and delete restaurants on the restaurant review site, as well as search for restaurants within the site.  
You can find the client-side application in my repository under Restaurant-Review-Site-Client-Tool.

# Purpose of creating this tool
To produce an output as part of learning web application development using Spring Boot.

# Setup
Maven 4.0.0  
Java 24  
Spring boot 3.5.6  
  (dependencies)  
    ・Spring JDBC  
    ・Thymeleaf  
    ・Validation  
    ・Spring Web  
    ・Spring devtools  
    ・Lombok  
DBeaver 25.2.1  
MySQL Server 8.0  
    
When running this tool in your local enviroment, please use the following SQL statements to create database.
```SQL:SQL
CREATE DATABASE restaurant_db CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER IF NOT EXISTS your_name IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON restaurant_db.* TO your_name;

CREATE TABLE restaurants (
  restaurant_id   INT         NOT NULL AUTO_INCREMENT,
  restaurant_name VARCHAR(32) NOT NULL,
  tagline         VARCHAR(64) NOT NULL,
  PRIMARY KEY(restaurant_id)
);

CREATE TABLE reviews (
  review_id      INT          NOT NULL AUTO_INCREMENT,
  restaurant_id  INT          NOT NULL,
  user_id        VARCHAR(16)  NOT NULL,
  visit_date     DATE         NOT NULL.
  rating         INT          NOT NULL,
  comment        VARCHAR(50)  NOT NULL,
  PRIMARY KEY(review_id),
  FOREIGN KEY(restaurant_id) REFERENCES restaurants (restaurant_id)
):
```

And then create an "application.properties" file directly under src/main/resources and write the following content in it.
```
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
spring.datasource.username=your_name
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
