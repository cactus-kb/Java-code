public class Singleton {

    private Singleton() {}

    //饿汉模式
    private static Singleton instace = new Singleton();
    public static Singleton getInstace() {
        return instace;
    }

    //懒汉模式
    private static volatile Singleton instances = null;
    public static Singleton getInstances() {
        if (instances == null) {
            synchronized (Singleton.class) {
                if (instances == null) {
                    instances = new Singleton();
                }
            }
        }
        return instances;
    }
}

//为什么构造方法private
//为什么要二次判断
//syn加到方法上的缺点
//为什么要加volatile