import java.util.Arrays;
import java.util.Stack;

public class SearchSort {
    public static void main(String[] args) {
        String str = new String("hello");
        if (str == "hello") {
            System.out.println("true");
        } else {
            System.out.println("false0");
        }
    }

    /*
    public static void main1(String[] args) {
        int[] arr = new int[] {13,8,2,7,10};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }


    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
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
        createHeap(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr,0,arr.length - 1);
            shiftDown(arr,arr.length - i - 1,0);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void createHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            shiftDown(arr,arr.length,i);
        }
    }

    public static void shiftDown(int[] arr, int size, int index) {
        int left = 2 * index + 1;
        while (left < size) {
            int max = left;
            int right = 2 * index + 2;
            if (right < size) {
                if (arr[right] > arr[left]) {
                    max = right;
                }
            }
            if (arr[index] >= arr[max]) {
                break;
            }
            int t = arr[index];
            arr[index] = arr[max];
            arr[max] = t;
            index = max;
            left = 2 * index + 1;
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

    //快排递归
    private static int partion(int[] arr,int low,int high) {
        int tmp = arr[low];
        while (low < high) {
            while(low < high && arr[high] >= tmp) {
                high--;
            }
            if (low >= high) {
                arr[low] = tmp;
                break;
            } else {
                arr[low] = arr[high];
            }
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            if (low >= high) {
                arr[high] = tmp;
                break;
            } else {
                arr[high] = arr[low];
            }
        }
        arr[low] = tmp;
        return low;
    }

    private static void quick(int[] arr, int low, int high) {
        threeNumMid(arr,low,high);
        int par = partion(arr, low, high);
        if (par > low + 1) {
            quick(arr,low,par - 1);
        }
        if (par < high - 1) {
            quick(arr, par + 1, high);
        }
    }
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length - 1);
    }

    //优化：数字已经是有序的了
    public static void threeNumMid(int[] arr,int low, int high) {
        int mid = (low + high) / 2;
        if (arr[mid] > arr[low]) {
            swap(arr,mid,low);
        }
        if (arr[mid] < arr[high]) {
            swap(arr,mid,high);
        }
        if (arr[low] > arr[high]) {
            swap(arr,low,high);
        }
    }
    private static void Swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //非递归的快排
    public static void quicksort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length - 1;
        int par = partion(arr,low,high);
        if (par > low + 1) {
            stack.push(low);
            stack.push(par - 1);
        }
        if (par < high - 1) {
            stack.push(par + 1);
            stack.push(high);
        }
        while (!stack.empty()) {
            high = stack.pop();
            low= stack.pop();
            if (low >= high) {
                continue;
            }
        }
    }
    */

    public static void quick(int[] array, int low, int high) {

       /*if(high-low+1 <= 100) {
            insertSort(array,low,high);
            return;
        }

        threeNumMid(array,low,high);*/

        int par = partion(array, low, high);
        if (par > low + 1) {
            quick(array, low, par - 1);
        }
        if (par < high - 1) {
            quick(array, par + 1, high);
        }
    }

    public static void quickSort1(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length - 1;
        int par = partion(array, low, high);
        if (par > low + 1) {
            stack.push(low);
            stack.push(par - 1);
        }
        if (par < high - 1) {
            stack.push(par + 1);
            stack.push(high);
        }
        while (!stack.empty()) {
            //1、取出数对
            high = stack.pop();
            low = stack.pop();
            //2.par
            par = partion(array, low, high);
            if (par > low + 1) {
                stack.push(low);
                stack.push(par - 1);
            }
            if (par < high - 1) {
                stack.push(par + 1);
                stack.push(high);
            }
        }
    }
    public static int partion(int[] array,
                              int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            if(low >= high) {
                break;
            }else {
                array[low] = array[high];
            }

            while (low < high && array[low] <= tmp) {
                low++;
            }
            if(low >= high) {
                break;
            }else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }


    public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void threeNumMid(int[] array,int low,int high) {
        //array[low]     array[high]    array[mid]    2   7   5
        //array[mid] <= array[low] <= array[high]
        int mid = (low+high)/2;
        if(array[mid] > array[low]) {
            swap(array,low,mid);//  7   2     5
        }
        if(array[mid] > array[high]) {
            swap(array,high,mid);//  5   2    7
        }
        if(array[low] > array[high]) {
            swap(array,low,high);// 5   2    7
        }
    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for ( ; j >= 0; j--) {
                if (arr[j] < tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }


    /*
    public static void Quick(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
    }
    */
}






















