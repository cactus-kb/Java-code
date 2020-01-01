import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int order = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                int score = scanner.nextInt();
                list.add(score);
                map.put(name + " " + score, score);
            }
            Collections.sort(list);
            if (order == 0) {
                Collections.reverse(list);
                int pre = -1;
                for (int i : list) {
                    if (pre == i) {
                        continue;
                    }
                    for (String key : map.keySet()) {
                        if (map.get(key).equals(i)) {
                            System.out.println(key);
                        }
                        pre = i;
                    }
                }
            }
        }
    }
}
