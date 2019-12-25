

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.PriorityBlockingQueue;

public class MyTimer2 {
    private static class MyTimerTask {
        long runAtTime;
        Runnable target;

        public MyTimerTask (long delay, Runnable target) {
            this.runAtTime = System.currentTimeMillis() + delay;
            this.target = target;
        }
    }

    private PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();
    Thread worker = new worker();
    private  class worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    MyTimerTask task = queue.take();
                    if (task.runAtTime <= System.currentTimeMillis()) {
                        task.target.run();
                    } else {
                        queue.put(task);
                        Thread.sleep(task.runAtTime - System.currentTimeMillis());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    MyTimer2() {
        worker.start();
    }

    public void schedule(Runnable task, long delay) {
        MyTimerTask task1 = new MyTimerTask(delay, task);
        queue.put(task1);
    }

    public static void main(String[] args) {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println("5秒后");
            }
        };
        MyTimer2 timer = new MyTimer2();
        timer.schedule(target,5000);
    }

    public static void main1(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("哈哈");
            }
        };
        timer.schedule(task,5000);
    }
}
