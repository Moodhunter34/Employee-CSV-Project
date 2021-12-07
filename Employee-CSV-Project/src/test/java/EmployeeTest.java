import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    @BeforeEach
    void setup() {
        ArrayList<Employee> employee = new ArrayList<>();

    }

    @Test
    public void testReadFile() {

    }

//    @Test
//    @DisplayName("Check if the Employee data match")
//    public void testEmployeeMatch(){
//
//        ArrayList<Employee> expectedCustomerOutput;
//        ArrayList<Employee> actualCustomerOutput;
//
//        assertEquals(expectedCustomerOutput, actualCustomerOutput);
//    }

    @Test
    @DisplayName("Test Email Address")
    public void testRegex() {
        String inputEmail = "TYeh@spartaglobal.com";
        assertTrue(Validation.validateEmail(inputEmail));
    }

//    @Test
//    @DisplayName("Valida employee to not be null")
//    public void validateEmloyeeTest() {
//        Employee employee = new Employee(231, "Kevin",
//                'M', "Durant", 'M', "kevdurant@gmail.com",
//                "10/12/10", "11/10/2013",
//                750000, null);
//    }

    public void id() {

    }

    @Test
    @DisplayName("Valid Name")
<<<<<<< HEAD
    public void isItAValidName () {

        String inputName = "Steven";
=======
    public void isItAValidName() {
        String inputName = "steven";
>>>>>>> dev
        assertTrue(Validation.validateName(inputName));
    }

    @Test
    @DisplayName("Salary is an Integer")
    public void salaryIsAnInteger() {
        String salary = "30000";
        assertTrue(Validation.validateInteger(salary));
    }


    @Test
    @DisplayName("Valid Gender or Initial")
    public void genderAndInitialFormat() {
        String validChar = "G";
        assertTrue(Validation.validateChar(validChar));

    }


    @Test
    @DisplayName("Date format is correct")
    public void isDateCorrectlyFormated() {
        String inputDate = "05/08/1967";
        String regexPattern = "/^[a-z ,.'-]+$/i";
        assertTrue(Validation.validateDate(inputDate), regexPattern);
    }

    @AfterEach
    public void teardown() {
        System.out.println("After class");
    }


    /*
    Test for any corrupted data
    Checking regular expression (e.g email)
    Interface to specify a file they would like to look at
    Feedback to check if the file we wrote is correct format
    Report on how many data are in each of the categories

    Does the file that I am reading exits?




     */


}