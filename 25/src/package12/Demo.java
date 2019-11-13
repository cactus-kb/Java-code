package package12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main2(String[] args) {
        String str = "welcome to bit";
        String str1 = "come";
        List<String> list = new ArrayList<>();
        list.add(str);
        List<String> list2 = new ArrayList<>();
        //list.add(str1);
        list.remove("welcome to bit");
        System.out.println(list);
    }

    //删除第一个字符串中在第二个字符串出现的所有字符
    public static void main1(String[] args) {
        String str1 = "welecome to bit";
        String str2 = "come";
        for (int i = 0; i < str2.length(); i++) {
            int index = 0;
            while ((index = str1.indexOf(str2.charAt(i)))!=-1){
                //找不到返回-1,找到了返回下标
                str1 = str1.substring(0,index)+str1.substring(index+1);
            }
        }
        System.out.println(str1);
    }
    //同上,使用集合
    public static void main3(String[] args) {
        String str1 = "welecome to bit";
        String str2 = "come";
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i <str1.length(); i++) {
            list1.add(str1.charAt(i)+"");
        }
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i <str2.length(); i++) {
            list2.add(str2.charAt(i)+"");
        }
        for (int i = 0; i < list1.size(); i++) {
            if(list2.contains(list1.get(i))){
                list1.remove(list1.get(i));
                i--;
            }
        }
        StringBuilder b = new StringBuilder();
        for(String s: list1){
            b.append(s);
        }
        System.out.println(b);
    }

    public static void main4(String[] args) {
        String str = "welcome to China";
        String str2 = "come";
        for (int i = 0; i < str2.length(); i++) {
            int index = 0;
            while ((index = str.indexOf(str2.charAt(i))) != -1) {
                str = str.substring(0,index) + str.substring(index + 1);
            }
        }
        System.out.println(str);
    }

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

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("gg");
//        List<String> list2 = new LinkedList<>();
//        list2.add("kk");
        String str1 = "welcome to China";
        String str2 = "come";
        List<Character> l =  searchNotRepeateChar(str1,str2);
        System.out.println(l);
    }

    public static List<Character> searchNotRepeateChar(String str1, String str2) {
        List<Character> list = new ArrayList();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains((ch + " "))) {
                list.add(ch);
            }
        }
        return list;
    }

    public static List<List<Integer>> yanghui (int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        List<Integer> list1 = new ArrayList<>();
        triangle.add(list1);
        triangle.get(0).add(1);
        //i行j列
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

