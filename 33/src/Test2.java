public class Test2 {
    public static void main(String[] args) {

    }

    public static void main1(String[] args) {
        System.out.println(17 ^ 5);
    }


    class Super{
        int flag=1;
        Super(){
            test();
        }
    void test(){
            System.out.println("Super.test() flag="+flag);
        }
    }
    class Sub extends Super{
        Sub(int i){
            flag=i;
            System.out.println("Sub.Sub()flag="+flag);
        }
    void test(){
            System.out.println("Sub.test()flag="+flag);
        }
    }
    public static void main2(String[] args) {
        new Test2().new Sub(5);
    }
}
