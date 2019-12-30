public class DeadLock {
    private static Object alock = new Object();
    private static Object block = new Object();

    private static class AThread extends Thread {
        @Override
        public void run() {
            synchronized (alock) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    synchronized (block) {
                        System.out.println("A: eat something");
                    }
                }
            }
        }
    }

    private static class BThread extends Thread {
        @Override
        public void run() {
            synchronized (block) {
                synchronized (alock) {
                    System.out.println("B：eat");
                }
            }
        }
    }

    public static void main(String[] args) {
        AThread aThread = new AThread();
        BThread bThread = new BThread();
        aThread.start();
        bThread.start();
    }
}
