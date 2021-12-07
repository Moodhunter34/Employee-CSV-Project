import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @BeforeEach
    void setup() {
        ArrayList<Employee> employee = new ArrayList<>();
    }

    @Test
    public void testReadFile () {

    }

    @Test
    @DisplayName("Check if the Employee data match")
    public void testEmployeeMatch(){

        ArrayList<Employee> expectedCustomerOutput;
        ArrayList<Employee> actualCustomerOutput;

        assertEquals(expectedCustomerOutput, actualCustomerOutput);
    }

    @Test
    @DisplayName("Test Email Address")
    public void testRegex () {

        String inputEmail = "TYeh@spartaglobal.com";
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        assertTrue(Validation.validateEmail(inputEmail, regexPattern));

    }

    public void id (){

    }

    @Test
    @DisplayName("Valid Name")
    public void isItAValidName () {
        String inputName = "Steven";
        String regexPattern = "/^[a-z ,.'-]+$/i";

        assertTrue(Validation.validateEmail(inputName, regexPattern));
    }

    @Test
    @DisplayName("Salary is an Integer")
    public void salaryIsAnInteger () {

    }
    @Test
    @DisplayName("Valid Gender or Initial")
    public void genderAndInitialFormat () {

    }

    @Test
    @DisplayName("Date format is correct")
    public void isDateCorrectlyFormated() {
        String inputDate = "05/08/1967";
        String regexPattern = "/^[a-z ,.'-]+$/i";

        assertTrue(Validation.validateEmail(inputName, regexPattern));
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