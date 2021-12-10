package com.sparta.mvc.controller;

import com.sparta.mvc.jdbc.ConnectionFactory;
import com.sparta.mvc.jdbc.Request;
import com.sparta.mvc.model.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        try {
            List<Employee> employees = Request.readEmployeeID("198429");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (SQLException|IOException|ParseException e) {
            e.printStackTrace();
        }
    }
}
