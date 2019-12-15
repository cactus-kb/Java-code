import java.util.Random;

public class Test3 {
    private static int index = 0;

    public static class MyThread extends Thread {
        int[] arr;

        public MyThread(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            while (index < arr.length) {
                        arr[index] = arr[index] * 3;
                        index++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(20191216);
        int[] array = new int[10_0000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        MyThread t1 = new MyThread(array);
        MyThread t2 = new MyThread(array);
        MyThread t3 = new MyThread(array);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(array[0]);
        System.out.println(array[3]);
        System.out.println(array[107]);
        System.out.println(array[323]);
        System.out.println(array[666]);
    }
}
