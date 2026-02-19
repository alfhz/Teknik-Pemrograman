package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        // Membuat Department
        Department itDept = new Department("IT");
        Department hrDept = new Department("HR");

        // Membuat Employment Type
        EmploymentType fullTime = new EmploymentType("Full-Time");
        EmploymentType contract = new EmploymentType("Contract");

        // Membuat Employee (menggunakan constructor & static counter)
        Employee emp1 = new Employee("Budi", itDept, fullTime, 5000000);
        Employee emp2 = new Employee("Siti", hrDept, contract, 4000000);

        // Membuat Service
        EmployeeService service = new EmployeeService();

        // Menambahkan employee ke service
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        // Menampilkan data awal
        System.out.println("=== DATA AWAL ===");
        System.out.println("ID: " + emp1.getId());
        System.out.println("Nama: " + emp1.getName());
        System.out.println("Dept: " + emp1.getDepartment().getName());
        System.out.println("Type: " + emp1.getType().getType());
        System.out.println("Salary: " + emp1.getSalary());

        System.out.println();

        // Raise salary 10%
        service.raiseSalary(emp1.getId(), 10);

        System.out.println("=== SETELAH NAIK GAJI 10% ===");
        System.out.println("Nama: " + emp1.getName());
        System.out.println("Salary Baru: " + emp1.getSalary());

        System.out.println();

        // Demonstrasi static method langsung
        double simulasi = EmployeeService.calculateNewSalary(1000000, 5);
        System.out.println("Simulasi kenaikan 5% dari 1.000.000 = " + simulasi);
    }
}
