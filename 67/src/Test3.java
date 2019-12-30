import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        int rich = 10;
        int poor = 1;
        int t = 1;
        for (int i = 1; i < 30; i++) {
            t *= 2;
            poor += t;
        }
        System.out.println(rich * 30 + " " + poor);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        int index = 0;
        int GC = 0;
        for (int i = 0; i < str.length() - n; i++) {
            String str2 = str.substring(i, i + n);
            int C = 0;
            int G = 0;
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == 'C') {
                    C++;
                }
                if (str2.charAt(j) == 'G') {
                    G++;
                }
            }
            int num = C + G;
            if (num > GC) {
                GC = num;
                index = i;
            }
        }
        System.out.println(str.substring(index, index + n));
    }
}
