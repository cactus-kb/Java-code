public class Scene1 {
    private static final long COUNT = 1_0000;
    private static class MyThread extends Thread {
        @Override
        public void run() {
            long b = 0;
            for (long i = 0; i < COUNT; i++) {
                b += i;
            }
        }
    }
    public static void multiThread() throws InterruptedException {
        long begin = System.currentTimeMillis();
       MyThread thread = new MyThread();
       thread.start();
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += i;
        }
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
    public static void oneThread() {
        long begin = System.currentTimeMillis();
        long b = 0;
            for (long i = 0; i < COUNT; i++) {
            b += i;
        }
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void main(String[] args) throws InterruptedException {
        oneThread();
        multiThread();
    }
}
