import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        Character bb = 0;
        Integer a = 10;
        Integer b = 10;
        System.out.println(a == b);//true
        Integer a1 = -10;
        Integer b1 = -10;
        System.out.println(a1 == b1);//true
        Integer a2 = 128;
        Integer b2 = 128;
        System.out.println(a2 == b2);//false
        Integer a3 = -129;
        Integer b3 = -129;
        System.out.println(a3 == b3);//false


        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
//        System.out.println(myStack.pop());
//        System.out.println(myStack.size());
//        System.out.println(myStack.peek());
//        Stack stack = new Stack();

//        String s = "hello";
//        System.out.println(s);
//        char c = 'f';
//        System.out.println(c);
//
//        int i = 10;
//        Integer ii = i; // 自动装箱
//        Integer ij = (Integer)i; // 自动装箱
//        int j = ii; // 自动拆箱
//        int k = (int)ii;//自动拆箱
//
//
//
//
//        List l = generate(4);
//        System.out.println(l);
    }

    public static List<Character> search(String str1,String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str1.contains(ch + "")) {
                list.add(ch);
            }
        }
        return list;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        List<Integer> list = new ArrayList<>();
        triangle.add(list);
        triangle.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRows = new ArrayList<>();
            curRows.add(1);
            List<Integer> prevRow = triangle.get(i - 1);
            for (int j = 1; j < i; j++) {
                int num = prevRow.get(j - 1) + prevRow.get(j);
                curRows.add(num);
            }
            curRows.add(1);
            triangle.add(curRows);
        }
        return triangle;
    }
}
