DROP TABLE IF EXISTS employees CASCADE;

CREATE TABLE employees(
                          employeeID INT PRIMARY KEY ,
                          prefix VARCHAR(4),
                          firstName VARCHAR(30),
                          middleInitial CHAR(1),
                          lastName VARCHAR(30),
                          gender CHAR(1),
                          email VARCHAR(50),
                          dateOfBirth DATE,
                          dateOfJoining DATE,
                          salary INT
);