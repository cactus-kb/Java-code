import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(func());
        System.out.println("=============");
        System.out.println(func2());


//        Stack<Integer> stack = new Stack<>();
//        Integer ret = stack.pop();
//        System.out.println(ret);
    }

    public static int func() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }

    public static int func2() {
        try {
            return 1;
        } finally {
            System.out.println("hehe");
        }
    }
}

