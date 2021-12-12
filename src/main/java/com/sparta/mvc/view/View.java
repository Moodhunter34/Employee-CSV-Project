package com.sparta.mvc.view;

import com.sparta.mvc.controller.Controller;
import com.sparta.mvc.jdbc.DataAccess;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class View {

    public static void displayMenu() throws SQLException, IOException, ParseException {
        System.out.println("Welcome to the programme");
        System.out.println();

        boolean exit = false;

        while(!exit){
            System.out.println("Type 1 to populate the database,\n" +
                    "type 2 to select an employee by id,\n" +
                    "type 3 to select an employee by lastname,\n" +
                    "type 4 to delete an employee from the database,\n" +
                    "type 5 to Exit.");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1){
                Controller.populateDatabase();
            } else if (choice == 2){
                System.out.println("Please input employee id");
                String id = scanner.next();
                DataAccess.readEmployeeID(id);
            } else if (choice == 3) {
                System.out.println("Please input employee lastname");
                String lastName = scanner.next();
                DataAccess.readLastName(lastName);
            } else if (choice == 4){
                System.out.println("Please input the id of the employee that you want to delete");
                int id = scanner.nextInt();
                DataAccess.deleteEmployee(id);
            } else if (choice == 5){
                exit = true;
            }


        }


    }
    

}
