import java.util.ArrayList;
import java.util.List;

public class Test {
    //杨辉三角形
    //1.第一行是固定的，就只有一个1
    //2.第二行也是固定的，只有两个1
    //3.任意一行，开头和结尾也都是1
    //4.第i行，有i列
    //5.第i行的第j列，这个数字是根据i - 1,j - 1列和j列相加
        public List<List<Integer>> generate(int numRows) {
            if (numRows <= 0) {
                return new ArrayList<>();

            }
            List<List<Integer>> result = new ArrayList<>();
            //先把第一行插入进去
            List<Integer> firstLine = new ArrayList<>();
            firstLine.add(1);
            result.add(firstLine);
            if (numRows == 1) {
                return result;
            }
            //再把第二行插入进去
            List<Integer> secondLine = new ArrayList<>();
            secondLine.add(1);
            secondLine.add(1);
            result.add(secondLine);
            if (numRows == 2) {
                return result;
            }
            //后续i行的情况
            for (int row = 3; row < numRows; row++) {
                //为了知道当前行的内容，需要先知道上一行
                //row本来是从1开始计数的
                //row - 1是把从1开始计数的数字转成下标
                //row - 1 -1 取到上一行的下标
                List<Integer> prevLine = result.get(row - 1 - 1);
                //创建一个表示当前行的List
                List<Integer> curLine = new ArrayList<>();
                //把当前行中填充一些元素
                //当前行的第0列一定是1
                curLine.add(1);
                //后续的列都是根据prevLine来获取到的
                for (int col = 1; col < row - 1; col++) {
                    curLine.add(prevLine.get(col - 1) + prevLine.get(col));
                }
                //加上最后一个1
                curLine.add(1);
                result.add(curLine);
            }
            return result;
        }
}
