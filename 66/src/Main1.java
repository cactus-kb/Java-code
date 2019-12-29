public class Main1 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("我是启动起来的线程");
        }
    }

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        main1.start();
        while (true) {
            System.out.println("我是主线程");
        }
    }
}
