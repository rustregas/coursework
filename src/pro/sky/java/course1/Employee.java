package pro.sky.java.course1;

import java.util.Objects;

public class Employee {

    private String fullName;
    private int salary;
    private int departmentId;
    private static int id;
    private int idEmployee;

    public Employee(String fullName, int salary, int departmentId) {
        this.fullName = fullName;
        this.salary = salary;
        this.departmentId = departmentId;
        this.idEmployee = ++id;
    }



    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getId() {
        return idEmployee;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", id=" + idEmployee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                departmentId == employee.departmentId &&
                idEmployee == employee.idEmployee &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, departmentId, idEmployee);
    }
}