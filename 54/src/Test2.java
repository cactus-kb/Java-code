public class Test2 {
    public static void main1(String[] args) {
        int x;
        int y;
        x = 5 >> 2;
        y = x >>> 2;
        System.out.println(y);
    }


    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        System.out.println(a + " , " + b);
    }
    public static void operate(StringBuffer a,StringBuffer b) {
        a.append(b);
        b = a;
    }
}
