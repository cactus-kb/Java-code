package pckage1;

public class ThreadWithName {
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("haha");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable(),"我是干活的");
        thread2.start();

        Thread thread3 = new Thread(new MyRunnable(),"我也是干活的");
        thread3.start();
    }
}
