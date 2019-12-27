public class Test2 {
    private static final long COUNT = 100000000L;
    private static class MyThread extends Thread {
        @Override
        public void run() {
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a += (i * i);
            }
            System.out.println(a);
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a += (i * i);
            }
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(thread1);
        thread2.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread3 = new Thread(myRunnable);
        thread3.start();
    }
}
