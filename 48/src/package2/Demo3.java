package package2;

public class Demo3 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("这是线程运行的代码");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("i'm runnable");
        }
    }


    public static void main(String[] args) {
        MyRunnable t = new MyRunnable();
        Thread thread = new Thread(t);
        thread.start();
    }
    public static void main1(String[] args) {
        MyThread thread = new MyThread();
        thread.run();
        System.out.println("aha");
    }
}
