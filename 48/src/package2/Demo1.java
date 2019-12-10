package package2;

public class Demo1 {
    private static final long COUNT = 1000_000L;

    public static class MyThread extends Thread {
        @Override
        public void run() {
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a += i;
            }
        }
    }

    public static void multiThread() throws InterruptedException {
        long begin = System.currentTimeMillis();
        MyThread myThread = new MyThread();
        myThread.start();
        long b = 0;
        for (long i = 0; i < COUNT; i++) {
            b += i;
        }
        myThread.join();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void oneThread() {
        long begin = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += i;
        }
        long b = 0;
        for (long i = 0; i < COUNT; i++) {
            b += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void main(String[] args) throws InterruptedException {
        oneThread();
        multiThread();
    }
}
