import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        int i = 0;
        while (scanner.hasNext()) {
            arr[i] = scanner.nextInt();
            i++;
            if (i == 10) {
                break;
            }
        }
        //打出从1号下标开始值不为0的数一次
        for (i = 1; i < 10; i++) {
            if (arr[i] != 0) {
                System.out.print(i);
                arr[i]--;
                break;
            }
        }
        //然后遍历所有的数，按顺序打出值
        for (i = 0; i < 10; i++) {
            if (arr[i] != 0) {
                while (arr[i] != 0) {
                    System.out.print(i);
                    arr[i]--;
                }
            }
        }
    }


    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != 0) {
                s.append(i);
                list.set(i, list.get(i) - 1);
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                while (list.get(i) != 0) {
                    s.append(i);
                    list.set(i, list.get(i) - 1);
                }
            }
        }
        System.out.println(s.toString());
    }



    public static void main3(String []args){
        Scanner in=new Scanner(System.in);
        int num[]=new int[10];
        for(int i=0;i<10;i++){
            num[i]=in.nextInt();
        }
        for(int i=1;i<10;i++){
            if(num[i]!=0){
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        while(num[0]!=0){
            System.out.print(0);
            num[0]--;
        }
        for(int i=1;i<10;i++){
            while(num[i]!=0){
                System.out.print(i);
                num[i]--;
            }
        }

    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[10];
        int i = 0;
        while (scanner.hasNext()) {
            arr[i] = scanner.nextInt();
            i++;
            if (i == arr.length) {
                break;
            }
        }
        for ( ; i < arr.length; i++) {
            while (arr[i] != 0) {
                list.add(i);
                arr[i]--;
            }
        }
    }





    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[10];
        int i = 0;
        while (scanner.hasNext()) {
            arr[i++] = scanner.nextInt();
            if (i == arr.length) {
                break;
            }
        }
        for ( ; i < arr.length; i++) {
            if (arr[i] != 0) {
                queue.offer(i);
                arr[i]--;
            }
        }
        System.out.println(queue);
    }
}
