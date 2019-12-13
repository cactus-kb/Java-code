import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list = new ArrayList<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                list.add(ch[i] + " ");
                if ((i + 1 < ch.length) && (ch[i + 1] == ch[i] + '1')){
                    list.add(ch[i] + " ");
                }
            }
        }
        System.out.println(list);
    }
}


