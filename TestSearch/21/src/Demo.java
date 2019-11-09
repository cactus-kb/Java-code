import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        StringBuffer st = new StringBuffer();//StringBuffer是线程安全的，适合多线程
        StringBuilder stt = new StringBuilder();//线程不安全的。单线程


        //将字符串逆置
        String s = "abcdefg";
        String ret = reverse(s);
        System.out.println(ret);
        String ret1 = rev(s);
        System.out.println(ret1);


//        String s = "zcd##%哈哈f";
//        String se = s.toUpperCase();
//        System.out.println(se);
//
//
//        String q = "helloworld";
//        boolean oo = q.contains("h");
//        System.out.println(oo);



//        byte[] b = {97,98,99};
//        System.out.println(Arrays.toString(b));
//        String str = new String(b);
//        System.out.println(str);


        //将字符数组与字符串的转化
//        String str2 = "123456a";
//        char[] value = str2.toCharArray();
//        System.out.println(value);
//
//        char[] value1 = {'a','b','c'};
//        String str = new String(value1);
//        System.out.println(str);
//        String str1 = "abcds";
//        char ch1 = str1.charAt(1);//charAt(m)取到m号下标的元素
//        System.out.println(ch);
    }

    public static String reverse(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = ch.length - 1; j >= 0; j--) {
                if (i != j) {
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                }
            }
        }
        return String.copyValueOf(ch);
    }

    public static String rev(String str) {
        char[] ch = str.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
        return String.copyValueOf(ch);
    }

}
//