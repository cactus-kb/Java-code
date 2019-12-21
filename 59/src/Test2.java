
class Tesk implements Runnable {
    public  synchronized void testA() {
        System.out.println("A");
        while (true) {

        }
    }

    public synchronized void testB() {
        System.out.println("B");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("A")){
            testA();
        } else {
            testB();
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        Test test = new Test();
        Thread thread = new Thread("A");
        Thread thread2 = new Thread("B");
        thread.start();
        thread2.start();
    }
}
