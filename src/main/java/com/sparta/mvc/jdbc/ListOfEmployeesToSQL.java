package com.sparta.mvc.jdbc;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sparta.mvc.jdbc.StatementFactory;

public class ListOfEmployeesToSQL {
    public static void main(String[] args) throws SQLException, IOException {
        Date dob = null;
        Date doj = null;
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            dob = new java.sql.Date(df.parse("09/12/1989").getTime());
            doj = new java.sql.Date(df.parse("09/12/1989").getTime());
        }catch (ParseException e){
            e.printStackTrace();
        }
        try{
            createNewEmployee(1, "Mr.", "Kabib", 'E', "Nurmagomedov",
                    'M', "kabibnur@gmail.com", dob, doj, 70000);
        } catch (SQLException | IOException e){
            e.printStackTrace();
        } finally {
            StatementFactory.closeStatements();
            ConnectionFactory.closeConnection();
        }

    }

    private static void createNewEmployee(Integer employeeId, String prefix,
                                          String firstName, Character middleInitial,
                                          String lastName, Character gender,
                                          String email, Date dateOfBirth,
                                          Date dateOfJoining, Integer salary)throws SQLException, IOException {
        PreparedStatement statement = StatementFactory.getInsertStatement();
        statement.setInt(1,employeeId);
        statement.setString(2, prefix);
        statement.setString(3, firstName);
        statement.setString(4, middleInitial.toString());
        statement.setString(5, lastName);
        statement.setString(6, gender.toString());
        statement.setString(7, email);
        statement.setDate(8, dateOfBirth);
        statement.setDate(9, dateOfJoining);
        statement.setInt(10, salary);
        System.out.println(statement);
        int rowsAffected = statement.executeUpdate();
    }

    private static void deleteEmployee(int employeeId) throws SQLException, IOException{
        PreparedStatement statement = StatementFactory.getDeleteStatement();
        statement.setInt(1, employeeId);
        int rowsAffected = statement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }

    private static void selectEmployee(String columnName, Integer ID){

    }
    private static void selectEmployeeFirstName(Integer ID){

    }
}


