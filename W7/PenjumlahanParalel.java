import java.util.Scanner;

class SumWorker extends Thread {
    private int start;
    private int end;
    private long partialSum = 0;

    public SumWorker(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // metode run berisi logika penjumlahan angka dalam rentang yang ditentukan oleh thread ini dan menyimpan hasilnya dalam variabel partialSum yang dapat diakses setelah thread selesai berjalan 
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " mengerjakan rentang: " + start + " - " + end);
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
    }

    // metode untuk mengambil hasil penjumlahan parsial setelah thread selesai berjalan
    public long getPartialSum() {
        return partialSum;
    }
}

public class PenjumlahanParalel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // menerima input dari pengguna untuk jumlah thread dan angka akhir yang akan dijumlahkan
        System.out.print("masukkan jumlah thread: ");
        int numThreads = input.nextInt();
        System.out.print("masukkan angka akhir: ");
        int endNumber = input.nextInt();

        // array untuk menyimpan objek thread yang akan melakukan penjumlahan parsial
        SumWorker[] workers = new SumWorker[numThreads];
        int range = endNumber / numThreads;
        int remainder = endNumber % numThreads;
        int currentStart = 1;

        // pembagian tugas (divide and conquer) kepada setiap thread untuk menghitung penjumlahan dalam rentang yang berbeda
        // pembagian dilakukan dengan tiap thread mendapatkan rentang angka yang sama, kecuali thread terakhir yang mungkin mendapatkan sisa angka jika endNumber tidak habis dibagi numThreads
        for (int i = 0; i < numThreads; i++) {
            int currentEnd = currentStart + range - 1;

            // sebar sisa pembagian (remainder) ke thread awal secara bertahap untuk memastikan semua angka hingga endNumber terhitung dengan adil
            if (i < remainder) {
                currentEnd++;
            }

            workers[i] = new SumWorker(currentStart, currentEnd);
            workers[i].setName("thread-" + (i + 1));
            workers[i].start();

            currentStart = currentEnd + 1;
        }

        long totalSum = 0;
        try {
            // sinkronisasi menggunakan join untuk memastikan semua thread selesai sebelum total dihitung dan ditampilkan
            for (int i = 0; i < numThreads; i++) {
                workers[i].join();
                long pSum = workers[i].getPartialSum();
                System.out.println("hasil parsial " + workers[i].getName() + ": " + pSum);
                totalSum += pSum;
            }
        } catch (InterruptedException e) {
            // penanganan error jika proses sinkronisasi thread terganggu dengan menangkap InterruptedException yang mungkin terjadi saat menunggu thread selesai
        }

        // menampilkan hasil akhir penjumlahan dari seluruh thread
        System.out.println("\n--- HASIL AKHIR TOTAL: " + totalSum + " ---");

        input.close();
    }
}