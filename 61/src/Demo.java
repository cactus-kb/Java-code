import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split("");
        Integer[] arr = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] arr1 = new int[10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i] == j) {
                    arr1[j]++;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (arr1[i] != 0) {
                System.out.println(i + ":" + arr1[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr= new int[] {0,1,2,3};
        int[] t = multiply(arr);
        System.out.println(Arrays.toString(t));
    }

    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int result = 1;
        int tmp = 0;
        //i => B数组；j => A数组
        for (int i = 0; i < B.length; i++) {
            int j = 0;
           for (; j < A.length; j++) {
               //当i和j相等时，将A数组里面下标为j的值置为1，一数乘以任何数都等于任何数
               if (i == j) {
                    tmp = A[j];
                   A[j] = 1;
               }
               result *= A[j];
           }
           //把A数组里面改为1的值改回去
            if (j == A.length) {
                j = i;
                A[j] = tmp;
            }
           B[i] = result;
           result = 1;
        }
        return B;
    }
}
