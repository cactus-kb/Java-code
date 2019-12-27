public class CreateThread {
    private static final long COUNT = 100000000L;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            long r = 0;
            for (long i = 0; i < COUNT; i++) {
                r += (i * i);
            }
            System.out.println(r);
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            long r = 0;
            for (long i = 0; i < COUNT; i++) {
                r += (i * i);
            }
            System.out.println(r);
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
        thread1.start();
    }
}
