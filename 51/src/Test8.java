import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            bootle(n);
        }
        scanner.close();
    }

    //n空瓶个数
    public static void bootle(int n) {
        int count = 0;//可喝汽水瓶数
        if (n == 1) {
            System.out.println();
        }
        while (n > 1) {
            count += n / 3;
            n = n / 3 + n % 3;
            if (n == 2) {
                n++;
            }
        }
        System.out.println(count);
    }
}
