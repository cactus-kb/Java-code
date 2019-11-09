public class Test {
    public static void main1(String[] args) {
        String str1 = "kk";
        String str3 = new String("kk");

        /*
         *intern():手动入池
         */
        String str = "hello";
        System.out.println(Integer.toHexString(str.hashCode()));//打印当前地址
        str = str + "world";
        System.out.println(Integer.toHexString(str.hashCode()));
        str += "!";
        System.out.println(Integer.toHexString(str.hashCode()));
        System.out.println(str);

        String str2 = "hello";
        str2 = str2.substring(1);


    }
}
