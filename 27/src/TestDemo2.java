import java.util.Scanner;

public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!stringBuffer.toString().contains(ch + "")) {
                    stringBuffer.append(ch);
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }

    public static void main5(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello").append("world");
        //fun(stringBuffer);
        System.out.println(stringBuffer);
        String s = "haha";
        String sd = s + " , hehe";
        System.out.println(sd);
    }

    public static void fun(StringBuffer tmp) {
        tmp.append("\n").append("www.bit.com.cn");
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!builder.toString().contains(ch + "")) {
                    builder.append(ch);
                }
            }
            System.out.println(builder.toString());
        }
    }
}
