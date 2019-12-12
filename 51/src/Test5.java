public class Test5 {
    private static int n;

    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5000; i++) {
                synchronized (Test5.class) {
                    n++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
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
