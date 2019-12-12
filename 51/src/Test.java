public class Test {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            while (!Thread.interrupted()) {

            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        myThread.interrupt();
        while (myThread.isAlive()) {
            System.out.println(myThread.getState());
        }
        System.out.println(myThread.getState());
    }
}
