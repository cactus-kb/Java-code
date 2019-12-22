import java.io.*;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) throws IOException{

        {
            InputStream is = new FileInputStream("本地文件.text");
            Reader reader = new InputStreamReader(is, "UTF-8");
            StringBuilder sb1 = new StringBuilder();
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                sb1.append(buffer, 0, len);
            }
            System.out.println(sb1.toString());
            reader.close();
        }

        {
            InputStream isa = new FileInputStream("本地文件.text");
            Reader reader1 = new InputStreamReader(isa, "UTF-8");
            StringBuilder sb2 = new StringBuilder();
            int c;
            while ((c = reader1.read()) != -1) {
                char cb = (char) c;
                sb2.append(cb);
            }
            System.out.println(sb2.toString());
            reader1.close();
        }

        {
            InputStream is = new FileInputStream("本地文件.text");
            Reader reader = new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            System.out.println(sb.toString());
            bufferedReader.close();
        }

        {
            InputStream is = new FileInputStream("本地文件.text");
            Scanner scanner = new Scanner(is,"UTF-8");

            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                String next = scanner.next();
                sb.append(next);
            }
            System.out.println(sb.toString());
        }

        //scanner二
        {
            InputStream is = new FileInputStream("本地文件.text");
            Reader reader = new InputStreamReader(is, "UTF-8");
            Scanner scanner = new Scanner(reader);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                String next = scanner.next();
                sb.append(next);
            }
            System.out.println(sb.toString());
        }


        {
            byte[] source = "中国 人民 富起来 了".getBytes("UTF-8");
            InputStream is = new ByteArrayInputStream(source);
            Scanner scanner = new Scanner(is, "UTF-8");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
            scanner.close();
        }
    }

}















