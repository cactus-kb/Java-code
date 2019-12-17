public class Scene {
    private static final int COUNT = 100_0000;

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        long a = 0;
        for (int i = 0; i < COUNT; i++) {
            a += i;
        }

        long b = 0;
        for (int i = 0; i < COUNT; i++) {
            b += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
