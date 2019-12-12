public class Test3 {
    private static class MyThread1 extends Thread {
        public final String message;

        MyThread1(String name,String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " :" + message);
                yield();
            }
        }
    }

    private static class MyThread extends Thread {
        public final String message;

        MyThread(String name,String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " :" + message);
                yield();
            }
        }
    }
    public static void main(String[] args) {
        MyThread thread = new MyThread("自私的","haha");
        MyThread1 thread1 = new MyThread1("无私的","ll");
        thread.start();
        thread1.start();
    }
}
