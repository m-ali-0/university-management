package model.person;

import java.time.LocalDate;
 
class Employee extends Person {
    private String employeeId;
    private String department;
    private String position;
    private int salary;


    public Employee(String fullName, int age, String employeeId, String department, String position, int salary) {
        super(fullName, age);
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }
    public String getDetails() {
        return "Employee ID: " + employeeId +
               "\nDepartment: " + department +
               "\nPosition: " + position +
               "\nName: " + getFullName() + ", Age: " + getAge();
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId + ", Position: " + position;
    }
}