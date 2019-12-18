import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size() != 1) {
            int count = 0;
            while (count != 2) {
                queue.add(queue.peek());
                queue.poll();
                count++;
            }
            queue.poll();
        }
        System.out.println(queue.element());
    }




    public static void main1(String[] args) {
        double x = 3.0;
        int y = 5;
        x /= --y;
        System.out.println(x);
    }
}
