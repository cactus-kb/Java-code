import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class YieldDemo {
    private static long n = 0L;
    private static class MyThread3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                synchronized (this) {
                    n++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i =0; i < 5; i++) {
            Thread t = new MyThread3();
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println(n);
    }



    enum week {
        monday, tuesday,wendesday, thusday, friday, staturday,sunday;
    }

    public static void main3(String[] args) {
        week[] value = week.values();
        System.out.println(Arrays.toString(value));
    }


    private static class MyThread extends Thread {
        private final String message;

        MyThread(String name,String messaage) {
            super(name);
            this.message = messaage;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + message);
            }
        }
    }

    private static class MyThread2 extends Thread {
        private final String message;

        MyThread2(String name, String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + message);
                yield();
            }
        }
    }

    public static void main1(String[] args) {
        MyThread thread = new MyThread("A","123");
        MyThread2 thread2 = new MyThread2("B","456");
        thread.start();
        thread2.start();
    }

    public static void main2(String[] args) throws InterruptedException {
        System.out.println("12");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("56");
    }

    /*
    private static class MyThread extends Thread {
        private final String message;
        MyThread(String name, String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " : " + message);
            }
        }
    }
    private static class MyThread2 extends Thread {
        private final String message;

        MyThread2(String name, String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " : " + message );
                yield();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread("A","哈哈");
        MyThread2 thread2 = new MyThread2("B","哼哼");
        thread.start();
        thread2.start();
    }
    */
}
