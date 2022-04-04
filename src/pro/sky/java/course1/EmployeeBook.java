package pro.sky.java.course1;

import java.util.Arrays;

public class EmployeeBook {

    private static Employee[] employeeBook;

    public EmployeeBook(int size){
        employeeBook = new Employee[size];
    }


    //get Arrays
    private static int[] getSalaryArray() {
        int[] salaryArray = new int[employeeBook.length];
        for (int i = 0; i < salaryArray.length; i++) {
            if (employeeBook[i] != null) {
                salaryArray[i] = employeeBook[i].getSalary();
            }
        }
        return Arrays.stream(salaryArray).filter(num -> num > 0).toArray();
    }

    private static int[] getSalaryArray(int departmentId) {
        int[] salaryArray = new int[employeeBook.length];
        for (int i = 0; i < salaryArray.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getDepartmentId() == departmentId) {
                salaryArray[i] = employeeBook[i].getSalary();
            }
        }
        return Arrays.stream(salaryArray).filter(num -> num > 0).toArray();
    }

    //get Group Values
    public int countSumMonthSalary() {
        return Arrays.stream(getSalaryArray()).sum();
    }

    public int countSumMonthSalary(int departmentId) {
        return Arrays.stream(getSalaryArray(departmentId)).sum();
    }

    public int getMaxSalary() {
        return Arrays.stream(getSalaryArray()).max().getAsInt();
    }

    public int getMaxSalary(int departmentId) {
        return Arrays.stream(getSalaryArray(departmentId)).max().getAsInt();
    }

    public int getMinSalary() {
        return Arrays.stream(getSalaryArray()).min().getAsInt();
    }

    public int getMinSalary(int departmentId) {
        return Arrays.stream(getSalaryArray(departmentId)).min().getAsInt();
    }

    public double getAverageSalary() {
        return Arrays.stream(getSalaryArray()).average().getAsDouble();
    }   

    public double getAverageSalary(int departmentId) {
        return Arrays.stream(getSalaryArray(departmentId)).average().getAsDouble();
    }

    
    //Changing Salary
    public void indexingSalary(int percent) {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                int delta = (employee.getSalary() * percent / 100);
                employee.setSalary(employee.getSalary() + delta);
            }
        }
    }

    public void indexingSalary(int percent, int departmentId) {
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartmentId() == departmentId) {
                int delta = (employee.getSalary() * percent / 100);
                employee.setSalary(employee.getSalary() + delta);
            }
        }
    }


    //print employeeBookinfo
    public void printEmployees() {
        String[] name = new String[employeeBook.length];
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                name[i] = "fullName: '" + employeeBook[i].getFullName()+ "'" + " departmentId: " + employeeBook[i].getDepartmentId();
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(name).filter(num -> num != null).toArray()));
    }

    public void printEmployees(int departmentId){
        String[] name = new String[employeeBook.length];
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getDepartmentId() == departmentId ) {
                name[i] = "fullName: '" + employeeBook[i].getFullName()+ "'";
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(name).filter(num -> num != null).toArray()));
    }

    public void printEmployeesLowerSalary(int salary){
        StringBuilder str = new StringBuilder("Список сотрудников с зарплатой меньше " + salary + " :\n");
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getSalary() < salary) {
                str.append(employee.toString()).append("\n");
            }
        }
        System.out.println(str.toString());
    }

    public void printEmployeesHigherSalary(int salary){
        StringBuilder str = new StringBuilder("Список сотрудников с зарплатой больше " + salary + " :\n");
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getSalary() > salary) {
                str.append(employee.toString()).append("\n");
            }
        }
        System.out.println(str.toString());
    }


    //Changing book
    public void addEmployee (Employee emp) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = emp;
                return;
            }
        }
    }

    public void dropEmployee (String fullName) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getFullName().equals(fullName)) {
                employeeBook[i] = null;
                break;
            }
        }
    }

    public void dropEmployee (int Id) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getId() == Id) {
                employeeBook[i] = null;
                break;
            }
        }
    }


    //Changing employees
    public void setSalary(String fullName, int salary){
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setSalary(salary);
            }
        }
    }

    public void setDepartmentId(String fullName, int departmentId){
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setDepartmentId(departmentId);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Employee employee : employeeBook) {
            if (employee != null) {
                str.append(employee.toString()).append("\n");
            }
        }
        return str.toString();
    }
}
