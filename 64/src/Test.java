import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int count = 0;
        if (x / 1000000007 != 0) {
            if (x / 1000000007 != 0) {
                while (x / 1000000007 != 0) {
                    x = 4 * x + 3;
                    count++;
                }
                System.out.println(count);
            } else if (x / 1000000007 != 0) {
                while (x / 1000000007 != 0) {
                    x = 8 * x + 7;
                    count++;
                }
                System.out.println(count);
            } else {
                System.out.println("-1");
            }
        }
    }



    public static void main1(String[] args) {
        int a = 10;
        int b = 22;
        int result = addAB(a,b);
        System.out.println(result);
    }
    public static int addAB(int A, int B) {
        int result = Math.addExact(A, B);
        return result;
    }
}
