public class Test2 {
    private static final long COUNT = 1_0000_0000L;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            long b = 0;
            for (long i = 0; i < COUNT; i++) {
                b += i;
            }
        }
    }

    private static void multiThread() throws InterruptedException {
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
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += i;
        }
        long b = 0;
        for (long j = 0; j < COUNT;j++) {
            b += j;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void main2(String[] args) throws InterruptedException {
        oneThread();
        multiThread();
    }
}
