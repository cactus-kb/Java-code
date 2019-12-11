public class Demo4 {
    public static class Worker extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("干活");
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
        worker.interrupt();
        worker.join();
        System.out.println("回了");
    }
}
