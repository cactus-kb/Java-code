public class HowThreadDie3 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while(!isInterrupted()) {
                System.out.println("干活");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(4000);
        System.out.println("go home");
        worker.isInterrupted();
        worker.join();
        System.out.println("at home");

    }
}
