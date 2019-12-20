public class Unsafe {
    private static long n = 0L;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                synchronized (this) {
                    n++;
                }
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                n++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Thread t = new MyThread2();
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println(n);
    }

    public static void main1(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Thread t = new MyThread();
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println(n);
    }
}
