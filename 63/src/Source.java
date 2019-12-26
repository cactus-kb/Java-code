import java.awt.im.InputContext;
import java.io.*;
import java.util.Scanner;

public class Source {
    public static void main2(String[] args) throws IOException {
        OutputStream out = new FileOutputStream(new File("hello.txt"));
        out.write("欢迎".getBytes("IS08859-1"));
        out.close();
    }


    public static void main1(String[] args) throws IOException {
        byte[] source = "冬天 到了，春天 也 就 不远 了".getBytes("UTF-8");
        InputStream is = new ByteArrayInputStream(source);

        Scanner scanner = new Scanner(is,"UTF-8");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
