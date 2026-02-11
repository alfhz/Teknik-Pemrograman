import java.util.Scanner;

public class W1_DataTypes {
    public static void main(String[] args) {
        long T;
        Scanner myObj = new Scanner(System.in);
        T = myObj.nextLong();
        for (int i = 1; i <= T; i++) {
            try {
                long x = myObj.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                if (x >= -32768 && x <= 32767) System.out.println("* short");
                if (x >= -2147483648L && x <= 2147483647L) System.out.println("* int");
                System.out.println("* long");
            } catch (Exception e) {
                System.out.println(myObj.next() + " can't be fitted anywhere.");
            }
        }
    }
}
