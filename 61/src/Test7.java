import java.io.*;

public class Test7 {
    public static void main(String[] args) throws IOException {
        {
            OutputStream OS = new FileOutputStream("本地输出文件.txt");
            Writer writer = new OutputStreamWriter(OS, "UTF-8");
            writer.write("a");
            writer.write("中国人");
            char[] buffer = {'我', '爱', '中', '国'};
            writer.write(buffer, 0, buffer.length);
            writer.append("\r\n我爱北京天安门");
            writer.flush();
            writer.close();
        }

        {
           // OutputStream os = new FileOutputStream("本地输出文件.txt");
           // PrintStream out = new PrintStream(os,false,"UTF-8");

            PrintStream ps = new PrintStream("本地文件.txt");
            ps.println("A");
            ps.println("短时间内");
            ps.println("v");
            ps.flush();//flush刷新
            ps.close();
        }
    }
}
