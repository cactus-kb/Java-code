package package2;

import java.util.Map;

public class Demo2 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("这是线程运行的代码");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("haha");
        myThread.start();
    }
}
