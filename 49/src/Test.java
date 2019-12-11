import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
        }
        int len = set.size();
        System.out.println(len);
    }
}
