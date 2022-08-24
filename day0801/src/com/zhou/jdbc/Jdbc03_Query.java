package com.zhou.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc03_Query {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("day0801/src/jdbc.properties"));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, pwd);
        System.out.println(connection);

        Statement statement = connection.createStatement();
        String sql = "select * from beauty";

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("----------------");
            System.out.println("id = " + resultSet.getInt("id"));
            System.out.println("name = " + resultSet.getString("name"));
            System.out.println("sex = " + resultSet.getString("sex"));
            System.out.println("born = " + resultSet.getDate("borndate"));
            System.out.println("phone = " + resultSet.getString("phone"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
