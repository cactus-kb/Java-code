import java.io.*;
import java.util.Scanner;

public class Test {
    private static String 从一个输入流中得到最终字符(InputStream is) throws IOException {
        byte[] buffer = new byte[8192];
        int len = 8192;
        for (int i = 0; i < buffer.length; i++) {
            int b = is.read();
            if (b == -1) {
                len = i;
                break;
            }
            buffer[i] = (byte)b;
        }
        String s = new String(buffer, 0, len, "UTF-8");
        return s;
    }

    private static InputStream 获取一个输入字节流() throws IOException {
        InputStream is;
        is = new FileInputStream("本地文件.txt");
        return is;
    }


}
