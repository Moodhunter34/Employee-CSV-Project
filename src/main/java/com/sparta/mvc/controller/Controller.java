package com.sparta.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.sparta.mvc.model.*;
import com.sparta.mvc.view.View;

import static com.sparta.mvc.jdbc.DataAccess.createNewEmployee;

public class Controller {
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

    public static void main(String[] args) throws SQLException, IOException, ParseException {
        View.displayMenu();
        populateDatabase();
    }
}

