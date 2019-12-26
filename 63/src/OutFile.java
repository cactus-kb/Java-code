import java.io.*;

public class OutFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        {
            OutputStream os = new FileOutputStream("本地输出文件.txt");
            os.write(0x40);
            os.write(0x41);
            os.write(0x42);
            os.write(0x43);
            os.write(0x44);
            os.close();
        }

        {
            OutputStream os = new FileOutputStream("本地输出文件.txt");
            Writer writer = new OutputStreamWriter(os,"UTF-8");
            writer.write("c");
            writer.write("'d");
            char[] buffer = {'a', '哈','西'};
            writer.write(buffer, 0, buffer.length);
            writer.append("\r\n我啊哈哈。");

            writer.flush();
            writer.close();
        }

        {
            PrintStream out = new PrintStream("本地输出文件.txt","UTF-8");
            out.println("我是谁");
            out.println("我在哪儿");
            out.println("我在干什么");
            out.flush();
            out.close();
        }

        {
            PrintWriter writer = new PrintWriter("本地输出文件.txt","UTF-8");
            writer.printf("%s 你好 %n", "外星人");
            writer.println("我是谁");
            writer.flush();
            writer.close();
        }
    }
}
