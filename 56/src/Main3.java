import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        //创建的未初始化的二维数组，则其值默认为0；
        //将不能放蛋糕的地方置为1，最后剩几个0就意味着可以放几块蛋糕
        int[][] arr = new int[w][h];
        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (arr[i][j] == 0) {
                    count++;
                    //每一行不能放蛋糕的地方
                    if ((i + 2) < w) {
                        arr[i + 2][j] = 1;
                    }
                    //每一列不能放蛋糕的位置
                    if ((j + 2) < h) {
                        arr[i][j + 2] = 1;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
