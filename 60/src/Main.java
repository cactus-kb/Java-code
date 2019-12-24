import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int p = 1;
        while (true) {
            System.out.printf("process: %d%%\r",p);
            p++;
            Thread.sleep(1);
        }
    }

    public static void main1(String[] args) {
        int[] arr = new int[] {1, 2};
        int[] a = exchangeAB(arr);
        System.out.println(Arrays.toString(a));
    }

    public static int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }

}
