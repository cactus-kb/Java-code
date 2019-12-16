import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[] {scanner.nextInt()};
        int r =  MoreThanHalfNum_Solution(arr);
        System.out.println(r);

//        String str = scanner.nextLine();
//        int len = str.length() / 2;
//        int[] arr = new int[100];
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = 0; j < 100; j++) {
//                if ((str.charAt(i)+ "").equals(j)) {
//                    arr[j]++;
//                }
//            }
//        }
//        for (int k = 0; k < arr.length; k++) {
//            if (arr[k] > len) {
//                System.out.println(arr[k]);
//            }
//        }
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        int[] arr = new int[9];
        for(int j = 0;j<array.length;j++){
            for(int i = 0;i<=9;i++){
                if(array[j] == i){
                    arr[i]++;
                }
            }
        }
        int len = array.length/2;
        int result = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > len){
                result = i;
                break;
            }
        }
        return result;
    }

}
