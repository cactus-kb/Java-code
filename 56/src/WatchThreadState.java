public class WatchThreadState {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        while (thread.isAlive()) {
            System.out.println(thread.getState());
        }
    }
}
