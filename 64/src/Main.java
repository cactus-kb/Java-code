import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            String ret = GetSequeOddNum(m);
            System.out.println(ret);
        }
        scanner.close();
    }
    public static String GetSequeOddNum(int m) {
        int[] arr = new int[m];
        arr[0] = m * (m - 1) + 1;
        for (int i = 1; i < m; i++) {
            arr[i] = arr[i - 1] + 2;
        }
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < m - 1; j++) {
            s.append(arr[j] + "+");
        }
        s.append(arr[m - 1]);
        return s.toString();
    }
}
