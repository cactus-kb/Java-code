import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {


    }


    //有效的括号
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           if (ch == '(' || ch == '[' || ch == '{') {
               stack.push(ch);
           } else {
               if (stack.empty()) {
                   return false;
               } else {
                   if (stack.peek() == '(' && s.charAt(i) == ')' ||
                           stack.peek() == '[' && s.charAt(i) == ']' ||
                           stack.peek() == '{' && s.charAt(i) == '}') {
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
    //反转字符串
    public static void reverseString(char[] s) {
       for (int i = 0, j = s.length - 1; i < j; i++, j--) {
           char ch = s[i];
           s[i] = s[j];
           s[j] = ch;
       }
    }

    public static void main1(String[] args) {
        String s = String.valueOf('a');
        System.out.println(s);
        String str = String.valueOf(new char[] {'a','b','c'});
        System.out.println(str);
    }
}
