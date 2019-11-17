package package1516;

public class Test2 {
    public static String sRet = "";
    public static void func(int i)
    {
        try
        {
            if (i%2==0)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            sRet += "0";
            return;
        }
        finally
        {
            sRet += "1";
        }
        sRet += "2";
    }
    public static void main(String[] args)
    {
        func(1);
        func(2);
        System.out.println(sRet);
    }


    public static void main9(String[] args) {
        System.out.println(fun());
    }

    public static int fun() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }

    public static void main8(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        try {
            System.out.println("good");
            System.out.println(arr[100]);
            System.out.println("night");
        } catch (NullPointerException e) {
            //打印出现异常的调用栈
            e.printStackTrace();
        } finally {
            System.out.println("Good Good Good");
        }
    }


    public static void main7(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        try {
            System.out.println("good");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("morning");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组下标越界异常");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }


    public static void main6(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        try {
            System.out.println("good");
            System.out.println(arr[100]);
            System.out.println("morning");
        } catch (NullPointerException e) {
            //打印出现异常的调用栈
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }


    public static void main5(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        try {
            System.out.println("good");
            System.out.println(arr[100]);
            System.out.println("morning");
        } catch (ArrayIndexOutOfBoundsException e) {
            //打印出现异常的调用栈
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }



    public static void main4(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println("good");
        System.out.println(arr[100]);
        System.out.println("morning");
    }



    public int num = 5;
    public static void main3(String[] args) {
        Test2 T = null;
        System.out.println(T.num);
    }

    public static void main2(String[] args) {
        System.out.println(10 / 0);
    }

    public static void main1(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(arr[3]);
    }
}
