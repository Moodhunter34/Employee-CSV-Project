package com.sparta.mvc.jdbc;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementFactory {

    private static PreparedStatement insertStatement = null;
    private static PreparedStatement deleteStatement = null;

    public static PreparedStatement getInsertStatement() throws SQLException, IOException {
        if(insertStatement == null){
            insertStatement = ConnectionFactory.getConnection()
                    .prepareStatement(
                            "INSERT INTO employees (employeeID, prefix, firstName, middleInitial, lastName, Gender, email, dateOfBirth, dateOfJoining, Salary)" +
                                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        }
        return insertStatement;
    }
    public static PreparedStatement getDeleteStatement() throws SQLException, IOException {
        if(deleteStatement == null){
            deleteStatement = ConnectionFactory.getConnection()
                    .prepareStatement("DELETE FROM employees WHERE ? = ?");
        }
        return deleteStatement;
    }
    public static void closeStatements() throws SQLException {
        if(insertStatement != null) insertStatement.close();
        if(deleteStatement != null) deleteStatement.close();
    }

    public static PreparedStatement dropTable() throws SQLException, IOException {
        return ConnectionFactory.getConnection()
                .prepareStatement(
                        "TRUNCATE TABLE employees");
    }

    //Select
    public static PreparedStatement getSelectStatement(String columnName) throws SQLException, IOException {
        switch (columnName){
            case "employeeID":
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE employeeID = ?");
            case "prefix" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE prefix = ?");
            case "firstName":
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE firstName = ?");
            case "middleInitial" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE middleInitial = ?");
            case "lastName" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE lastName = ?");
            case "gender" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE gender = ?");
            case "email" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE email = ?");
            case "dateOfBirth" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE dateOfBirth = ?");
            case "dateOfJoining" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE dateOfJoining = ?");
            case "salary" :
                return ConnectionFactory.getConnection()
                        .prepareStatement(
                                "SELECT * FROM employees WHERE salary = ?");

        }
        return null;
    }
}
