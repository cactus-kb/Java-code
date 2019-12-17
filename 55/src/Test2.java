import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //将字符串变为字符数组，并将空格去掉
        String[] s = str.split(" ");
        Integer[] arr = new Integer[s.length];
        //将字符数组转为integer形的数组
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int len = arr.length / 2;
        //定义一个容量为100的数组，然后遍历arr数组，将arr里面的数值与a的下标对应，如果相同，就将a里面的值++；
        //最后遍历a数组，找到满足条件的值，将其打印出来。
        int[] a = new int[100];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (arr[i] == j) {
                    a[j]++;
                }
            }
        }
        int ret = 0;
        for (int j = 0; j < a.length; j++) {
            if (len <= a[j]) {
                ret = j;
            }
        }
        System.out.println(ret);
    }
}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] arr = new int[] {scanner.nextInt()};
//        int result = Find(arr);
//        System.out.println(result);
//    }
//
//    public static int Find(int[] arr) {
//        int[] a = new int[100];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < 100; j++) {
//                if (arr[i] == j) {
//                    a[j]++;
//                }
//            }
//        }
//        int len = arr.length / 2;
//        int ret = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] > len) {
//                ret = i;
//            }
//        }
//        return ret;
//    }
//}


