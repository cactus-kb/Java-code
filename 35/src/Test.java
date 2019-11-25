public class Test {
    public static void main4(String[] args) {
        int a = 10;
        Integer b = 10;
        Integer c = new Integer(10);
        System.out.println(a == b);//true
        System.out.println(a == c);//true
    }

    public static void main3(String[] args) {
        Integer a = 10;
        Integer b = new Integer(10);
        System.out.println(a == b);//false
    }

    public static void main2(String[] args) {
        Integer a = 10;
        Integer b = 10;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);//true
        System.out.println(c == d);//false
    }

    public static void main1(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println(a == b);
    }
}
