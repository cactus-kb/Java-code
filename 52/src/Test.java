import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
//        String str2 = scanner.nextLine();
//        for (int i = 0; i < str1.length(); i++) {
//            String s = str1.charAt(i) + " ";
//
//        }
        boolean b = isHuiwen(str1);
        System.out.println(b);
    }

    public static boolean isHuiwen(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i != j && i < str.length() && j > 0) {
            String c = str.charAt(i) + " ";
            String c2 = str.charAt(j) + " ";
            if (c.equals(c2)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

