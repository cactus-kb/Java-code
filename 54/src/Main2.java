import java.util.Scanner;

public class Main2 {
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          int n = scanner.nextInt();
          int[] a = new int[n + 1];
          for (int i = 1; i <= n; i++) {
              a[i] = scanner.nextInt();
          }
          System.out.println(count(a, n, 40));
      }
      static int count(int[] arr, int i, int s) {
          if (s == 0) {
              return 1;
          } else if (i == 1) {
              if (arr[i] == s) {
                  return 1;
              } else {
                  return 0;
              }
          } else if (arr[i] > s) {
              return count(arr, i - 1, s);
          } else{
              return count(arr, i - 1, s - arr[i]) + count(arr, i - 1, s);
          }
      }
}

