package com.zhou;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
    public static void main(String[] args) throws Exception {
        //服务端在 9999端口监听，等待客户端连接.
        ServerSocket serverSocket = new ServerSocket(9999);

        //监听，如果没有客户端连接，服务器阻塞
        System.out.println("9999监听，等待连接");

        Socket socket = serverSocket.accept();

        //获取该socket的输入流
        InputStream inputStream = socket.getInputStream();//运行类型 SocketInputStream

        byte[] buffer = new byte[1024];
        int len = 0;

        while ((len=inputStream.read(buffer))!=-1){
            System.out.println("服务端：收到客户端信息" + new String(buffer,0,len));
        }

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
