public class ThreadWithName {
    public static void main(String[] args) {
        //获取当前线程的Thread 对象
        //Thread.currentThread()
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getState());
        System.out.println(thread.isAlive());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isDaemon());
        System.out.println(thread.getPriority());
    }



    /*
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        Thread thread1 = new Thread(new MyRunnable(),"aa");
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable(),"aa");
        thread2.start();
    }
    */
}
