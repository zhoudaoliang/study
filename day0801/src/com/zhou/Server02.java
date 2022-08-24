package com.zhou;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server02 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在 10000端口监听，等待连接");
        Socket socket = serverSocket.accept();

        //运行类型 SocketInputStream
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer))!=-1){
            System.out.println("服务端：收到客户端信息 :" + new String(buffer,0,len));
        }

        //准备 回复一个消息  hello,客户端!

        //获取该socket的输出流
        //运行类型 SocketOnputStream

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello，客户端".getBytes());
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
