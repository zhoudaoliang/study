package com.zhou.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc02 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("day0801/src/jdbc.properties"));

        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1. 注册驱动
        Class.forName(driver);

        //2. 通过DirverManager 来获取连接
        //   解读
        //(1) url 连接哪个数据库
        Connection connection = DriverManager.getConnection(url, user, pwd);
        System.out.println(connection);

        //3. 创建 Statement , 用于发送 sql 给db
        Statement statement = connection.createStatement();

        //4. 通过 Statement执行sql
        String sql = "insert into beauty values(300, '王昭君', '女', '1590-11-11', '119')";
        //String sql = "delete  from beauty where id = 100";
        //String sql = "update beauty set name = 'tom' where id = 200";
        int resNum = statement.executeUpdate(sql);
        System.out.println(resNum>0?"ok":"fail");

        //5.关闭
        statement.close();
        connection.close();

    }
}
