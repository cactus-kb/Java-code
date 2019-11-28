import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {8,2,4,7,5,3,0,1,6,16,11,18};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
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

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int tmp = arr[i];
                int j;
                for (j = i - 1;j >= 0 && arr[j] > tmp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = tmp;
            }
        }
    }

    public static void insertsort(int[] arr) {
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

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j =  i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void shellSort(int[] arr) {
        for (int d = arr.length / 2; d > 0; d /= 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i - d; j >= 0; j--) {
                    if (arr[j] > arr[j + d]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = tmp;
                    }
                }
            }
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(arr,i,arr.length);
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

//    public static void  adjustDown(int[]elem , int root,int len) {
//        int parent = root;
//        int child = 2*parent+1;
//        while (child < len) {
//            //判断是否有右孩子 且谁最大
//            if(child+1 < len && elem[child] <
//                    elem[child+1]) {
//                child = child+1;
//            }
//            //child肯定是左右孩子的最大值下标
//            if(elem[child] > elem[parent]) {
//                int tmp = elem[child];
//                elem[child] = elem[parent];
//                elem[parent] = tmp;
//                parent = child;
//                child = 2*parent+1;
//            }else {
//                break;
//            }
//        }
//    }
//
//    public static void heapSort(int[] array) {
//        for (int i = (array.length-1-1)/2; i >= 0; i--) {
//            adjustDown(array,i,array.length);
//        }
//        //每次调整的结束位置  9
//        int end = array.length-1;
//        while (end > 0) {
//            int tmp = array[0];
//            array[0] = array[end];
//            array[end] = tmp;
//            adjustDown(array,0,end);
//            end--;
//        }
//    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
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
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }


    //归并排序：先分开为一个一个数据，再将其合并（归并）
    public static void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        //合并
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

        //归并结束
        for (int i = 0; i < tmp.length; i++) {
            arr[low + i] = tmp[i];
        }
    }

    //非递归的归并排序
    public static void mergesort(int[] arr) {
        for (int gap = 1; gap < arr.length; gap *= 2) {
            merge1(arr,gap);
        }
    }
    private static void merge1(int[] arr, int gap) {
        int[] tmp = new int[arr.length];
        int i = 0;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 >= arr.length ? arr.length - 1 : s2 + gap - 1;
        while (s2 < arr.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (arr[s1] <= arr[s2]) {
                    tmp[i++] = arr[s1++];
                } else {
                    tmp[i++] = arr[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[i++] = arr[s1++];
            }
            while (s2 <= e2) {
                tmp[i++] = arr[s2++];
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 > arr.length ? arr.length - 1 : s2 + gap - 1;
        }
        //判断s1是否有数据
        while (s1 <= arr.length - 1) {
            tmp[i++] = arr[s1++];
        }
        //拷贝tmp到array
        for (int j = 0; j < arr.length; j++) {
            arr[j] = tmp[j];
        }
    }
}
