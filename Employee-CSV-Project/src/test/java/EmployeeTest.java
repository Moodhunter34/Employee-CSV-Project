import com.sparta.mvc.jdbc.ConnectionFactory;
import com.sparta.mvc.jdbc.StatementFactory;
import com.sparta.mvc.model.Employee;
import com.sparta.mvc.model.Validation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import static com.sparta.mvc.jdbc.StatementFactory.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.sparta.mvc.jdbc.ConnectionFactory.getConnection;
import static com.sparta.mvc.jdbc.ConnectionFactory.closeConnection;

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

    @Test
    public void testOpenConnection() throws Exception {
        System.out.println("openConnection");
        Connection result = ConnectionFactory.getConnection();
        assertEquals(result != null, true);
    }

    @ParameterizedTest
    @CsvSource({"Justin, Man, Justin Man"})
    public void testInsertData (String firstName, String lastName, String execpted) throws Exception {

        System.out.println("insertActor");
        String insertActor ="INSERT INTO employees (ID, prefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, Salary)" +
                " VALUES (3, Mr, Anthony, T, Yeh, M, antony.yeh@hotmail.com , 06/09/2000, 08/11/21, 23000)";
        try {
            getConnection();
            ResultSet rs = getInsertStatement().executeQuery(insertActor);
            firstName = rs.getString("First Name");
            lastName = rs.getString("Last Name");
            assertEquals(execpted, firstName + lastName);
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void insertData () {

        System.out.println("insertActor");
//        String insertActor = "INSERT INTO employees (ID, prefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, Salary)" +
//                " VALUES (3, Mr, Anthony, T, Yeh, M, antony.yeh@hotmail.com , 06/09/2000, 08/11/21, 23000)";
        try {
            getConnection();
            PreparedStatement ps = getInsertStatement();
            ps.setInt(1,3);
            ps.setString(2,"Mr");
            ps.setString(3,"Anthony");
            ps.setString(4,"T");
            ps.setString(5,"Yeh");
            ps.setString(6,"M");
            ps.setString(7,"antony.yeh@hotmail.com");
            ps.setString(8,"06/09/2000");
            ps.setString(9,"08/11/21");
            ps.setInt(10,23000);
            ps.executeUpdate();
            getSelectStatement().setInt(1,3);
            getSelectStatement().setString(2,"Mr");
            getSelectStatement().setString(3,"Anthony");
            getSelectStatement().setString(4,"T");
            getSelectStatement().setString(5,"Yeh");
            getSelectStatement().setString(7,"M");
            getSelectStatement().setString(8,"antony.yeh@hotmail.com");
            getSelectStatement().setString(9,"06/09/2000");
            getSelectStatement().setString(0,"08/11/2021");
            getSelectStatement().setInt(10,23000);
            ResultSet rs = getSelectStatement().executeQuery();
            rs.next();
            int ID = rs.getInt("employeeID");
            String prefix = rs.getString("Mr");
            String firstName = rs.getString("firstName");
            String middleInitial = rs.getString("middleInitial");
            String lastName = rs.getString("lastName");
            String gender = rs.getString("geneder");
            String email = rs.getString("email");
            Date dateOfBirth = rs.getDate("06/09/2000");
            Date dateOfJoining = rs.getDate("08/11/2021");
            int salary = rs.getInt("salary");
            assertEquals(3,ID);
            assertEquals("Mr", prefix);
            assertEquals("Anthony", firstName);
            assertEquals("T", middleInitial);
            assertEquals("Yeh", lastName);
            assertEquals("M", gender);
            assertEquals("antony.yeh@hotmail.com", email);
            assertEquals("06/09/2000", dateOfBirth);
            assertEquals("08/11/2021", dateOfJoining);
            assertEquals("23000", salary);
            closeConnection();
        } catch (Exception e) {
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