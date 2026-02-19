import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        Department it = new Department("IT");
        EmploymentType full = new EmploymentType("Full-Time");

        Employee emp = new Employee("Andi", it, full, 6000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp);

        System.out.println("Nama: " + emp.getName());
        System.out.println("Dept: " + emp.getDepartment().getName());
        System.out.println("Gaji Awal: " + emp.getSalary());

        service.raiseSalary(emp.getId(), 20);

        System.out.println("Gaji Setelah Naik 20%: " + emp.getSalary());
    }
}
