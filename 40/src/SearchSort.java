import java.util.Arrays;

public class SearchSort {
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
                //插入排序是稳定的排序，若把将以下条件改为arr[j] >= tmp;则就会变成不稳定的排序。
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
