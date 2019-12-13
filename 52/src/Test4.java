import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] ch = str.toCharArray();
        int length = 0;
        String s = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                length = 1;
                int index = i;
                for (int j = i + 1; j < ch.length; j++) {
                    if (ch[j] >= '0' && ch[j] <= '0') {
                        length++;
                        index = j;
                    } else {
                        break;
                    }
                }
                if (length > s.length()) {
                    s = str.substring(i,index + 1);
                }
            }
        }
        System.out.println(s);
    }
}
