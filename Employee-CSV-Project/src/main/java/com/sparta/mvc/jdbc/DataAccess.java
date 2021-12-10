package com.sparta.mvc.jdbc;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sparta.mvc.jdbc.StatementFactory;
import com.sparta.mvc.model.Employee;

public class DataAccess {


    public static void createNewEmployee(Employee employee) throws SQLException, IOException {
        Date dob = new java.sql.Date(employee.getDateOfBirth().getTime());
        Date doj = new java.sql.Date(employee.getDateOfJoining().getTime());

        PreparedStatement statement = StatementFactory.getInsertStatement();

        statement.setInt(1, employee.getEmployeeId());
        statement.setString(2, employee.getPrefix());
        statement.setString(3, employee.getFirstName());
        statement.setString(4, employee.getMiddleInitial().toString());
        statement.setString(5, employee.getLastName());
        statement.setString(6, employee.getGender().toString());
        statement.setString(7, employee.getEmail());
        statement.setDate(8, dob);
        statement.setDate(9, doj);
        statement.setInt(10, employee.getSalary());
        System.out.println(statement);
        statement.execute();
    }


    private static void deleteEmployee(Integer employeeID) throws SQLException, IOException{
        PreparedStatement statement = StatementFactory.getDeleteStatement();
        statement.setInt(1, employeeID);
        int rowsAffected = statement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }

    private static void selectEmployee(String columnName, Integer ID){

    }
    private static void selectEmployeeFirstName(Integer ID){

    }
}


