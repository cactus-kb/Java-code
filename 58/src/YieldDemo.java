public class YieldDemo {
    /*
    private static class MyThread extends Thread {
        private final String message;

        MyThread(String name, String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while(true) {
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
                System.out.println(Thread.currentThread().getName() + " : " + message);
                yield();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread("自私的","sing");
        MyThread2 thread2 = new MyThread2("不自私的","sing");
        thread.start();
        thread2.start();
    }
    */


    private static class MyThread extends Thread {
        private final String message;

        MyThread(String name, String message) {
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

    private static class MyRunnable implements Runnable {
        private final String message;

        MyRunnable(String name, String message) {
            super();
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + message);
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("自私的","sing");
        Thread thread = new Thread(myRunnable);
        thread.start();
        MyThread myThread = new MyThread("不那么自私的","sing");
        myThread.start();
    }
}
