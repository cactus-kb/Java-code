import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        int index = 0;
        int GC = 0;
        for (int i = 0; i < str.length() - n; i++) {
            String str2 = str.substring(i, i + n);
            int C = 0;
            int G = 0;
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == 'C') {
                    C++;
                }
                if (str2.charAt(j) == 'G') {
                    G++;
                }
            }
            int sum = G + C;
            if (sum > GC) {
                GC = sum;
                index = i;
            }
        }
        System.out.println(str.substring(index, index + n));
    }



    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        Queue<Character> queue = new LinkedList<>();
        int num = 0;
        int count = 0;
        while (num != n) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'C' || str.charAt(i) == 'G') {
                    count++;
                }
                queue.add(str.charAt(i));
            }
            if (count == n) {
                System.out.println(queue);
                break;
            }

        }
    }



    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        while (!str.isEmpty()) {
            for (int i = 0; i < n; i++) {
                arr[i] = str.charAt(i);
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'G' || arr[i] == 'C') {
                    count++;
                }
                if (count == n) {
                    System.out.println(arr);
                    break;
                }
            }
        }
    }
}
