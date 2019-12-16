import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(count(arr,n,40));
    }

    public static int count(int[] arr, int n, int v) {
        if (v == 0) {
            return 1;
        } else if (n == 1) {
            if (arr[n] == v ) {
                return 1;
            } else {
                return 0;
            }
        } else if (arr[n] > v) {
            return count(arr, n - 1, v);
        } else {
            return count(arr, n - 1, v - arr[n]) + count(arr, n - 1, v);
        }
    }
}
