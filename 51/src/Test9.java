
class TTest {
    public static void hello() {
        System.out.println("hello");
    }
}

class Base {
    Base() {
        System.out.println("Base");
    }
}

public class Test9 extends Base {
    public static void main(String[] args) {
        new Test9();
        new Base();
    }

    public static void main1(String[] args) {
        TTest tTest = null;
        tTest.hello();
        TTest r = new TTest();
        r.hello();
    }
}


