import java.util.Arrays;

public class Test {
    public static void main1(String[] args) {
        int[] arr = new int[] {13,8,2,7,9,10,5,3,4,0,12,7,25};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for ( ; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }

    public static void shellSort(int[] arr) {
        for (int d = arr.length / 2; d > 0; d /= 2) {
            for (int i = d; i < arr.length; i++) {
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j] > arr[j + d]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = tmp;
                    }
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[max]) {
                    int tmp = arr[max];
                    arr[max] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(arr, i, arr.length);
        }
        int end = arr.length - 1;
        while (end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDown(arr,0,end);
            end--;
        }
    }
    public static void adjustDown(int[] arr, int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && arr[child] < arr[child + 1]) {
                child = child + 1;
            }
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
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
            quickSort(arr, start,low);
            quickSort(arr,low + 1, end);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid + 1, high);
        merge(arr, low, mid, high);
    }
    private static void merge(int[] arr, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int len = high - low + 1;
        int[] tmp = new int[len];
        int index = 0;
        while (s1 <= mid && s2 <= high) {
            if (arr[s1] >= arr[s2]) {
                tmp[index] = arr[s2];
                s2++;
                index++;
            } else {
                tmp[index] = arr[s1];
                s1++;
                index++;
            }
        }
        while (s1 <= mid) {
            tmp[index] = arr[s1];
            index++;
            s1++;
        }
        while (s2 <= high) {
            tmp[index] = arr[s2];
            index++;
            s2++;
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[low + i] = tmp[i];
        }
    }
}


























