public class DeadLock {
    private static Object aLock = new Object();
    private static Object bLock = new Object();

    private static class AThread extends Thread {
        @Override
        public void run() {
            synchronized (aLock) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    synchronized (bLock) {
                        System.out.println("A: eat");
                    }
                }
            }
        }
    }

    private static class BThread extends Thread {
        @Override
        public void run() {
            synchronized (bLock) {
                synchronized (aLock) {
                    System.out.println("B : eat");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AThread aThread = new AThread();
        BThread bThread = new BThread();
        aThread.start();
        Thread.sleep(2000);
        bThread.start();
    }
}
