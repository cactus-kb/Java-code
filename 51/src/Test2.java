public class Test2 {
    static class MyThread extends Thread {
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
        MyThread thread1 = new MyThread("无私的","ll");
        thread.start();
        thread1.start();
    }
}
