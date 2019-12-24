package packsge;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args)  throws IOException{
        DatagramSocket socket = new DatagramSocket(8888);
        while (true) {
            byte[] buffer = new byte[4094];
            DatagramPacket receivePacket = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(receivePacket);

            //获取实际收到的数据长度
            int len = receivePacket.getLength();
            //把字节转化字符
            String message = new String(buffer, 0, len, "UTF-8");

            String enchMessage = message;
            byte[] sendBuffer = enchMessage.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,0,sendBuffer.length,
                    receivePacket.getAddress(),receivePacket.getPort());
            socket.send(sendPacket);
        }
    }
}
