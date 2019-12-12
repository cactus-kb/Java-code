public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6,7,0};
        int ret = count(arr, 8);
        System.out.println(ret);
    }

    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i;j--) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
