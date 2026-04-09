class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Blok ini mengunci objek acc1 untuk memastikan bahwa hanya satu thread yang dapat mengaksesnya pada saat yang sama, sehingga mencegah race condition saat kedua thread mencoba mengakses acc1 bersamaan.
                System.out.println("Thread t1 sedang mengakses acc1 untuk mentranfer fulus ke acc2");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulasi dengan memberikan jeda. Mengapa diperlukan Exception? Karena untuk menangani kemungkinan InterruptedException yang dapat terjadi saat thread sedang tidur.

                synchronized (acc2) { // Blok ini mengunci objek acc2 untuk memastikan bahwa hanya satu thread yang dapat mengaksesnya pada saat yang sama, sehingga mencegah race condition saat kedua thread mencoba mengakses acc2 bersamaan.
                    System.out.println("Thread t1 sedang mengakses acc2 untuk menerima fulus dari acc1");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            // jika yang di synchronized acc2 duluan maka akan terjadi deadlock karena t1 sudah mengunci acc1 и menunggu acc2, sementara t2 sudah mengunci acc2 и menunggu acc1. 
            synchronized (acc1) { // Blok ini mengunci objek acc1 untuk memastikan bahwa hanya satu thread yang dapat mengaksesnya pada saat yang sama, sehingga mencegah race condition saat kedua thread mencoba mengakses acc1 bersamaan.
                System.out.println("Thread t2 sedang mengakses acc1 untuk menerima fulus dari acc2");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Blok ini mengunci objek acc2 untuk memastikan bahwa hanya satu thread yang dapat mengaksesnya pada saat yang sama, sehingga mencegah race condition saat kedua thread mencoba mengakses acc2 bersamaan.
                    System.out.println("Thread t2 sedang mengakses acc2 untuk mentranfer fulus ke acc1");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
		System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
