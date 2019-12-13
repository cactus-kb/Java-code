public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(3000);
        System.out.println(System.currentTimeMillis());

//        Thread thread = new Thread();
//        System.out.println(thread.getName());
    }
}
