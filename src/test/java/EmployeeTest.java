import com.sparta.mvc.jdbc.ConnectionFactory;
import com.sparta.mvc.jdbc.DataAccess;
import com.sparta.mvc.jdbc.Request;
import com.sparta.mvc.model.Employee;
import com.sparta.mvc.model.Validation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.sparta.mvc.jdbc.ConnectionFactory.getConnection;
import static com.sparta.mvc.jdbc.ConnectionFactory.closeConnection;

class EmployeeTest {

    @BeforeEach
    void setup() throws SQLException, IOException {
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
    @DisplayName("Valid Character in Gender and Initial")
    public void genderAndInitialFormat() {
        String validChar = "G";
        assertTrue(Validation.validateChar(validChar));
    }

    @Test
    @DisplayName("Validate salary to be an Integer")
    public void salaryIsAnInteger() {
        String salary = "30000";
        assertTrue(Validation.validateInteger(salary));
    }

    @Test
    @DisplayName("Validate date in the correct format")
    public void dateFormat () {
        String date = "06/09/1998";
        assertTrue(Validation.validateDate(date));
    }

    @Test
    @DisplayName("Have we been connected to the database")
    public void testOpenConnection() throws Exception {
        System.out.println("openConnection");
        Connection result = ConnectionFactory.getConnection();
        assertEquals(result != null, true);
    }

    @Test
    @DisplayName("Insert an employee")
    public void insertEmployee () {
        System.out.println("Insert Employee");
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
    @DisplayName("Delete an Employee")
    public void deleteEmployee () {
        boolean thrown = false;
        try {
            getConnection();
            DataAccess.deleteEmployee(26);
            List<Employee> person = Request.readEmployeeID("26");
            assertNull(person.get(0));
        }catch (IndexOutOfBoundsException | IOException | SQLException | ParseException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    @DisplayName("Read employee by ID")
    public void displayEmployee () {
        try {
            getConnection();
            DataAccess.readEmployeeID("26");
            List<Employee> person = Request.readEmployeeID("26");
            assertEquals(person.get(0), DataAccess.readEmployeeID("26"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void teardown() {
        System.out.println("After class");
    }

}