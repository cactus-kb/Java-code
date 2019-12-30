import java.util.Scanner;

public class Main {
    private static Object object = new Object();
    private static Object otherObject = new Object();

    private static class AThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("A 正在扫地");
            }
            try {
                synchronized (otherObject) {
                    synchronized (object) {
                        object.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("A 正在擦桌子");
            }
        }
    }
    public static void main(String[] args) {
        Thread aThread = new AThread();
        aThread.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("随便输入什么，A 就会去擦桌子");
        scanner.nextLine();
        synchronized (otherObject) {
            synchronized (object) {
                object.notify();
            }
        }
    }
}
