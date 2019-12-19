import java.util.Scanner;

public class Test2 {

    /*
    private static long fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static class MyThrad extends Thread {
        private int n;
        MyThrad (int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long result = fib(n);
            System.out.printf("fib(n)的计算结果为 %d%n",n,result);
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("n is :");
            int n = scanner.nextInt();
            Thread thread = new MyThrad(n);
            thread.start();
        }
    }

    private static class MyThread1 extends Thread {
        @Override
        public void run() {

        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        MyThread1 myThrad = new MyThread1();
        myThrad.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        t.start();
    }
    */

    private static final long COUNT = 100000000L;

    private static class MyThread extends Thread {
        private static long rusult = 0;
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                rusult += (i * i);
            }
            System.out.println(rusult);
        }
    }

    private static class MyRunnable implements Runnable {
        private static long rusult = 0;
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                rusult += (i * i);
            }
            System.out.println(rusult);
        }
    }

    public static void main2(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        MyThread myThread1 = new MyThread();
        Thread t = new Thread(myThread1);
        t.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    public static void main3(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getId());
        System.out.println(currentThread.getState());
        System.out.println(currentThread.getPriority());
        System.out.println(currentThread.getName());
        System.out.println(currentThread.isAlive());
        System.out.println(currentThread.isInterrupted());
        System.out.println(currentThread.isDaemon());
    }


    private static class Worker extends Thread {
        private  volatile boolean running = true;

        public void quit() {
            running = false;
        }
        @Override
        public void run() {
            while (running) {
                System.out.println("挖煤");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(10000);
        System.out.println("快回家吧");
        worker.quit();
        worker.join();
        System.out.println("回去了");
    }
 }
