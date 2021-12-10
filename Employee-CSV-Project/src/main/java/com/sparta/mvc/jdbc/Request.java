package com.sparta.mvc.jdbc;

import com.sparta.mvc.model.Employee;
import com.sparta.mvc.model.StoreEmployees;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Request {
    private static List<Employee> format(ResultSet resultSet) throws SQLException, ParseException {
        List<Employee> results = new ArrayList<>();
        while (resultSet.next()) {
            String[] result = {
                    resultSet.getString(("employeeID")),
                    resultSet.getString(("prefix")),
                    resultSet.getString(("firstName")),
                    resultSet.getString(("middleInitial")),
                    resultSet.getString(("lastName")),
                    resultSet.getString(("gender")),
                    resultSet.getString(("email")),
                    resultSet.getString(("dateOfBirth")),
                    resultSet.getString(("dateOfJoining")),
                    resultSet.getString(("salary"))
            };
            results.add(StoreEmployees.createEmployee(result));
        }
        return results;
    }
    public static List<Employee> readTable(String value) throws SQLException, IOException, ParseException {
        PreparedStatement statement = StatementFactory.getSelectStatement("firstName");
        statement.setString(1, value);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> results = format(resultSet);
        return results;
    }
    public static List<Employee> readEmployeeID(String value) throws SQLException, IOException, ParseException {
        PreparedStatement statement = StatementFactory.getSelectStatement("employeeID");
        statement.setString(1, value);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> results = format(resultSet);
        return results;
    }

    public static List<Employee> readFirstName(String value) throws SQLException, IOException, ParseException {
        PreparedStatement statement = StatementFactory.getSelectStatement("firstName");
        statement.setString(1, value);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> results = format(resultSet);
        return results;
    }
    public static List<Employee> readLastName(String value) throws SQLException, IOException, ParseException {
        PreparedStatement statement = StatementFactory.getSelectStatement("lastName");
        statement.setString(1, value);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> results = format(resultSet);
        return results;
    }
}
