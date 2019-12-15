public class Test5 {
    private int field;

    private Test5() {
        field = 100;
    }

    private volatile static Test5 instance = null;

    public static Test5 getinstance() {
        if (instance == null) {
            synchronized (Test5.class) {
                if (instance == null) {
                    instance = new Test5();
                }
            }
        }
        return instance;
    }


    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Test5 t = Test5.getinstance();
                System.out.println(t + ": " + t.field);
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }
    }
}
