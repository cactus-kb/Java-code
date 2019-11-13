import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main1(String[] args) {
        Integer a = 10;
        Integer c = 10;
        System.out.println(a == c);//true


        Map<String, String> map = new HashMap<>();
        map.put("哈哈","haha");
        map.put("呵呵","hehe");
        map.put("哦哦","oo");
        map.put("嗯嗯","enen");
        String str = map.get("haha");
        System.out.println(str);
        boolean b = map.containsKey("oo");
        System.out.println(b);
        boolean b1 = map.containsValue("oo");
        System.out.println(b1);
        map.getOrDefault("mm","yaya");
        String s = map.get("mm");
        System.out.println(s);



//        Collection<String> collection = new ArrayList<>();
//        collection.add("a");
//        collection.add("b");
//        collection.add("c");
//        collection.add("d");
//        collection.add("e");
//        System.out.println(collection);
//        System.out.println(collection.isEmpty());
//        System.out.println(collection.size());
//        collection.remove("e");
//        System.out.println(collection);
//        System.out.println(collection.size());
//        System.out.println("==========");
//        Object ob = collection.toArray();
//        for (Object o: collection
//             ) {
//            System.out.print(o);
//        }
//        System.out.println();
//        collection.clear();
//        System.out.println(collection.size());
    }
}
