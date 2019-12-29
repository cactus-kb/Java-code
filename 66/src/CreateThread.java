public class CreateThread {
    private static final long COUNT = 100_0000L;
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
        MyThread thread = new MyThread();
        thread.start();

//        MyThread myThread = new MyThread();
//        Thread thread1 = new Thread(myThread);
//        thread1.start();

        new Thread(new MyThread()).start();

//
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread2 = new Thread(myRunnable);
//        thread2.start();
        new Thread(new MyRunnable()).start();
    }
}
