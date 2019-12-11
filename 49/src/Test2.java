import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c;
        while (b <= N) {
            c = a + b;
            a = b;
            b = c;
        }
        int ret = N - b;
        int ret1 = a + b - N;
        if (ret > ret1) {
            System.out.println(ret1);
        } else {
            System.out.println(ret);
        }
    }

    public void quickSort(int[] arr, int start, int end ) {
        if (start < end) {
            int stard = arr[start];
            int low = start;
            int high = end;
            while (low < end) {
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            quickSort(arr,start,low);
            quickSort(arr,low + 1,end);
        }
    }
}
