package com.zhou;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client02 {
    public static void main(String[] args) throws Exception {
        //客户端，连接服务器的 10000端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //得到输出流， 字节流
        //outputStream 运行类型 是 SocketOutputStream
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,服务端".getBytes());

        //1. 这里我们的客户端需要标识这次消息发送介绍, shutdownOut
        socket.shutdownOutput();

        //接收服务器端回复 的消息
        //1. 获取 socket的输入流, 运行类型是SocketInputStream
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len=inputStream.read(buffer))!=-1){
            System.out.println("客户端：收到服务端信息 :" + new String(buffer,0,len));
        }

        //关闭连接
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
