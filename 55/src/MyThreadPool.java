import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private  class Worker extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
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
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public void execute(Runnable command) {
        if (currentPoolSize < corePoolSize) {
            Worker worker = new Worker();
            workerList.add(worker);
            worker.start();
            currentPoolSize++;
        }
        queue.add(command);
    }

    public void shutDown() throws InterruptedException {
        for(Worker worker: workerList) {
            worker.interrupt();
        }
        for(Worker worker: workerList) {
            worker.join();
        }
    }
}
