package package2;

public class ThreadDemo {
    private static class MyThread implements Runnable {
        public volatile boolean quit = false;

        @Override
        public void run() {
            while (!quit) {
                System.out.println(Thread.currentThread().getName() + ": 别管我，我忙着转账呢");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": 险些误了大事");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread target = new MyThread();
        Thread thread = new Thread(target,"李四");
        System.out.println(Thread.currentThread().getName() + ": 让李四开始转账");
        thread.start();
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + ": 得赶快通知李四对方是个骗子");
        target.quit = true;
    }
}
