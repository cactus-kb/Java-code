import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(insert(a,b));
    }

    public static int insert(String a,String b) {
        int count = 0;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= a.length();i++) {
            if (i == 0) {

            } else {
                s.append(a.substring(0,i));
            }
            s.append(b);
            if (i == a.length()) {

            } else {
                s.append(a.substring(i,a.length()));
            }
            if (legal(a.toString())) {
                count++;
            }
            s = new StringBuilder();
        }
        return count;
    }

    public static boolean legal(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
