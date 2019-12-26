import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        int i = 0;
        while (scanner.hasNext()) {
            arr[i] = scanner.nextInt();
            i++;
            if (i == 10) {
                break;
            }
        }
        //打出从1号下标开始值不为0的数一次
        for (i = 1 ; i < 10; i++) {
            if (arr[i] != 0) {
                System.out.print(i);
                arr[i]--;
                break;
            }
        }
        //若有0，则将0值全部打出
        while (arr[0] != 0) {
            System.out.print(0);
            arr[0]--;
        }
        //打出之后所有的值
        for (i = 1; i < 10; i++) {
            while (arr[i] != 0) {
                System.out.print(i);
                arr[i]--;
            }
        }
    }
}
