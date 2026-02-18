import java.util.Scanner;   

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        
        // Set menu makanan
        // Menu 1
        menu.setNamaMakanan("Indomie");
        menu.setHargaMakanan(15000);
        menu.setStok(20);
        Restaurant.nextId();
        // Menu 2
        menu.setNamaMakanan("Indomie Spesial");
        menu.setHargaMakanan(20000);
        menu.setStok(30);
        Restaurant.nextId();
        // Menu 3
        menu.setNamaMakanan("Indomie Super Spesial");
        menu.setHargaMakanan(25000);
        menu.setStok(5);
        Restaurant.nextId();
        
        // Tampilkan menu makanan
        System.out.println("\n------------------------------------------"); 
        menu.tampilMenuMakanan();
        System.out.println("------------------------------------------"); 
        
        // Pesan makanan
        Scanner scan = new Scanner(System.in);
        String pilihan;
        do{
            System.out.println("Masukkan nomor makanan yang ingin dipesan: ");
            int noMakanan = scan.nextInt();
            System.out.println("Masukkan jumlah pesanan: ");
            int jumlahPesanan = scan.nextInt();
            scan.nextLine(); // Membersihkan buffer setelah membaca angka
            menu.pesanMakanan(noMakanan - 1, jumlahPesanan); // -1 karena indeks array dimulai dari 0
            System.out.println("Apakah Anda ingin memesan lagi? (y/n)");
            pilihan = scan.nextLine();
            
        } while(pilihan.equalsIgnoreCase("y"));
        scan.close();
        
        System.out.println("\nTerima kasih telah memesan!");
        System.out.println("\n------------------------------------------"); 
        System.out.println("Stok telah diperbarui!");
        menu.tampilMenuMakanan(); // Tampilkan menu makanan setelah pemesanan untuk melihat perubahan stok
        System.out.println("------------------------------------------"); 
    }
}
