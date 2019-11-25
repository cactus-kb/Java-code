package com.util;

class test {
    public int a ;
}
public class Demo2 {
    public static void main(String[] args) {
        int[] intData = new int[] {1,65,55,23,100};
        char[] charData = new char[] {'z','a','c','b'};
        java.util.Arrays.sort(intData);
        java.util.Arrays.sort(charData);
        System.out.println(intData);
        System.out.println(charData);
    }

    public static void main5(String[] args) {
        int[] x = null;
        x = new int[3];
        System.out.println(x.length);
        x[0] = 10;
        x[1] = 20;
        x[2] = 30;
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public static void main4(String[] args) {
        int[] arr = new int[2];
        System.out.println(arr[0]);
    }

    public static void main3(String[] args) {
        char c= 'A';
        int num = c;
        System.out.println(num);
    }

    public static void main2(String[] args) {
        test t = new test();
        System.out.println(t.a);
    }

    public static void main1(String[] args) {
        int a = 10;
        int b = 10;
        int c = a * b;
        System.out.println(c);
    }
}
