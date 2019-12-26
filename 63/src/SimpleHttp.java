import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHttp {
    //GET HTTP://www.baidu.com
    public static void main(String[] args) throws IOException {
        StringBuilder request = new StringBuilder();
        request.append("GET / HTTP/1.0\r\n");
        request.append("Host: www.baidu.com\r\n");
        request.append("\r\n");

        Socket socket = new Socket("www.baidu.com",80);
        socket.getOutputStream().write(request.toString().getBytes("UTF-8"));
        socket.getOutputStream().flush();
        socket.shutdownOutput();

        byte[] buffer = new byte[4096];
        int len = socket.getInputStream().read(buffer);
      //  socket.close();
//        String response = new String(buffer, 0, len, "UTF-8");
//        System.out.println(response);
        int index = -1;
        for (int i = 0; i < len - 3; i++) {
            if (buffer[i] == '\r' && buffer[i + 1] == '\n' && buffer[i + 2] == '\r' && buffer[i + 3] == '\n') {
            index = i;
            break;
            }
        }
        int 已经读到的正文的长度 = len - index - 4;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer, 0, index + 4);
        Scanner scanner = new Scanner(byteArrayInputStream, "UTF-8");

        String statusLine = scanner.nextLine();
        System.out.println("状态行: " + statusLine);
        String line;
        int contentLength = -1;
        while (!(line = scanner.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            System.out.println("响应头: " + key + " = " + value);
            if (key.equalsIgnoreCase("Content-Length")) {
                contentLength = Integer.parseInt(value);
            }
        }

        int 还需要读的正文的长度 = contentLength - 已经读到的正文的长度;

        byte[] body = new byte[contentLength];
        System.arraycopy(
                buffer,
                index + 4,
                body,
                0,
                已经读到的正文的长度
        );

        int 实际又读到的长度 = socket.getInputStream().read(
                body, 已经读到的正文的长度, 还需要读的正文的长度
        );
        System.out.println(contentLength);
        System.out.println(已经读到的正文的长度);
        System.out.println(还需要读的正文的长度);
        System.out.println(实际又读到的长度);

        FileOutputStream os = new FileOutputStream("百度.html");
        os.write(body);
        os.close();
    }
}
