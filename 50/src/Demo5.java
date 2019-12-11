public class Demo5 {
    public static class Worker extends Thread {
        @Override
        public void run() {
            while (isInterrupted()) {
                System.out.println("干活");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo4.Worker worker = new Demo4.Worker();
        worker.start();
        Thread.sleep(1000);
        System.out.println("准备回家");
        worker.join();
        System.out.println("回了");
    }
}
