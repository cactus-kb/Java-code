import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3 ;
        while(f2 < n){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        if (Math.abs(f2 - n) > Math.abs(f1 - n)) {
            System.out.println(Math.abs(f1 - n));
        } else {
            System.out.println(Math.abs(f2 - n));
        }
    }

    public int countWays(int x, int y) {
        if(x==1||y==1) return 1;
        return countWays(x-1,y)+countWays(x,y-1);
    }


    /*
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    */
}
