package JavaProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemOne {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee("bob", 70000));
        list.add(new Employee("Alice", 50000));
        list.add(new Employee("Rob", 40000));
        list.add(new Employee("John", 10000));

        // Melakukan proses filtering/sorting menggunakan Stream API
        List<Employee> sortedEmp = list.stream() // Ubah list ke stream
                // Mengurutkan employee berdasarkan nama
                .sorted((e1, e2) -> e1.getName().toLowerCase().compareTo(e2.getName().toLowerCase()))
                // Mengumpulkan hasil akhir
                .collect(Collectors.toList());
        for (Employee e : sortedEmp) {
            System.out.println(e);
        }
    }
}

// Buatlah class Employee disertai dengan getter getName() dan getSalary(),
// termasuk attribute dan method lainnya jika diperlukan!

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name=\"" + name + "\", salary=" + salary + '}';
    }
}