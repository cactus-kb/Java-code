package pckage1;

public class AnonymousAndLambda {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("kk");
            }
        };
        t.start();
        Thread t2 = new Thread(() -> {});
        t2.start();
    }
}
