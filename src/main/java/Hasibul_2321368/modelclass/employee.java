package Hasibul_2321368.modelclass;

public class employee extends user {

    private String employeeId;
    private String department;
    private String position;
    private double salary;

    public employee(String userId, String name, String email, String password, String phoneNumber, String address, String employeeId, String department, String position, double salary) {
        super(userId, name, email, password, phoneNumber, address);
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public employee(String employeeId, String department, String position, double salary) {
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employee{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
