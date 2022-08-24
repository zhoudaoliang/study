package com.zhou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 通过DirverManager 来获取连接
        //   解读
        //(1) url 连接哪个数据库
        Connection connection = DriverManager.getConnection("jdbc:mysql://39.108.233.234:3306/jdbcdb", "root", "123456");

        System.out.println(connection);


        //3. 创建 Statement , 用于发送 sql 给db
        Statement statement = connection.createStatement();
        //4. 通过 Statement执行sql
//        String sql = "insert into beauty values(200, '貂蝉', '女', '1390-11-11', '112')";
        //String sql = "delete  from beauty where id = 100";
        String sql = "update beauty set name = 'tom' where id = 200";
        //增加，修改，删除都是executeUpdate(sql);
        int resNum = statement.executeUpdate(sql);
        System.out.println(resNum > 0 ? "ok" : "fail");

        //5.关闭
        statement.close();
        connection.close();

    }
}
