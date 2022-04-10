package pro.sky.java.course1;

public class Main {

    public static void main(String[] args) {
        EmployeeBook book1 = new EmployeeBook(10);

        Employee emp1 = new Employee("zivert", 500, 5);
        Employee emp2 = new Employee("lady_gaga", 400, 4);
        Employee emp3 = new Employee("miyagi", 300, 3);
        Employee emp4 = new Employee("avicii", 400, 3);
        Employee emp5 = new Employee("zaz", 200, 2);
        Employee emp6 = new Employee("oxxxy", 100, 2);
        Employee emp7 = new Employee("messi", 100, 2);

        book1.addEmployee(emp1);
        book1.addEmployee(emp2);
        book1.addEmployee(emp3);
        book1.addEmployee(emp4);
        book1.addEmployee(emp5);
        book1.addEmployee(emp6);
        book1.addEmployee(emp7);

        book1.dropEmployee("oxxxy");
        book1.addEmployee(emp6);
        book1.dropEmployee(6);
        book1.addEmployee(emp6);

        book1.printMinSalary();
        book1.printMinSalary(2);

        book1.printMaxSalary();
        book1.printMaxSalary(2);

        System.out.println("sum salary month: " + book1.countSumMonthSalary());
        System.out.println("sum salary month(dep 3): " + book1.countSumMonthSalary(3) + "\n");

        System.out.println("avg salary: " + book1.getAverageSalary());
        System.out.println("avg salary(dep 3): " + book1.getAverageSalary(3) + "\n");

        book1.indexingSalary(10);
        book1.indexingSalary(10,3);


        book1.setSalary("zivert", 600);
        book1.setDepartmentId("zivert", 2);

        System.out.print("Список всех сотрудников по отделам: ");
        book1.printEmployees();
        System.out.println();

        System.out.print("Список сотрудников отдела 3: ");
        book1.printEmployees(3);
        System.out.println();

        book1.printEmployeesHigherSalary(300);
        book1.printEmployeesLowerSalary(300);

        System.out.println(book1.toString());

    }
}
