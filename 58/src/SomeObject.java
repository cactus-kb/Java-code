
class synchronizedDemo {

}

public class SomeObject {
    public synchronized void method() {

    }

    public static synchronized void staticMethod() {

    }

    public void someMethod() {
        synchronized (this) {

        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o) {

        }

        synchronized (SomeObject.class) {

        }

        Class<?> c = synchronizedDemo.class;
        synchronizedDemo synchronizedDemo = new synchronizedDemo();
        Class<?> c2 = synchronizedDemo.getClass();
        System.out.println(c == c2);
    }
}
