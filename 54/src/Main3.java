import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        int len = arr.length / 2;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i - 1; j++) {
                if (arr[i] == arr[j]) {
                    count += count;
                }
            }
            if (len <= count) {
                list.add(arr[i]);
            }
        }
        System.out.println(list);
    }
}
