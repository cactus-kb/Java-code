import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(scanner.next(), scanner.nextInt());
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                    return o1.getValue().compareTo(o2.getValue());
                    //                if (o2.getValue() > o1.getValue()) {
//                    return -1;
//                } else if (o2.getValue().equals(o1.getValue())) {
//                    return 1;
//                }
//                return 1;
                    int flag = o1.getValue().compareTo(o2.getValue());
                    if(flag==0) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return flag;
                }
            });
            for (Map.Entry<String, Integer> map1 : list) {
                System.out.println(map1.getKey() + " " + map1.getValue());
            }
    }

    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (s.contains(p[i])) {
                b[i] = true;
            } else {
                b[i] = false;
            }
        }
        return b;
    }
}
