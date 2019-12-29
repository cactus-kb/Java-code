import java.util.Scanner;

public class Scene {
    private static long fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private static class MyThread extends Thread {
        private int n;
         MyThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long result = fib(n);
            System.out.printf("fib(%d)的计算结果为%d%n", n, result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要计算的n: ");
            int n = scanner.nextInt();
            Thread thread = new MyThread(n);
            thread.start();
        }
    }
}
