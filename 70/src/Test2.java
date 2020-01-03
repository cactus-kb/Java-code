import java.util.Scanner;

public class Test2 {
    public static void main4(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            char[] sw=new char[130];
            String str1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String str2="VWXYZABCDEFGHIJKLMNOPQRSTU";
            for(int i=0;i<str1.length();i++){
                sw[str1.charAt(i)]=str2.charAt(i);
            }
            String str=sc.nextLine();
            String result="";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)==' '){
                    result+=" ";
                }else{
                    result+=sw[str.charAt(i)];
                }
            }
            System.out.println(result);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] c = new char[Character.MAX_VALUE];
            String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String encode = "VWXYZABCDEFGHIJKLMNOPQRSTU";
            for (int i = 0; i < code.length(); i++) {
                c[code.charAt(i)] = encode.charAt(i);
            }
            String result = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    result += ' ';
                } else {
                    result += c[str.charAt(i)];
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == 'A') {
                    System.out.print('V');
                }
                if (c == 'B') {
                    System.out.print('W');
                }
                if (c == ' ') ;
                System.out.print(' ');
            }
        }
    }



    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();
            System.out.println(getTotalCount(month));
        }
        scanner.close();
    }
    public static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }
}
