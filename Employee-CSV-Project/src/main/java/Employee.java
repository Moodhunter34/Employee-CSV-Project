import java.util.Date;

public class Employee {
    private Integer employeeId;
    private String firstName;
    private Character middleInitial;
    private String lastName;
    private Character gender;
    private String email;
    private Date dateOfBirt;
    private Date dateOfJoining;
    private Integer salary;
    private String[] rawData;
    
    public Employee(String[] rawData){
        this.rawData =rawData;
    }

    public Employee(Integer employeeId, String firstName,
                    Character middleInitial, String lastName,
                    Character gender, String email, Date dateOfBirt,
                    Date dateOfJoining, Integer salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirt = dateOfBirt;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public Character getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public Character getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirt() {
        return dateOfBirt;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public Integer getSalary() {
        return salary;
    }

    public String[] getRawData() {
        return rawData;
    }

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