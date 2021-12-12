# Project Title

Employee CSV Project

## Introduction

This repository contains code for the Employee CSV Project for Sparta Global.

**Description**

This project is designed to read data from a CSV file, parse it, populate objects and add them to a collection. Any corrupt or duplicated data was added to a separate collection for further analysis. This concluded the first phase of the project.

The second phase of the project included writing SQL statements to create tables and persist data to the tables. Data access object (DAO) was created for this purpose. CRUD functionality was also implemented to create, read and delete an employee from the database. (Try with resources) was used to ensure that the connection with the database is closed as soon as the user finished working on the database.

The third phase of the project involved modifying the existing code to adding multi-threading, to increase performance as well as comparing the time taken before adding multi-threading. (streams and lambdas)??

SOLID principles, design patterns and Java conventions was implemented during this project.


## How to run the application









**Unit Tests**

These tests, test the connection to the database, the validity of entities, for example if the email and date of birth is in the correct format, the salary is an integer and how to insert and delete an employee. This happens with dummy values, objects and with assertions.
There are several types of assertions, but the main ones are assertEquals, assertNull, assertNotNull, assertTrue.


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

- Jakub Olender - https://github.com/JakubOlender

- Tzu-Lun Yeh (Anthony) - https://github.com/MagerXser

- Ishmael Shariff - https://github.com/ishariffSG

- Nikolaos Papadopoulos - https://github.com/Moodhunter34

- Hat tip to anyone whose code was used
- Inspiration

