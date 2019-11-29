import java.util.Arrays;

public class Dmeo {
    public static void main(String[] args) {
        int[] arr = new int[] {13,8,2,7,10,9,11,15,12,6,23};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

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


    public static void heapSort(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
        //每次调整的结束位置
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }
    public static void  adjustDown(int[]elem , int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            //判断是否有右孩子 且谁最大
            if(child+1 < len && elem[child] <
                    elem[child+1]) {
                child = child+1;
            }
            //child肯定是左右孩子的最大值下标
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }


    public static void bubbleSort(int[] arr) {
        //比较轮数
        for (int i = 0; i < arr.length - 1; i++) {
            //比较的次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
    public static void selectSort(int[] arr) {
        //遍历所有的数
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            /*
            * 把当前遍历的数与后面的数依次比较，并记录下最小数的下标
            * 若最小数的下标和当前遍历的数的下标不一致，则进行交换
            * */
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[max]) {
                    int tmp = arr[max];
                    arr[max] = arr[j];
                    arr[j] = tmp;
                }
            }

        }
    }

    public static void insertSort(int[] arr) {
        //遍历所有的数字，从1开始，因为第一个数字已经是有序的
        for (int i = 1; i < arr.length; i++) {
            //记录下当前的数字
            int tmp = arr[i];
            /*
            * 定义j从后往前遍历有序区间的数字,
            * 若当前数字大于记录下来的数字，则把j号下标位置的数字放到i号下标位置（即j + 1号下标位置）,否则结束此次比较
            * 循环结束之后，再将所记录下来的tmp的数字放到j + 1号下标位置（循环结束之后，j--了，所以需要放的是j + 1下标位置）
            * */
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
        //遍历所有步长
        for (int d = arr.length / 2; d > 0; d /= 2) {
            //遍历所有的元素
            for (int i = d; i < arr.length; i++) {
                //遍历每一组里面的所有元素
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j] >arr[j + d]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = tmp;
                    }
                }
            }
        }
    }
}
