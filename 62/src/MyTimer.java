import java.util.concurrent.TimeUnit;

public class MyTimer {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("5秒到了");
            }
        });
        thread.start();
        while (true) {
            System.out.println("主线程在干活");
        }
    }
}
