import java.util.Date;

public class Employee {
    private Integer employeeId;
    private String prefix;
    private String firstName;
    private Character middleInitial;
    private String lastName;
    private Character gender;
    private String email;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private Integer salary;
    private String[] rawData;

    public Employee(Integer employeeId,String prefix, String firstName,
                    Character middleInitial, String lastName,
                    Character gender, String email, Date dateOfBirth,
                    Date dateOfJoining, Integer salary, String[] rawData) {
        this.employeeId = employeeId;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.rawData = rawData;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getPrefix(){ return prefix;}

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

    public Date getDateOfBirth() {
        return dateOfBirth;
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
                ", Prefix=" + prefix +
                ", firstName='" + firstName + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dateOfBirt=" + dateOfBirth +
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