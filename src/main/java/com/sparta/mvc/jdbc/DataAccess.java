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

public class DataAccess {
    private static int limit = 6;

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

    public static void clearTable() throws SQLException, IOException {
        PreparedStatement statement = StatementFactory.dropTable();
        statement.executeUpdate();
    }

    //Edit table
    private static List<List<Employee>> employeesDivider(List<Employee> employees) throws SQLException, IOException {
        List<List<Employee>> subSets = new ArrayList<>();
        int range = employees.size() / limit;
        for (int i = 0; i < limit; i++) {
            List<Employee> set = employees.subList(i * range, (i + 1) * range);
            subSets.add(set);
        }
        if (employees.size() % limit != 0) {
            int leftOver = employees.size() % limit;
            List<Employee> set = employees.subList(employees.size() - leftOver, employees.size());
            subSets.add(set);
        }
        return subSets;
    }

    private static void createNewEmployeesHelper(List<Employee> employees) throws SQLException, IOException {
        for (Employee employee : employees) {
            createNewEmployee(employee);
        }
    }
    //Multithreading add employees
    public static void createNewEmployees(List<Employee> employees) throws SQLException, IOException {
        List<List<Employee>> subSets = employeesDivider(employees);
        for (List<Employee> subSet : subSets) {
            Runnable runnable = () -> {
                try {
                    createNewEmployeesHelper(subSet);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(runnable);
            thread.run();
        }
    }

    //Single thread add employee
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
        statement.execute();
        statement.close();
    }

    public static void deleteEmployee(Integer employeeID) throws SQLException, IOException {
        PreparedStatement statement = StatementFactory.getDeleteStatement();
        statement.setInt(1, employeeID);
        int rowsAffected = statement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }

    //Read table
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


