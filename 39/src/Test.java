import java.util.Comparator;
import java.util.Objects;

class Card {
    public int rank;
    public String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rank, suit);
    }
}
public class Test {
    public static void main1(String[] args) {
        Card p = new Card(1,"♥");
        Card q = new Card(1,"♥");
        System.out.println(p == q);
        System.out.println(p.equals(q));
        /*
        int a = 10;
        int b = 10;
        int f = 4;
        System.out.println(a == b);
        System.out.println(a == f);
        String c = "am";
        String d = "am";
        System.out.println(c == d);
        System.out.println(c.equals(d));
        */
    }

    public static void mergeSort1(int[] array,int low,int high) {
        if(low == high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSort1(array,low,mid);
        mergeSort1(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int len = high - low + 1;
        int[] tmp = new int[len];
        int index = 0;
        while (s1 <= mid && s2 <= mid) {
            if (arr[s1] < arr[s2]) {
                tmp[index++] = arr[s1++];
            } else {
                tmp[index++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[index++] = arr[s1++];
        }
        while (s2 <= high) {
            tmp[index++] = arr[s2++];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[low + i] = tmp[i];
        }
    }

    /*
    public static void merge(int[] array,int low, int mid,int high){
        int s1 = low;
        int s2 = mid+1;
        int len = high-low+1;
        int[] tmp = new int[len];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            }else {
                tmp[i++] = array[s2++];
            }
        }
        //判断两个归并段 中 是否还有归并段有数据
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = array[s2++];
        }
        //两个归并段 归并结束-》tmp[]
        for (int j = 0; j < tmp.length; j++) {
            array[low+j] = tmp[j];
        }
    }
    public static void mergeSort1(int[] array,int low,int high) {
        if(low == high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSort1(array,low,mid);
        mergeSort1(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    //非递归版本
    public static void merge1(int[] array,int gap) {
        int[] tmp = new int[array.length];
        int i = 0;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 >=
                array.length ? array.length-1 : s2+gap-1;
        //当有两个归并段的时候
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    tmp[i++] = array[s1++];
                }else {
                    tmp[i++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[i++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[i++] = array[s2++];
            }
            //重新确定s1  e1  s2  e2 的位置
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 >=
                    array.length ? array.length-1 : s2+gap-1;
        }
        //判断s1是否有数据-》上面第一个循环进不来
        while (s1 <= array.length-1) {
            tmp[i++] = array[s1++];
        }
        //拷贝tmp到array
        for (int j = 0; j < tmp.length; j++) {
            array[j] = tmp[j];
        }
    }
    public static void mergeSort(int[] array) {
        for (int gap = 1; gap < array.length; gap*=2) {
            merge1(array,gap);
        }
    }
    */
}
