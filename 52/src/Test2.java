import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int maxlength = 0;//最大长度
        String result = "";//保存结果
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                maxlength = 1;
                int index = i;
                for (int j = i + 1; j < ch.length; j++) {
                    if (ch[j] >= '0' && ch[j] <= '9') {
                        maxlength++;
                        index  = j;
                    } else {
                        break;
                    }
                    if (maxlength > result.length()) {
                        result = str.substring(i,index+1);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
