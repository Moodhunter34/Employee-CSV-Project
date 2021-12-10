package com.sparta.mvc.view;

import com.sparta.mvc.jdbc.ListOfEmployeesToSQL;
import com.sparta.mvc.model.Employee;
import com.sparta.mvc.model.StoreEmployees;

import java.util.Scanner;

public class View {

    public static void displayMenu(){
        System.out.println("Welcome to the program");
        System.out.println();

        boolean exit = false;

        while(!exit) {
            System.out.println("Type 1 to populate database,\n" +
                    "type 2 to select an employee by their id,\n" +
                    "type 3 to select an employee by their lastname,\n" +
                    "type 4 do delete an employee from the database,\n" +
                    "type 5 to Exit.");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if(choice == 1){
//                StoreEmployees.
            }else if(choice == 2){

            }



        }



    }

}
