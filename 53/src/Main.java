import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = n / 6;
        int n2 = n % 6;
        int n3 = n / 8;
        int n4 = n % 8;
        if (n1 != 0) {
            if (n1 == 1 && n2 == 0) {
                System.out.println("1");
            }
            if (n1 != 0 && (n2 % 8) == 0) {
                int ret = n1 + (n2 % 8);
                if (n4 == 0) {
                    if (ret > n3) {
                        System.out.println(n3);
                    } else {
                        System.out.println(ret);
                    }
                } else {
                    System.out.println(ret);
                }
            } else {
                System.out.println("-1");
            }
        } else {
            System.out.println("-1");
        }
    }
}
