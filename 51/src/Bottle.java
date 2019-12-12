import java.util.Scanner;

public class Bottle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 1) {
                System.out.println("0");
            }
            int count = 0;
            while (n > 1) {
                count = count + n / 3;
                n = n / 3 + n % 3;
                if (n == 2) {
                    n++;
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }
}
