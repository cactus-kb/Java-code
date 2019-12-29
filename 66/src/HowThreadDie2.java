public class HowThreadDie2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println("干活");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(3000);
        System.out.println("go home");
        worker.interrupt();
        worker.join();
        System.out.println("at home");
    }
}
