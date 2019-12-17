import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ArrayQueue {

    private int[] array = new int[10];
    private volatile int size = 0;   // 有效元素个数
    private int front = 0;
    private int rear = 0;

    public  void put(int val) throws InterruptedException {
        if (size == array.length) {
            synchronized (this) {
                wait();
            }
        }

        array[rear] = val;
        rear = (rear + 1) % array.length;
        synchronized (this) {
            size++;
            notify();
        }
    }

    public int take() throws InterruptedException {
        if (size == 0) {
            synchronized (this) {
                wait();
            }
        }

        int val = array[front];
        front = (front + 1) % array.length;
        synchronized (this) {
            size--;
            notify();
        }
        return val;
    }

    public int getSize() {
        return size;
    }

    private static ArrayQueue queue = new ArrayQueue();

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
                    try {
                        queue.put(val);
                        break;
                    } catch (RuntimeException e) {
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                    try {
                        int val = queue.take();
                        printWriter.println(val);
                        break;
                    } catch (RuntimeException e) {
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
    
}
