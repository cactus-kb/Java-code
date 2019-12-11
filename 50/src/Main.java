import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
    }
}
