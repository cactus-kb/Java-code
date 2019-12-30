import java.awt.*;

public class Print {
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

    private static class ProntOne extends Thread {
        Print ob;
        ProntOne(Print ob) {
            this.ob = ob;
        }

        @Override
        public void run() {
            try{
                while (true) {
                    ob.first();
                }
            } catch (InterruptedException e) {

            }
        }
    }

    private static class ProntTwo extends Thread {
        Print ob;
        ProntTwo(Print ob) {
            this.ob = ob;
        }

        @Override
        public void run() {
            try{
                while (true) {
                    ob.second();
                }
            } catch (InterruptedException e) {

            }
        }
    }

    private static class ProntThree extends Thread {
        Print ob;
        ProntThree(Print ob) {
            this.ob = ob;
        }

        @Override
        public void run() {
            try{
                while (true) {
                    ob.third();
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        Print o = new Print();
        Thread thread = new ProntOne(o);
        thread.start();
        Thread thread2 = new ProntTwo(o);
        thread2.start();
        Thread thread3 = new ProntThree(o);
        thread3.start();
    }
}
