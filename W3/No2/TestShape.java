package No2;

public class TestShape {
    public static void main(String[] args) {
        System.out.println("=== Menguji Class Shape ===");

        // 1. Menguji No-arg Constructor (Constructor tanpa parameter)
        Shape shape1 = new Shape();
        System.out.println("\n--- Test No-arg Constructor ---");
        System.out.println(shape1.toString()); 
        
        // Menguji Getter pada objek shape1
        System.out.println("Mendapatkan warna: " + shape1.getColor());
        System.out.println("Apakah terisi? " + shape1.isFilled());

        // 2. Menguji Parameterized Constructor
        Shape shape2 = new Shape("blue", false);
        System.out.println("\n--- Test Parameterized Constructor ---");
        System.out.println(shape2.toString()); 

        // 3. Menguji Setter
        System.out.println("\n--- Test Setter ---");
        shape2.setColor("yellow");
        shape2.setFilled(true);
        
        // Memastikan nilai sudah berubah menggunakan Getter dan toString
        System.out.println("Warna setelah diubah: " + shape2.getColor());
        System.out.println("Status terisi setelah diubah: " + shape2.isFilled());
        System.out.println("Hasil toString setelah diubah: " + shape2.toString());

        // 4. Menguji Subclass (Rectangle, Circle, Square)
        System.out.println("\n=== Menguji Subclass ===");
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        Rectangle r2 = new Rectangle(2.0, 3.0);
        System.out.println(r2);
        Rectangle r3 = new Rectangle(4.0, 5.0, "blue", true);
        System.out.println(r3);

        Circle c1 = new Circle();
        System.out.println(c1);
        Circle c2 = new Circle(2.5);
        System.out.println(c2);
        Circle c3 = new Circle(3.5, "yellow", false);
        System.out.println(c3);

        Square sq1 = new Square();
        System.out.println(sq1);
        Square sq2 = new Square(4.0);
        System.out.println(sq2);
        Square sq3 = new Square(5.0, "purple", true);
        System.out.println(sq3);
    }
}
