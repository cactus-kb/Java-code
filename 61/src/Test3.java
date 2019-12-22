import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test3 {


    public static void main(String[] args) {
        int result = 1;
        for (int i = 1; i <= 5; i++) {
            result *= i;
        }
        System.out.println(result);
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer len = scanner.nextInt();
        System.out.println();
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        Integer[] arr = new Integer[len ];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(arr);
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        Integer len = scanner.nextInt();
        System.out.println();
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        Integer[] arr = new Integer[s.length ];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            set.add(arr[i]);
        }

    }
}
