public class Test {
    public static void main2(String[] args) {
        int[] arr = {1,2,3,4,5};
        try {
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
}
