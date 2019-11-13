import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main2(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hehe");
        list.add(1,"haha");
        System.out.println(list);
        System.out.println("================");
        List<String> list2 = new ArrayList<>();
        list2.add("kk");
        list2.add("jj");
        System.out.println(list2);
        list.addAll(list2);
        System.out.println(list);
        System.out.println("============");
        String str =  list.remove(1);
        System.out.println(str);
        System.out.println(list);
        System.out.println("===========");
        list.remove("hehe");
        System.out.println(list);
        list.set(0,"oo");
        System.out.println(list);
        boolean b = list.contains("oo");
        System.out.println(b);
        System.out.println("==========");
        int index = list.indexOf("00");
        System.out.println(index);
        int in = list.indexOf("oo");
        System.out.println(in);
        System.out.println(list);
        System.out.println("==========");
        list.add("ll");
        list.add("pp");
        int index1 = list.lastIndexOf("pp");
        System.out.println(list);
        System.out.println(index1);

    }
}
