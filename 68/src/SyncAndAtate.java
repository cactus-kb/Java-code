public class SyncAndAtate {
    public static void method() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class MyThread extends Thread {
        private SyncAndAtate object;

        MyThread(SyncAndAtate object,String name) {
            super(name);
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                object.method();
            }
        }
    }
}
