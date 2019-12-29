import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private int count;

    public static void main(String[] args) {
        Main main = new Main(88);
        System.out.println(main.count);
    }
    Main(int a) {
        count = a;
    }


    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

    }


    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int score = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == score) {
                    count++;
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }



    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.add(scanner.nextInt());
            }
            int score = scanner.nextInt();
            int count = 0;
            while (!queue.isEmpty()) {
                while (queue.peek() == score) {
                    count++;
                    queue.poll();
                }
            }
            System.out.println(count);
            scanner.close();
        }
    }



    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = "";
        while (scanner.hasNext() && N != 0) {
             str = scanner.nextLine() + " ";
        }
        int score = scanner.nextInt();
        Integer[] arr = new Integer[str.length()];
        int i = 0;
        for (; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }


    public static void main1(String[] args) {
        char c = 'a';
        short s = 'b';
        float f = 1;
        double d = 1.0;
        System.out.println(c * s + f + d);
    }
}
