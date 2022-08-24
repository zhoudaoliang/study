package com.zhou;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();

        System.out.println(inetAddress);

        System.out.println(inetAddress.getHostName());

        System.out.println(inetAddress.getHostAddress());


        InetAddress inetAddress1 = InetAddress.getByName("DESKTOP-SMFDGPA");
        System.out.println("ip:" + inetAddress1.getHostAddress());

        byte[] address = new byte[4];
        address[0] = (byte) 192;



        address[1] = (byte) 168;
        address[2] = (byte) 48;
        address[3] = (byte) 1;

        InetAddress inetAddress2 = InetAddress.getByAddress(address);
        System.out.println("host:" + inetAddress2.getHostName());

        InetAddress inetAddress3 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress3.getHostAddress());
    }
}
