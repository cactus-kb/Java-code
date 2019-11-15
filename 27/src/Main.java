import java.util.*;

public class Main {
    public static void main1(String[] args) {
        String str = "({})";
        boolean b = kouhao(str);
        System.out.println(b);
    }

    public static boolean kouhao(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch =='{') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    if (stack.peek() == '(' && str.charAt(i) == ')'
                        || stack.peek() == '[' && str.charAt(i) == ']'
                         || stack.peek() == '{' && str.charAt(i) == '}') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
