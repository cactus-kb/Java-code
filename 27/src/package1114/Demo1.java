package package1114;

import java.util.Stack;

public class Demo1 {
    public static void main(String[] args) {
        String s = "[]()";
        boolean b = isValid(s);
        System.out.println(b);
    }
    //括号匹配问题
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            //是不是左括号
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                //栈为空
                if (stack.empty()) {
                    return false;
                } else {
                    //i号位置是右括号了
                   char ch = stack.peek();
                   if (ch == '(' && str.charAt(i) == ')'
                           || ch == '[' && str.charAt(i) == ']'
                           || ch == '{' && str.charAt(i) == '}') {
                       stack.pop();
                   } else {
                       return false;
                   }
                }
            }
        }
        if (!stack.empty()) {
            //左括号多了
            return false;
        }
        return true;
    }


    //用队列实现栈



}
