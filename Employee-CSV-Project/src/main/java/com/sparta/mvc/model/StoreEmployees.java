package com.sparta.mvc.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StoreEmployees {
    public List<Employee> validEmployeeEntries = new ArrayList<>();
    public List<Employee> invalidEmployeeEntries = new ArrayList<>();
    private final String FILE_NAME = "C:\\Users\\ariso\\Documents\\GitHub\\Employee-CSV-Project\\Employee-CSV-Project\\EmployeeRecords.csv";


    public static Employee createEmployee(String[] employeeRow) throws ParseException {
        boolean invalidEmployee = false;
        Integer currentEmployeeId;
        String currentPrefix;
        String currentFirstName;
        Character currentMiddleInitial;
        String currentLastName;
        Character currentGender;
        String currentEmail;
        Date currentDateOfBirth;
        Date currentDateOfJoining;
        Integer currentSalary;
        String[] currentRawData;

        if (Validation.validateInteger(employeeRow[0])) {
            currentEmployeeId = Integer.parseInt(employeeRow[0]);
        } else {
            currentEmployeeId = null;
            invalidEmployee = true;
        }
        if (Validation.validateName(employeeRow[1])) {
            currentPrefix = employeeRow[1];
        } else {
            currentPrefix = null;
            invalidEmployee = true;
        }
        if (Validation.validateName(employeeRow[2])) {
            currentFirstName = employeeRow[2];
        } else {
            currentFirstName = null;
            invalidEmployee = true;
        }
        if (Validation.validateChar(employeeRow[3])) {
            currentMiddleInitial = employeeRow[3].charAt(0);
        } else {
            currentMiddleInitial = null;
            invalidEmployee = true;
        }
        if (Validation.validateName(employeeRow[4])) {
            currentLastName = employeeRow[4];
        } else {
            currentLastName = null;
            invalidEmployee = true;
        }
        if (Validation.validateChar(employeeRow[5])) {
            currentGender = employeeRow[5].charAt(0);
        } else {
            currentGender = null;
            invalidEmployee = true;
        }
        if (Validation.validateEmail(employeeRow[6])) {
            currentEmail = employeeRow[6];
        } else {
            currentEmail = null;
            invalidEmployee = true;
        }
        if (employeeRow[7] != null && Validation.validateDate(employeeRow[7])) {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            currentDateOfBirth = df.parse(employeeRow[7]);
        } else {
            currentDateOfBirth = null;
            invalidEmployee = true;
        }
        if (employeeRow[7] != null && Validation.validateDate(employeeRow[8])) {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            currentDateOfJoining = df.parse(employeeRow[8]);
        } else {
            currentDateOfJoining = null;
            invalidEmployee = true;

        }
        if (Validation.validateInteger(employeeRow[9])) {
            currentSalary = Integer.parseInt(employeeRow[9]);
        } else {
            currentSalary = null;
            invalidEmployee = true;

        }
        if (invalidEmployee) {
            currentRawData = employeeRow;
        } else {
            currentRawData = null;
        }
        return new Employee(currentEmployeeId, currentPrefix,currentFirstName, currentMiddleInitial,
                currentLastName, currentGender, currentEmail, currentDateOfBirth,
                currentDateOfJoining, currentSalary, currentRawData);
    }

    public void csvToListOfEmployees() throws IOException, ParseException {
        List<String[]> csvContent = CSVToEmployeeArrayList.readData(FILE_NAME);
        Set<Integer> lump = new HashSet<Integer>();
        for (int i = 0; i < csvContent.size(); i++) {
            String[] currentRow = csvContent.get(i);
            Employee currentEmployee = createEmployee(currentRow);
            if ( currentEmployee.getRawData() == null) {
                this.validEmployeeEntries.add(currentEmployee);
                lump.add(currentEmployee.getEmployeeId());
            } else {
                this.invalidEmployeeEntries.add(currentEmployee);
            }
        }
    }
}

