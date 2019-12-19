import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Random;
import java.util.Scanner;

public class MyBlocking {
    private static long fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("n is :");
            int n = scanner.nextInt();
            long result = fib(n);
            System.out.printf("fib(n)的结果为：%d%n",n,result);
        }
    }




    private static final long COUNT =100000000L;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            long b = 0;
            for (long i = 0; i < COUNT; i++) {
                b += i;
            }
        }
    }

    public static void multithread() throws InterruptedException {
        long begin = System.currentTimeMillis();
        MyThread thread = new MyThread();
        thread.start();
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += i;
        }
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    private static void oneThread() {
        long begin = System.currentTimeMillis();
        long b = 0;
        for (long i = 0; i < COUNT; i++) {
            b += i;
        }
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void main2(String[] args) throws InterruptedException {
        oneThread();
        multithread();
    }


    /*
    private int[] array = new int[10];
    private volatile int size = 0;
    private int front = 0;
    private int rear = 0;

    public void put(int val) {
        if (size == array.length) {
            throw new RuntimeException("满了");
        }
        array[rear] = val;
        rear = (rear + 1) % array.length;
        synchronized (this) {
            size++;
        }
    }

    public int take() {
        if (size == 0) {
            throw new RuntimeException("空了");
        }
        int val = array[front];
        front = (front + 1) % array.length;
        synchronized (this) {
            size--;
        }
        return val;
    }

    public int getSize() {
        return size;
    }

    private static ArrayDeque queue = new ArrayDeque();

    private static class Producer extends Thread {
        Producer() {
            super("生产者");
        }

        PrintWriter printWriter;
        {
            try {
                printWriter = new PrintWriter("生产了.txt", "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Random random = new Random(20191216);
            for (int i = 0; i < 1000; i++) {
                int val = random.nextInt(100);
                printWriter.println(val);
                do {
                    try {
                        queue.put(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                } while (true);
            }
            printWriter.close();
        }
    }

    private static class Customer extends Thread {
        PrintWriter printWriter;
        Customer() {
            super("消费者");
        }

        {
            try {
                printWriter = new PrintWriter("消费了.txt", "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                do {
                    int val = 0;
                    try {
                        val = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printWriter.println(val);
                    break;
                } while (true);
            }
            printWriter.close();
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        Customer customer = new Customer();
        customer.start();
    }
    */
}
