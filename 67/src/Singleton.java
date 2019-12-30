public class Singleton {
    private int field = 0;
    private Singleton() {
        field = 100;
    }
    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            Singleton s = Singleton.getInstance();
            System.out.println(s + ":" + s.field);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }
    }
}
