import java.util.*;

public class Demo {
    public static void main1(String[] args) {
        Stack<String> st = new Stack<>();
        st.push("ll");
        st.push("kk");
        String s = st.pop();
        System.out.println(s);
        String f = st.peek();
        System.out.println(f);
        System.out.println(st.empty());



        Queue<String> queue = new LinkedList<>();
        String s4 = "hhhh";

        char[] c = {'a','b','c'};
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        System.out.println(c);
        System.out.println(Arrays.toString(c));

//        List<String> list = new ArrayList<>();
//        String str = "good";
//        System.out.println(str);
//        for (int i = 0; i < str.length();i++) {
//            char ch = str.charAt(i);
//            System.out.println(ch);
//        }
//        char[] c = str.toCharArray();
//        System.out.println(c);
    }
}
