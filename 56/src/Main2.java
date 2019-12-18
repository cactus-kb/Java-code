import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        //最小公倍数 = 两数的乘积 / 最大公因数
        int c = Max_gongyinshu(A, B);
        int result = A * B / c;
        System.out.println(result);
    }

    private static int Max_gongyinshu(int a, int b) {
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
