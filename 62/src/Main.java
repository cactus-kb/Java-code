import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(Add(str1,str2));
        }
    }
    private static String Add(String addend, String augend) {
        BigInteger b1 = new BigInteger(addend);
        BigInteger b2 = new BigInteger(augend);
        BigInteger res = b1.add(b2);
        return res + " ";
    }



    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char c = scanner.next().charAt(0);
        char[][] arr = new char[N / 2 + N % 2][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = c;
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = ' ';
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N =scanner.nextInt();
        int[][] arr = new int[N / 2][N];
        int i = 0;
        int j = 0;
        while (scanner.hasNext()) {
            arr[i++][j++] = Integer.parseInt(scanner.next());
            if(i == N / 2 && j == N) {
                break;
            }
        }
        System.out.println(arr);
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.print(" ");
        String str = scanner.nextLine();
        int[][] arr = new int[N / 2][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(str);
            }
        }
        System.out.println(arr);
    }
}
