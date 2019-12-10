package pckage1;

public class CreateThread {
    private static final long COUNT = 10_000L;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            long result = 0;
            for (long i = 0; i < COUNT; i++) {
                result += (i * i);
            }
            System.out.println(result);
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            long result = 0;
            for (long i = 0; i < COUNT; i++) {
                result += (i * i);
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        MyThread myThread1 = new MyThread();
        Thread thread1 = new Thread(myThread1);
    }
}
