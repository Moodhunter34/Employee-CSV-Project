package com.sparta.mvc.view;

import com.sparta.mvc.controller.Controller;
import com.sparta.mvc.jdbc.DataAccess;
import com.sparta.mvc.model.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class View {

    public static void displayMenu() throws SQLException, IOException, ParseException {
        System.out.println("Welcome to the programme");
        System.out.println();

        boolean exit = false;

        while(!exit){
            System.out.print("Type 1 to populate the database,\n" +
                    "type 2 to select an employee by id,\n" +
                    "type 3 to select an employee by lastname,\n" +
                    "type 4 to delete an employee from the database,\n" +
                    "type 5 to Exit.\n> ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1){
                long timeStart = System.nanoTime();
                DataAccess.populateDatabase();
                long timeEnd = System.nanoTime();
                System.out.println("Database populated successfully.");
                System.out.println("Action took "+(timeEnd-timeStart)+" nanoseconds\n");
            } else if (choice == 2){
                System.out.print("Please input employee id\n> ");
                String id = scanner.next();
                long timeStart = System.nanoTime();
                Employee result = DataAccess.readEmployeeID(id);
                long timeEnd = System.nanoTime();
                if(result == null){
                    System.out.println("Employee " + id + " does not exists.\n");
                    System.out.println("Action took "+(timeEnd-timeStart)+" nanoseconds\n");
                }else {
                    System.out.println(result);
                    System.out.println("Action took "+(timeEnd-timeStart)+" nanoseconds\n");
                }
            } else if (choice == 3) {
                System.out.print("Please input employee's last name.\n> ");
                String lastName = scanner.next();
                long timeStart = System.nanoTime();
                List<Employee> results = DataAccess.readLastName(lastName);
                long timeEnd = System.nanoTime();
                for (int i = 0; i < results.size(); i++) {
                    System.out.println(results.get(i));
                }
                System.out.println("Action took "+(timeEnd-timeStart)+" nanoseconds");
            } else if (choice == 4){
                System.out.print("Please input the id of the employee that you want to delete\n> ");
                int id = scanner.nextInt();
                long timeStart = System.nanoTime();
                if (DataAccess.deleteEmployee(id)) {
                    long timeEnd = System.nanoTime();
                    System.out.println("Employee deleted successfully.");
                    System.out.println("Action took "+(timeEnd-timeStart)+" nanoseconds\n");
                }
                else {
                    long timeEnd = System.nanoTime();
                    System.out.println("The employee with ID: "+ id +" was not found and hence not deleted.");
                    System.out.println("Action took "+(timeEnd-timeStart)+" nanoseconds\n");
                }

            } else if (choice == 5){
                exit = true;
            }


        }


    }
    

}
