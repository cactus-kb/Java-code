public class Base {
        public void methodOne( ){
            System .out. println("A");
            methodTwo( );
        }
        void methodTwo() {
            System.out.println("B");
        }
}
class Derived extends Base {
    public void methodOne() {
        super.methodOne();
        System.out.println("C");
    }

    public void methodTwo() {
        super.methodTwo();
        System.out.println("D");
    }

    public static void main(String[] args) {
        Base b = new Derived();
        b.methodOne();
    }
}
