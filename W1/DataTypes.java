import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        int T;
        T = scanner.nextInt();
        String[] Number = new String[(int) T];
        for (int i = 0; i < Number.length; i++) {
            Number[i] = scanner.next();
        }
        for (int i = 0; i < Number.length; i++) {
            try {
                long N = Long.parseLong(Number[i]);
                System.out.println(Number[i] + " can be fitted in:");
                if(N >= -128 && N <= 127){
                    System.out.println("* byte");
                }
                if(N >= -32768 && N <= 32767){
                    System.out.println("* short");
                }
                if(N >= -2147483648L && N <= 2147483647L){
                    System.out.println("* int");
                }
                if(N >= -9223372036854775808L && N <= 9223372036854775807L){
                    System.out.println("* long");
                }
            } catch(Exception e){
                System.out.println(Number[i] + " can't be fitted anywhere.");
            }
        }

    }
}
