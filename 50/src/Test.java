import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int N = scaner.nextInt();
        int a = 0;
        int b = 1;
        int c;
        while (b <= N) {
            c = a + b;
            a = b;
            b = c;
        }
        int ret1 = N - b;
        int ret2 = a + b - N;
        if (ret1 < 0) {
            ret1 *= -1;
        }
        if (ret2 < 0) {
            ret2 *= -1;
        }
        if (ret1 > ret2) {
            System.out.println(ret2);
        } else {
            System.out.println(ret1);
        }
    }
}
