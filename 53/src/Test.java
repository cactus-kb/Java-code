
//        *当一个类中有两个同步方法test1,test2.
//        * 他们两个锁同一个对象的话,线程1进入了test1,线程2绝对进入不了test2

class Sync{
    public synchronized void test1(){
        while (true){
            System.out.println("haha");

        }
    }
    public synchronized void test2(){
        if(Thread.currentThread().getName().equals("B")){
            System.out.println("线程B进入了test2()");
        }
    }
}
class MyThread implements Runnable{
    private Sync sync;
    public MyThread(Sync sync) {
        this.sync = sync;
    }
    @Override
    public void run() {
        sync.test1();
        sync.test2();
    }
}
public class Test {
    public static void main(String[] args) {
        Sync sync = new Sync();
        MyThread mt = new MyThread(sync);
        Thread thread1 = new Thread(mt,"A");
        Thread thread2 = new Thread(mt,"B");
        sync.test1();
        sync.test2();
        thread1.start();
        thread2.start();
    }
}




