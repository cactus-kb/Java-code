import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int c = gongyishu(A,B);
        int result = A * B / c;
        System.out.println(result);
    }

    private static int gongyishu(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            if (a == b) {
                return a;
            }
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
