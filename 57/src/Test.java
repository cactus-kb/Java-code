import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        Integer[] arr = new Integer[s.length];
        for (int i = 0; i < s.length - 1; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int k = Integer.parseInt(s[s.length - 1]);
        quickSort(arr, 0, arr.length - 2);
        for(int i = 0; i < k ; i++){
            System.out.print(i == k-1 ? arr[i] : arr[i] + " ");
        }

    }

    public static void quickSort(Integer[] arr, int start, int end) {
        if (start < end) {
            int stard = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
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
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    /*
    public static void main(String[] args) {
        int[] arr = new int[] {3,6,2,4,8,0,7,9,5,1,4};
        quckSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        Integer[] arr = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
    }

    private static void quckSort(int[] arr) {
      quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            return;
        }
        int index = partition(arr, left,right);
        quickSortHelper(arr, left, index - 1);
        quickSortHelper(arr, index, right);
    }

    private static int partition(int[] arr,int left, int right) {
        int baseIndex = right;
        int baseValue = arr[baseIndex];
        while (left < right) {
            while (left < right && arr[left] <= baseValue) {
                left++;
            }
            while (left < right && arr[right] >= baseValue) {
                right--;
            }
            swap(arr,left,right);
        }
        swap(arr,left,baseIndex);
        return left;
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    */
}
