public class ThreadWithName {
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        Thread thread1 = new Thread(new MyRunnable(),"我是干活的 +++");
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable(),"我是干活的");
        thread2.start();
    }
}
