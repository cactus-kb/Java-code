package Tcppackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        String messages = "cat\r\ndog\r\nfish\r\n";
        Socket socket = new Socket("127.0.0.1",8888);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Scanner scanner1 = new Scanner(System.in);
        byte[] sendBuffer = messages.getBytes("UTF-8");
        os.write(sendBuffer);
        Scanner scanner = new Scanner(is,"UTF-8");
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        socket.close();
    }
}
