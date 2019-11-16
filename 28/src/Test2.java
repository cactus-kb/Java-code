import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main2(String[] args) {
        String str1 = "welcome to China";
        String str2 = "come";
        List<Character> list1 = deleteSameChar(str1,str2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i));
        }
    }

    public static List<Character> deleteSameChar(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) {
                list.add(ch);
            }
        }
        return list;
    }
}
