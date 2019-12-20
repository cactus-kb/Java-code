public class PrintnOrder {
    private int i = 0;

    public synchronized void first() {
        if (i == 0) {
            System.out.println("one");
            i = 1;
        }
    }

    public synchronized void second() {
        if (i == 1) {
            System.out.println("two");
            i = 2;
        }
    }

    public synchronized void third() {
        if (i == 2) {
            System.out.println("three");
            i = 0;
        }
    }

    private static class PrintOne extends Thread {
        PrintnOrder object;
        PrintOne(PrintnOrder object) {
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
        PrintnOrder object;
        PrintTwo(PrintnOrder object) {
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
        PrintnOrder object;
        PrintThree(PrintnOrder object) {
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
        PrintnOrder object = new PrintnOrder();
        Thread t1 = new PrintOne(object);
        t1.start();
        Thread t2 = new PrintTwo(object);
        t2.start();
        Thread t3 = new PrintThree(object);
        t3.start();
    }
 }
