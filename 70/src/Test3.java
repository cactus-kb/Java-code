import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[] {5,3,7,1,8,9};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int start,int end) {
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
            quickSort(arr,start,low);
            quickSort(arr,low + 1,end);
        }
    }
}
