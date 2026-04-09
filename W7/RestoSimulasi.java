class Resto {
    // variabel chickenstock diinisialisasi dengan nilai 100
    private int chickenStock = 100;

    // penggunaan keyword synchronized memastikan metode ini bersifat atomic dan mencegah race condition
    public synchronized void serveCustomer(String cashierName) {
        // pengecekan stok dilakukan di dalam blok tersinkronisasi agar pembacaan data selalu akurat
        if (chickenStock > 0) {
            try {
                // simulasi durasi transaksi dengan memberikan jeda waktu pada thread
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // penanganan interruptedException diperlukan karena penggunaan metode sleep
            }

            // pengurangan stok dilakukan secara eksklusif oleh satu thread pada satu waktu
            chickenStock--;
            System.out.println(cashierName + " berhasil menjual 1 ayam. sisa stok: " + chickenStock);
        } else {
            // pesan ini akan dicetak jika kondisi chickenstock > 0 sudah tidak terpenuhi
            System.out.println(cashierName + " gagal: stok habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        // pembuatan objek runnable yang akan dijalankan oleh setiap thread
        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        // instansiasi tiga objek thread yang merepresentasikan tiga kasir berbeda
        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        // memulai eksekusi thread secara paralel
        kasir1.start();
        kasir2.start();
        kasir3.start();

        // penggunaan metode join untuk memastikan main thread menunggu seluruh thread
        // kasir selesai
        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("\n--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}