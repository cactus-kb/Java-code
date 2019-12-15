import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        Queue<Character> queue = new LinkedList<>();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (!((ch1[i] + " ").equals(ch2[j] + " "))) {
                    queue.add(ch1[i]);
                }
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
    }
}
