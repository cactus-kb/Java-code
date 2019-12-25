public class Test {
    private int i = 0;
    public synchronized void first() throws InterruptedException {
        if (i == 0) {
            System.out.println("one");
            i = 1;
            notifyAll();
        }
        wait();
    }

    public synchronized void second() throws InterruptedException {
        if (i == 1) {
            System.out.println("two");
            i = 2;
            notifyAll();
        }
        wait();
    }

    public synchronized void third() throws InterruptedException {
        if (i == 2) {
            System.out.println("three");
            i = 0;
            notifyAll();
        }
        wait();
    }

    private static class PrintPOne extends Thread {
        Test object;
        PrintPOne(Test object) {
            this.object = object;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    object.first();
                }
            } catch (InterruptedException e) {

            }
        }
    }

    private static class PrintPTwo extends Thread {
        Test object;
        PrintPTwo(Test object) {
            this.object = object;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    object.second();
                }
            } catch (InterruptedException e) {

            }
        }
    }


    private static class PrintPThird extends Thread {
        Test object;
        PrintPThird(Test object) {
            this.object = object;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    object.third();
                }
            } catch (InterruptedException e) {

            }
        }
    }
    public static void main(String[] args) {
        Test object = new Test();
        Thread t1 = new PrintPOne(object);
        t1.start();
        Thread t2 = new PrintPTwo(object);
        t2.start();
        Thread t3 = new PrintPThird(object);
        t3.start();
    }
}
