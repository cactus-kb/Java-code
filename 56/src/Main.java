import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        boolean b = isPrime(A);
        boolean b1 = isPrime(B);
            if (b == true && b1 == true) {
                System.out.println(A * B);
            } else if (b == false && b1 == false) {
                if (A % B == 0) {
                    System.out.println(A);
                } else if (B % A == 0) {
                    System.out.println(B);
                } else {
                    System.out.println(A * B / 2);
                }
            } else if (b == true && b1 == false) {
                if (B % A == 0) {
                    System.out.println(B);
                } else {
                    System.out.println(A * B);
                }
            } else if (b == false && b1 == true) {
                if (A % B == 0) {
                    System.out.println(A);
                } else {
                    System.out.println(A * B);
                }
            }
    }

    private static boolean isPrime(int n) {
        int i = 2;
        while (i != n) {
            int b = n % i;
            if (b != 0) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
