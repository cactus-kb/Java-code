import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer s = new StringBuffer(str);
        s.reverse();
        System.out.println(s.toString());
    }


    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(zero(n));
    }
    private static int zero(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + zero(n / 5);
    }


    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(), res = 0;
            for (int i = 5; i <= n; i *= 5) {
                res += n / i;
            }
            System.out.println(res);
        }
        in.close();
    }


    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 1;
        for (double i = 1; i <= n; i++) {
            result = result * i;
        }
    }



    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 1;
        for (double i = 1; i <= n; i++) {
            result = result * i;
        }
        int count = 0;
        while (result >= 1) {
            result /= 5;
            if (result % 5 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 1;
        for (double i = 1; i <= n; i++) {
            result = result * i;
        }
        int zero = 0;
        while (result >= 1) {
            double a = result / 5;
            double yu = result % 5;
            if (yu == 0) {
                zero += a;
            }
            result = a;
        }
        System.out.println(zero);
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 1;
        for (double i = 1; i <= n; i++) {
            result = result * i;
        }
        Stack<Double> stack = new Stack<>();
        while (result >= 1) {
            double a = result / 10;
            double yu = result % 10;
            if (yu == 0) {
                stack.push(yu);
            }
            result = a;
        }
        System.out.println(stack.size());
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 1;
        for (double i = 1; i <= n; i++) {
            result = result * i;
        }
        Stack<Double> stack = new Stack<>();
        while (result > 1) {
            double a = result / 10;
            double yu = result % 10;
            stack.add(yu);
            result = a;
        }
        int count = 0;
       while (!stack.empty()) {
            if (stack.peek() == 0) {
                count++;
                stack.pop();
            } else {
                stack.pop();
            }
       }
        System.out.println(count);
    }
}
