public class PrintOrder {
    private volatile int i = 0;

    public void first() {
        if (i == 0) {
            synchronized (PrintOrder.class) {
                if (i == 0) {
                    System.out.println("one");
                    i = 1;
                }
            }
        }
    }

    public void second() {
        if (i == 1) {
            synchronized (PrintOrder.class) {
                if (i == 1) {
                    System.out.println("two");
                    i = 2;
                }
            }
        }
    }

    public void third() {
        if (i == 2) {
            synchronized (PrintOrder.class) {
                if (i == 2) {
                    System.out.println("three");
                    i = 0;
                }
            }
        }
    }

    private static class PrintOne extends Thread {
        PrintOrder object;
        PrintOne(PrintOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                object.first();
            }
        }
    }

    private static class PrintTwo extends Thread {
        PrintOrder object;
        PrintTwo(PrintOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                object.second();
            }
        }
    }

    private static class PrintThree extends Thread {
        PrintOrder object;
        PrintThree(PrintOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                object.third();
            }
        }
    }

    public static void main(String[] args) {
        PrintOrder object = new PrintOrder();
        Thread t1 = new PrintOne(object);
        t1.start();
        Thread t2 = new PrintTwo(object);
        t2.start();
        Thread t3 = new PrintThree(object);
        t3.start();
    }
}
