package packagr1;

public class Test {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "a";
        String str3 = "bc";
        String str4 = str2 + str3;
        System.out.println(str1 == str4);//false
        System.out.println(str1.equals(str4));//true



//        String str1 = "abc";
//        String str2 = "a" + new String("bc");
//        System.out.println(str1 == str2);//false
//        System.out.println(str1.equals(str2));//true


//        String str1 = "a" + "bc";
//        String str2 = "abc";
//        System.out.println(str1 == str2);//true
//        System.out.println(str1.equals(str2));//true

//        String str1 = new String("abc");
//        String str2 = new String("abc");
//        System.out.println(str1 == str2);//false
//        System.out.println(str1.equals(str2));//true

//        String str1 = "abc";
//        String str2 = new String("abc");
//        System.out.println(str1 == str2);//false
//        System.out.println(str1.equals(str2));//true


//        String str = "hello world";
//        System.out.println(str);
//        String str1 = new String("hello world");
//        System.out.println(str1);
//        char[] arr = {'h','i'};
//        String str2 = new String(arr);
//        System.out.println(str2);
    }
}
