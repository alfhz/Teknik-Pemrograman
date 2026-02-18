public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }
    
    // Getters
    public String getNamaMakanan() {
        return nama_makanan[id];
    }

    public double getHargaMakanan() {
        return harga_makanan[id];
    }

    public int getStok() {
        return stok[id];
    }

    // Setters
    public void setNamaMakanan(String nama) {
        this.nama_makanan[id] = nama;
    }
    public void setHargaMakanan(double harga) {
        this.harga_makanan[id] = harga;
    }
    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok[id] = stok;
        } else {
            System.out.println("Stok " + nama_makanan[id] + " tidak mencukupi."); // validasi stok tidak boleh negatif
        }
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                    i + 1 + ". " + nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void pesanMakanan(int id, int jumlah) {
        if (isOutOfStock(id)) {
            System.out.println("Sorry, " + nama_makanan[id] + " sudah habis.");
        } else if (stok[id] < jumlah) {
            System.out.println("Sorry, stok " + nama_makanan[id] + " tidak mencukupi.");
        } else {
            stok[id] -= jumlah;
            System.out.println("Pesanan " + jumlah + " " + nama_makanan[id] + " berhasil.");
        }
    }

    public static void nextId() {
        id++;
    }
}
