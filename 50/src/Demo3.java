public class Demo3 {
    private static class Worker extends Thread {

        private volatile boolean running = true;

        public void quit() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
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
        Thread.sleep(1000);
        System.out.println("准备回家");
        worker.quit();
        worker.join();
        System.out.println("回去了");
    }
}
