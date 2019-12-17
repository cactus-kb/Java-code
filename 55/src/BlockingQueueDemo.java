import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    private static long fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 1);
    }

    private static class Customer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    int n = queue.take();
                    long result = fib(n);
                    System.out.printf("fib(%d) = %d%n",n,result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.start();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：n ");
            int n = scanner.nextInt();
            queue.put(n);
        }
    }
}
