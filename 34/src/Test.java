public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        Integer c = 128;
        Integer d = 128;
        Integer e = 127;
        Integer f = 127;
        int i = 127;
        System.out.println(a == b);//true
        System.out.println("=========");
        System.out.println(c == d);//false
        System.out.println("=========");
        System.out.println(e == f);//true
        System.out.println("========");
        System.out.println(f == i);//true

    }


    public static void main1(String[] args) {
        int i = 10;
        Integer integer = new Integer(10);
        System.out.println(i == integer);
    }
}
