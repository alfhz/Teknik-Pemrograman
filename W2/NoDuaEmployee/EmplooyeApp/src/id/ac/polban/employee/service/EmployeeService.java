package id.ac.polban.employee.service;

import java.util.HashMap;
import java.util.Map;

import id.ac.polban.employee.model.*;

// mengelola operasi yang berkaitan dengan data dan aturan bisnis
public class EmployeeService {
    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    // static method untuk menghitung gaji baru berdasarkan persentase kenaikan
    public static double calculateNewSalary(double salary, double percent) {
        return salary * (1 + percent / 100);
    }
    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            double newSalary = calculateNewSalary(emp.getSalary(), percent);
            emp.setSalary(newSalary);
        }
    }
}
