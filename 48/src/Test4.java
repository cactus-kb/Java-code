public class Test4 {

    private static final long COUNT = 1_0000_0000;

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            long a = 0;
            long result = 0;
            for (long i = 0; i < COUNT; i++) {
                a = i * i;
                result += a;
            }
            System.out.println(result);
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            long a = 0;
            long result = 0;
            for (long i = 0; i < COUNT; i++) {
                a = i * i;
                result += a;
            }
            System.out.println(result);
        }
    }



    public static void main(String[] args) {
        //方法一
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        //方法二
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();


        //方法三
        MyThread1 myThread11 = new MyThread1();
        Thread thread1 = new Thread(myThread11);
        thread1.start();

    }
}
