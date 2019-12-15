import java.util.Random;

public class Test2 {
    private static int index = 0;
    public static class MyThread extends Thread {
        int[] arr;

        MyThread(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            while (index < arr.length) {
                synchronized (MyThread.class) {
                    if (index < arr.length) {
                        arr[index] = arr[index] * 3;
                        index++;
                    }
                }
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(20191215);

        int[] arr = new int[10_0000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        MyThread myThread1 = new MyThread(arr);
        MyThread myThread2 = new MyThread(arr);
        MyThread myThread3 = new MyThread(arr);
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


