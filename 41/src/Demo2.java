class outClass {
    public int data = 10;
    public int data2 = 20;

    class innerClass {
        public int data3 = 30;
        public int data4 = 40;

        public void func() {
            System.out.println("this is a method");
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        outClass outClass1 = new outClass();
        outClass.innerClass innerClass = outClass1.new innerClass();
        innerClass.func();


    }
}
