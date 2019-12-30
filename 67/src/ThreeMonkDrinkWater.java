import java.util.Random;

public class ThreeMonkDrinkWater {
    private static int index = 0;

    private static class monk extends Thread {
        int[] array;

        monk(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            while (index < array.length) {
                synchronized (monk.class) {
                    if (index < array.length) {
                        array[index] = array[index] * 3;
                        index++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(20191230);
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        monk m1 = new monk(array);
        monk m2 = new monk(array);
        monk m3 = new monk(array);
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
    }
}
