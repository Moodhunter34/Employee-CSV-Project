
# Project Title

Employee CSV Project

### Table of Contents

[Introduction](#Inroduction)

[Description](#Description)

[How to run the application](How-to-run-the-application)

[Improving Query Runtime](Improving-Query-Runtime)

[Unit Tests](#Unit-Tests)

[Built With](#Built-With)

[Authors](Authors)

## Introduction

This repository contains code for the Employee CSV Project for Sparta Global.

#### Description

This project is designed to read data from a CSV file, parse it, populate objects and add them to a collection. Any corrupt or duplicated data was added to a separate collection for further analysis. This concluded the first phase of the project.

The second phase of the project included writing SQL statements to create tables and persist data to the tables. Data access object (DAO) was created for this purpose. CRUD functionality was also implemented to create, read and delete an employee from the database. Try with resources was used to ensure that the connection with the database is closed as soon as the user finished working on the database.

The third phase of the project involved modifying the existing code into adding multi-threading, hence to increase performance as well as comparing the time taken before adding multi-threading. 

SOLID principles, design patterns and Java conventions was implemented during this project.


## How to run the application

Upon startup of the application you will have to connect to a database.

In the directory there is a file `test-schema.sql` which you can automatically create the database and the employees table with its related fields.

 The code in this project has been tested to run with MySQL. Run your local MySQL server, then connect with your own root user and password and modify the dburl in the properties file.

 The default value of the dburl is:  `jdbc:mysql://localhost:3306/employees?useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true`

You can also modify the directory of the csv file in the properties file.

When setting the properties file with your own details, you can then run the application by running the controller.

When running the controller it will bring you to this screen,

`Type 1 to populate the database` `type 2 to select an employee by id` `type 3 to select an employee by lastname` `type 4 to delete an employee from the database` `type 5 to exit`



Below you can find some screenshots of how the application is running.

Welcome page

![](screenshots/Welcome%20page.png)

Database populated successfully

![](screenshots/populated%20database.png)

Select employee by id

![](screenshots/select%20employee%20by%20id.png)

Select employee by last name

![](screenshots/select%20employee%20by%20lastname.png)

Delete employee by id

![](screenshots/delete%20employee.png)

Successful deletion of employee

![](screenshots/successful%20deletion.png)

#### Improving Query Runtime

Java needs to allocate resources to send our Data Transfer Object (DTO) through SQL queries to our database. This can be time costly when calling repetitive statements. A common example of this is when populating the SQL database. 

Three methods were attempted to reduce the creation and deletion of multiple DTOs.

- Single multi-threading with Java's Executor Service

  The logic behind this method was to assign a single thread for each DTO query and use the executor service to limit the amount of queries running at the same time.

- Multi-threading with subsets

  The DTOs were spilt up into subsets (a list of 100 items becomes 4 lists of 25 items). Each subset of DTOs was put into a thread to handle. 

- Database Connectivity (JDBC) SQL batch queries

  Database Connectivity (JDBC) SQL batch queries Using JDBC's batch queries a single statement could include multi queries to package and send to the Database.



*Due to time constraints, only JDBC SQL batch queries were used to reduce the database population time but a combination of all the methods could be used to achieve maximum runtime performance.*

### Unit Tests

These tests, test the connection to the database, the validity of entities, for example if the email and date of birth is in the correct format, the salary is an integer and how to insert and delete an employee. This happens with dummy values, objects and with assertions.

Before the project started we had to do some basic validation on the data that we will be working on, using TDD. The CSV file had different columns which included different data types and we had to know if we are passing in the right data type into the SQL data file. 

The basic tests are to validate if the email, name, gender, middle initial and salary are in the right format. This was able to be achieved, using Regex to check if String that we are inputting is correct.

Once the basic tests are passed we had to try test the connection to the database. We would need to check if there is a sufficient connection to the SQL so that we can access. This can then allow us to be able to perform INSERT, DELETE and READ functions on the data that is being uploaded to the SQL. There is only a certain way that we are able to read an employee's information and this can be through the ID and name as other information should not be exposed to other users.

There are several types of assertions, but the main ones are assertEquals, assertNull, assertNotNull, assertTrue.


## Built With
- [Maven](https://maven.apache.org/) - Dependency Management

## Authors

- [Jakub Olender](https://github.com/JakubOlender)

- [Tzu-Lun Yeh (Anthony)](https://github.com/MagerXser)

- [Ishmael Shariff](https://github.com/ishariffSG)

- [Nikolaos Papadopoulos](https://github.com/Moodhunter34)

- Hat tip to anyone whose code was used

- Inspiration

=======
# com.sparta.mvc.model.Employee-CSV-Project

