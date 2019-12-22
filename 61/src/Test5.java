import java.io.*;
import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) throws IOException{
        InputStream  inputStream = getInputStream();
    //    String message = OutputStream();
    }

    public static InputStream getInputStream() throws IOException {
        InputStream is;
        is = new FileInputStream("本地文件.txt");
        return is;
    }

    public static String getOutputStream(InputStream is) throws IOException {
//        byte[] buffer = new byte[8192];
//        int len = 8192;
//        for (int i = 0; i < buffer.length; i++) {
//            int b = is.read();
//            if (b == -1) {
//                len = i;
//                break;
//            }
//            buffer[i] = (byte)b;
//        }
//        String s = new String(buffer,0,len,"UTF-8");
//        return s;

        //用一个字节流得到字符流
//        Reader reader = new InputStreamReader(is, "UTF-8");
//        char[] buffer = new char[1024];
//        int len = reader.read(buffer);
//        System.out.println(Arrays.toString(buffer));
//
//        return new String(buffer, 0, len);


        Reader reader = new InputStreamReader(is,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        return bufferedReader.readLine();

    }

}
