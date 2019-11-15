import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main3(String[] args) {
        List<List<Integer>> list = YTriangle(3);
        System.out.println(list);
    }

    public static List<List<Integer>> YTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
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
