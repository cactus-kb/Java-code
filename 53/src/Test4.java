import java.util.Random;

public class Test4 {
    private static int index = 0;
    public static class MyThread extends Thread {
        int[] arr;
        int start;
        int end;

        MyThread(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                arr[i] = arr[i] * 3;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(20191215);

        int[] arr = new int[10_0000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        MyThread myThread1 = new MyThread(arr,0,30000);
        MyThread myThread2 = new MyThread(arr,30000,60000);
        MyThread myThread3 = new MyThread(arr,60000,100000);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread1.join();
        myThread2.join();
        myThread3.join();
        System.out.println(arr[0]);
        System.out.println(arr[3]);
        System.out.println(arr[107]);
        System.out.println(arr[323]);
        System.out.println(arr[666]);
    }
}
