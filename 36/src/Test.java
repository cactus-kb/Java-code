import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main1(String[] args) {
        int[] array = new int[] {13,8,2,7,10,9,11,15,12,6};
        Heap heap = new Heap();
        heap.creatHeap(array);
        System.out.println(Arrays.toString(array));
    }

public static void main(String[] args) {
        int[] arr = new int[] {13,8,2,7,10,5,3,1,0,9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("===============");
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("==============");
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0;j--) {
                //�����������ȶ����������ѽ�����������Ϊarr[j] >= tmp;��ͻ��ɲ��ȶ�������
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
            int max = arr[i];
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    i = j;
                }
            }
        }
    }
}
