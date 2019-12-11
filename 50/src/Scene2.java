public class Scene2 {
    private static final int COUNT = 1_0000;

    public static class MyThread extends Thread {
        @Override
        public void run() {
            long result = 0;
            for (int i = 0; i < COUNT; i++) {
                result += (i * i);
            }
            System.out.println(result);
        }
    }
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            long result = 0;
            for (int i = 0; i < COUNT; i++) {
                result += (i * i);
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        MyThread myThread = new MyThread();
        Thread thread2 = new Thread(myThread);
        thread2.start();
    }
}
