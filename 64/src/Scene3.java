import java.util.Scanner;

public class Scene3 {
    private static long fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static class MyThread extends Thread {
        private int n;
        MyThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long result = fib(n);
            System.out.printf("fib(%d)的结果 %d%n",n,result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("please input n: ");
            int n = scanner.nextInt();
            //Thread t = new MyThread(n);
            MyThread myThread = new MyThread(n);
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }
}
