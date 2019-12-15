
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!(str2.contains(str1.charAt(i) + ""))) {
                list.add(str1.charAt(i));
            }
        }
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
        }
    }
}

