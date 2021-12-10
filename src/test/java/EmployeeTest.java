import com.sparta.mvc.jdbc.ConnectionFactory;
import com.sparta.mvc.jdbc.DataAccess;
import com.sparta.mvc.jdbc.Request;
import com.sparta.mvc.jdbc.StatementFactory;
import com.sparta.mvc.model.Employee;
import com.sparta.mvc.model.Validation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static com.sparta.mvc.jdbc.StatementFactory.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.sparta.mvc.jdbc.ConnectionFactory.getConnection;
import static com.sparta.mvc.jdbc.ConnectionFactory.closeConnection;

class EmployeeTest {

    @BeforeEach
    void setup() throws SQLException, IOException {
//        ArrayList<Employee> employee = new ArrayList<>();
//        DataAccess.clearTable();
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

    @Test
    public void testOpenConnection() throws Exception {
        System.out.println("openConnection");
        Connection result = ConnectionFactory.getConnection();
        assertEquals(result != null, true);
    }

    @Test
    public void insertEmployee () {
        System.out.println("Insert Employee");
//        String insertActor = "INSERT INTO employees (ID, prefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, Salary)" +
//                " VALUES (3, Mr, Anthony, T, Yeh, M, antony.yeh@hotmail.com , 06/09/2000, 08/11/21, 23000)";
        try {
            getConnection();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date dob = df.parse("09/06/2000");
            Date doj = df.parse("11/08/2021");
            String [] rawData = new String[]{};
            Employee employee = new Employee(26,"Mr","Anthony",'T',"Yeh",
                    'M',"antony.yeh@hotmail.com",dob, doj, 23000, rawData);
            DataAccess.createNewEmployee(employee);
            List<Employee> person = Request.readEmployeeID("26");
            assertEquals(person.get(0),employee);
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteEmployee () {
        try {
            getConnection();
            List<Employee> person = Request.readEmployeeID("26");
            DataAccess.deleteEmployee(26);
            assertNull(person.get(0));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert(){
        System.out.println("First insert");
    }

    @Test
    public void update () {
        System.out.println("update");
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