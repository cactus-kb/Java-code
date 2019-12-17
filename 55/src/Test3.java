import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
            String[] s = str.split(" ");
            Integer[] integer = new Integer[4];
            for (int i = 0; i < 4; i++) {
                integer[i] = Integer.parseInt(s[i]);
            }
            int A, B, C;
            int n1, n2, n3, n4;
            for (int i = 0; i < 4; i++) {
                n1 = integer[0];
                n2 = integer[1];
                n3 = integer[2];
                n4 = integer[3];

                A = (n1 + n3) / 2;
                B = (n2 + n4) / 2;
                C = n4 - B;


                if (A - B == n1 && B - C == n2 && A + B == n3 && B + C == n4) {
                    System.out.println(A + " " + B + " " + C);
                    break;
                } else {
                    System.out.println("no");
                }
            }
    }
}
