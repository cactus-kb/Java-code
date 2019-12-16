import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[] {scanner.nextInt()};
        int result = Find(arr);
        System.out.println(result);
    }

    public static int Find(int[] arr) {
        int[] a = new int[100];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i] == j) {
                    a[j]++;
                }
            }
        }
        int len = arr.length / 2;
        int ret = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > len) {
                ret = i;
            }
        }
        return ret;
    }
}


