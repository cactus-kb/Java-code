import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolDemo {
    private static class Worker extends Thread {

        private BlockingQueue<Runnable> queue = null;
        Worker(BlockingQueue<Runnable> queue) {
            super("工人");
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Runnable command = queue.take();
                    command.run();
                }
            } catch (InterruptedException e) {

            }
        }
    }
    private int corePoolSize = 10;
    private int currentPoolSize = 0;
    private List<Worker> workerList = new ArrayList<>();
    private  BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public void execute(Runnable command) {
        if (currentPoolSize < corePoolSize) {
            Worker worker = new Worker(queue);
            worker.start();
            workerList.add(worker);
            currentPoolSize++;
        }
        queue.add(command);
    }

    public void shutDown() throws InterruptedException {
        for (Worker worker : workerList) {
            worker.interrupt();
        }
        for (Worker worker : workerList) {
            worker.join();
        }
    }

    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        threadPoolDemo.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("eat");
            }
        });
    }


//    public static void main(String[] args) {
//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>();
//        ExecutorService pool = new ThreadPoolExecutor(10,20,5, TimeUnit.SECONDS,queue);
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("eat");
//            }
//        });
//    }
}
