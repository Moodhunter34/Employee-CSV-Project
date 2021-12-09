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
    public static PreparedStatement getSelectStatement() throws SQLException, IOException {
        if(insertStatement == null){
            insertStatement = ConnectionFactory.getConnection()
                    .prepareStatement(
                            "SELECT * FROM employees WHERE ? = ?");
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



}
