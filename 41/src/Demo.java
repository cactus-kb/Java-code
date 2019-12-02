import java.util.Random;

public class Demo {
    public static void main7(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }

    public static void main6(String[] args) throws InterruptedException {
        Runnable target = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() +  ": 我还在工作！");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "：我结束了!");
        };
        Thread thread1 = new Thread(target,"李四");
        Thread thread2 = new Thread(target,"王五");
        System.out.println("先让李四开始工作");
        thread1.start();
        //thread1.join();
        System.out.println("李四工作结束，王五开始工作");
        thread2.start();
        //thread2.join();
        System.out.println("王五工作结束了");
    }


    private static class MyRunnable implements Runnable {
        public volatile boolean isQuit = false;
        @Override public void run() {
            while (!isQuit) { System.out.println(Thread.currentThread().getName() +
                    ": 别管我，我忙着转账呢!"); try {Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            System.out.println(Thread.currentThread().getName() +
                    ": 啊！险些误了大事");
        }
    }
    public static void main5(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName() + ": 让李四开始转账。");
        thread.start(); Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName() +
                ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        target.isQuit = true;
    }


    public static void main4(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": 我还活着");
                    Thread.sleep(1 * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ ": 我即将死去");
        });
        System.out.println(Thread.currentThread().getName() + ": ID；" + thread.getId());
        System.out.println(Thread.currentThread().getName() + ": 名称：" + thread.getName());
        System.out.println(Thread.currentThread().getName() + ": 状态：" + thread.getState());
        System.out.println(Thread.currentThread().getName() + ": 优先级：" + thread.getPriority());
        System.out.println(Thread.currentThread().getName() + ": 后台线程：" + thread.isDaemon());
        System.out.println(Thread.currentThread().getName() + ": 活着：" + thread.isAlive());
        System.out.println(Thread.currentThread().getName() + ": 被中断：" + thread.isInterrupted());
        thread.start();
        while (thread.isAlive()) {
            System.out.println(Thread.currentThread().getName() + ": 状态：" + thread.getState());
        }
    }

    /*

    private static final long count = 1000000000;

    public static void main3(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
    private static void concurrency() throws InterruptedException {
        long begin = System.nanoTime();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a--;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("并发：%f 毫秒%n",ms);
    }

    private static void serial() {
        long begin = System.nanoTime();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a--;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("串行： %f 毫秒%n",ms);
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main2(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.start();
        t2.start();
        t3.start();

        Random random = new Random();
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main1(String[] args) throws InterruptedException {
        Thread.sleep(99999999);
    }
    */
}


