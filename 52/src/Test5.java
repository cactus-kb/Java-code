import java.util.Stack;

public class Test5 {
    public static void main(String[] args) {
        String str = "()a()()";
        boolean b = chkParenthesis(str,7);
        System.out.println(b);
    }

    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        char[] ch = A.toCharArray();
        for (int i = 0; i < n; i++) {
           if (ch[i] == '(') {
               stack.push(ch[i]);
           } else if (ch[i] == ')') {
               if (!stack.empty() && stack.peek() == '(') {
                   stack.pop();
               } else {
                   return false;
               }
           } else {
               return false;
           }
        }
        return true;
    }
}
