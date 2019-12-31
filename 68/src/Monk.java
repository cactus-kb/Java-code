import java.util.Random;

public class Monk {
    private static int index = 0;
    private static class Monk1 extends Thread {
        int[] array;
        int start;
        int end;

        Monk1(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                array[i] = array[i] * 3;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(20191231);
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        Monk1 m1 = new Monk1(array, 0, 3_0000);
        Monk1 m2 = new Monk1(array, 3_0000, 6_0000);
        Monk1 m3 = new Monk1(array, 6_0000, array.length);
        m1.start();
        m2.start();
        m3.start();
        m1.join();
        m2.join();
        m3.join();
        System.out.println(array[0]);
        System.out.println(array[3]);
        System.out.println(array[107]);
        System.out.println(array[323]);
        System.out.println(array[6666]);
        System.out.println(array[88888]);
        System.out.println(array[93192]);
    }
}
