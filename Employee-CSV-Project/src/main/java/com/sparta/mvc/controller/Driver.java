package com.sparta.mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sparta.mvc.jdbc.DataAccess;
import com.sparta.mvc.model.*;

import static com.sparta.mvc.jdbc.DataAccess.createNewEmployee;
import static com.sparta.mvc.model.CSVToEmployeeArrayList.readData;

public class Driver {
    public static void populateDatabase(){
        StoreEmployees se = new StoreEmployees();
        try {
            se.csvToListOfEmployees();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < se.validEmployeeEntries.size(); i++) {
            try {
                createNewEmployee(se.validEmployeeEntries.get(i));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        populateDatabase();
    }
    }

