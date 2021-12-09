import com.sparta.mvc.model.Employee;
import com.sparta.mvc.model.Validation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertTrue;
import java.util.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    @BeforeEach
    void setup() {
        ArrayList<Employee> employee = new ArrayList<>();

    }


    @Test
    @DisplayName("Test Email Address")
    public void testRegex() {
        String inputEmail = "TYeh@spartaglobal.com";
        assertTrue(Validation.validateEmail(inputEmail));
    }

    @Test
    @DisplayName("Valid Name")
    public void isItAValidName() {
        String inputName = "steven";
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