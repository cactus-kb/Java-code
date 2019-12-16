
import java.util.Scanner;

public class Demo {

    public static Object object = new Object();
    public static class AThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("A正在扫地");
            }
            try {
                synchronized (object) {
                    object.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("A在擦桌子");
            }
        }
    }


    public static void main(String[] args) {
        Thread athread = new AThread();
        athread.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入");
        scanner.nextInt();
        synchronized (object) {
            object.notify();
        }
    }


}











