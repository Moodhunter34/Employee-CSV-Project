import java.util.Date;

public class Employee {
    public Integer employeeId;
    public String firstName;
    public Character middleInitial;
    public String lastName;
    public Character gender;
    public String email;
    public Date dateOfBirt;
    public Date dateOfJoining;
    public String salary;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dateOfBirt=" + dateOfBirt +
                ", dateOfJoining=" + dateOfJoining +
                ", salary='" + salary + '\'' +
                '}';
    }

    public int compareTo(Employee e) {
        if (this.employeeId == e.employeeId) return 0;
        else if (this.employeeId > e.employeeId) return 1;
        else return -1;
    }
}