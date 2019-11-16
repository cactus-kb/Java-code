import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main1(String[] args) {
        List<List<Integer>> list = Ytriangle(4);
        System.out.println(list);
    }

    public static List<List<Integer>> Ytriangle (int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        triangle.add(cur);
        triangle.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRows = new ArrayList<>();
            curRows.add(1);
            List<Integer> prevRows = triangle.get(i - 1);
            for (int j = 1; j < i; j++) {
                int num = prevRows.get(j) + prevRows.get(j - 1);
                curRows.add(num);
            }
            curRows.add(1);
            triangle.add(curRows);
        }
        return triangle;
    }
}
