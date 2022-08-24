package com.zhou;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client01 {
    public static void main(String[] args) throws Exception {
        //客户端，连接服务器的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //得到输出流，字节流
        //outputStream 运行类型是SocketOutputStream
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("hello,server".getBytes());

        outputStream.close();
        socket.close();
    }
}
