public class Test4 {
    private static long n;
    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000;i++) {
                n++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] thread = new Thread[5];
        for (int i = 0; i < 5;i++) {
            Thread t = new MyThread();
            t.start();
            thread[i] = t;
        }
        for (int i = 0; i < 5; i++) {
            thread[i].join();
        }
        System.out.println(n);
    }
}
