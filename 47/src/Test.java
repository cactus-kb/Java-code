
class OuterClass {
    public int data1 = 10;
    public static int data2 = 20;

    class InnerClass {
        public int data3 = 100;
        public static final int data4 =200;
        public int data1 = 10000;
        public InnerClass() {

        }
        public void func() {
            System.out.println("InnerClass::func()");
            System.out.println("data1: " + this.data1);
            System.out.println("data2: " + data2);
            System.out.println("data3: " + data3);
            System.out.println("data4: " + data4);
            System.out.println("Outerdata1 :" + OuterClass.this.data1);
        }
    }
}

class OuterClass2 {
    public int data1 = 10;
    public static int data2 = 20;

    static class InnerClass2{
        public int data3 = 200;
        public static int data4 = 100;
        public int data1 = 300;
        OuterClass2 o = null;

        public InnerClass2() {

        }

        public InnerClass2(OuterClass2 out) {
            this.o = out;
        }
        public void func() {
            System.out.println("InnerClass2::func()");
            System.out.println("data3: "+data3);
            System.out.println("data4: "+data4);
            System.out.println("data1: "+ data1);
            System.out.println("data2: "+ data2);
            System.out.println("outdata1: "+ o.data1);
        }
    }
}

class mYthread {
    public void func() {
        System.out.println("out::MyThread::func()");
    }
}


public class Test {


    public static void main2(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass2);
        innerClass2.func();
    }


    public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.func();
    }
}
