package No3;

public class EmployeeTest {
    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[3];

        // Inisialisasi data karyawan
        staff[0] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[1] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        System.out.println("=== Memanggil Metode compare() ===");
        // Menguji metode compare (membandingkan Antonio dan Maria)
        int hasilCompare = staff[0].compare(staff[1]);
        System.out.println("Hasil komparasi index 0 vs index 1: " + hasilCompare);
        if (hasilCompare == -1) {
            System.out.println("-> Gaji index 0 lebih kecil dari index 1");
        } else if (hasilCompare == 1) {
            System.out.println("-> Gaji index 0 lebih besar dari index 1");
        } else {
            System.out.println("-> Gaji index 0 sama dengan index 1");
        }

        // Menaikkan gaji setiap staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        System.out.println("\n=== Sebelum Diurutkan ===");
        // Mencetak data dari setiap staf
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // Mengurutkan array staff berdasarkan gaji menggunakan shell sort
        Sortable.shell_sort(staff);
        System.out.println("\n=== Setelah Diurutkan Berdasarkan Gaji (Ascending) ===");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

    }
}

