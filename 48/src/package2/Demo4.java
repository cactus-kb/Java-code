package package2;

public class Demo4 {
    public static void main(String[] args) {
        //使用匿名类创建Thread子类对象
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("**使用匿名类创建 Thread子类对象");
            }
        };
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名类创建Runnable子类对象");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(
                () -> System.out.println("使用匿名类创建 Thread子类对象")
        );
        thread2.start();
    }
}
