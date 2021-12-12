package com.sparta.mvc.jdbc;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.sparta.mvc.jdbc.StatementFactory;
import com.sparta.mvc.model.Employee;
import com.sparta.mvc.model.StoreEmployees;
import org.w3c.dom.ls.LSOutput;

public class DataAccess {

    private static int limit = 6;

    public static void populateDatabase() {
        StoreEmployees se = new StoreEmployees();
        try {
            se.csvToListOfEmployees();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            DataAccess.createNewEmployees(se.validEmployeeEntries);
        } catch (SQLException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static List<Employee> format(ResultSet resultSet) throws SQLException, ParseException {
        List<Employee> results = new ArrayList<>();
        while (resultSet.next()) {
            java.util.Date dob = resultSet.getTimestamp("dateOfBirth");
            java.util.Date doj = resultSet.getTimestamp("dateOfJoining");
            Employee newEmployee = new Employee(resultSet.getInt(("employeeID")), resultSet.getString(("prefix")),
                    resultSet.getString(("firstName")), resultSet.getString(("middleInitial")).charAt(0), resultSet.getString(("lastName")),
                    resultSet.getString(("gender")).charAt(0), resultSet.getString(("email")), dob, doj, resultSet.getInt(("salary")), null);
            results.add(newEmployee);
        }
        return results;
    }

    public static void clearTable() throws SQLException, IOException {
        PreparedStatement statement = StatementFactory.dropTable();
        statement.executeUpdate();
    }

    public static PreparedStatement createHelper(Employee employee, PreparedStatement statement) throws SQLException {
        Date dob = new java.sql.Date(employee.getDateOfBirth().getTime());
        Date doj = new java.sql.Date(employee.getDateOfJoining().getTime());

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
        return statement;
    }

    public static void createNewEmployees(List<Employee> employees) throws SQLException, IOException {
        long startTime = System.currentTimeMillis();
        PreparedStatement statement = StatementFactory.getInsertStatement();
        for (Employee employee : employees) {
            createHelper(employee, statement);
            statement.addBatch();
        }
        statement.executeBatch();
        long stopTime = System.currentTimeMillis();

    }

    public static void createNewEmployee(Employee employee) throws SQLException, IOException {
        PreparedStatement statement = StatementFactory.getInsertStatement();
        createHelper(employee, statement).execute();
    }

    private static PreparedStatement deleteHelper(Integer employeeID, PreparedStatement statement) throws SQLException, IOException {
        statement.setInt(1, employeeID);
        return statement;
    }

    public static void deleteEmployees(Integer[] employeeIDs) throws SQLException, IOException {
        PreparedStatement statement = StatementFactory.getDeleteStatement();
        for (Integer employeeID : employeeIDs) {
            deleteHelper(employeeID, statement);
            statement.addBatch();
        }
        statement.executeBatch();

    }


    public static boolean deleteEmployee(Integer employeeID) throws SQLException, IOException {
        PreparedStatement statement = StatementFactory.getDeleteStatement();
        statement.setInt(1, employeeID);
        int rowsaffected = statement.executeUpdate();
        if (rowsaffected > 0) return true;
        return false;
    }

    //Read table
    public static List<Employee> readTable(String value) throws SQLException, IOException, ParseException {
        PreparedStatement statement = StatementFactory.getSelectStatement("firstName");
        statement.setString(1, value);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> results = format(resultSet);
        return results;
    }

    public static Employee readEmployeeID(String value) throws SQLException, IOException, ParseException {
        PreparedStatement statement = StatementFactory.getSelectStatement("employeeID");
        statement.setString(1, value);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> resultList = format(resultSet);
        if (resultList.isEmpty()) {
            return null;
        }
        Employee results = resultList.get(0);
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




