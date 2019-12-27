public class HowThreadDie {
    private static class Worker extends Thread {
        private volatile boolean running = true;

        public void quit() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                System.out.println("kk");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(10000);
        System.out.println("go home");
        worker.quit();
        worker.join();
        System.out.println("at home");
    }
}
