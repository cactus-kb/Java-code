package pckage1;

public class HowThreadDie2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println("挖煤");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(20000);
        System.out.println("准备回家");
        worker.interrupt();
        worker.join();
        System.out.println("回去了");
    }
}
