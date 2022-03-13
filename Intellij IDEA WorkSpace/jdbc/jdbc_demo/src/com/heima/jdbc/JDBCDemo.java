package com.heima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JDBCDemo {

    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        /*防止报时区错误*/
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //3.定义sql
        String sql = "UPDATE account set money = 2000 where id = 1";

        //4.获取执行sql的对象
        Statement stmt = conn.createStatement();

        //5.执行sql对象
        int count = stmt.executeUpdate(sql);  //受影响的行数值

        //6.处理结果
        System.out.println(count);

        //7.释放资源   (先开后关)
        stmt.close();
        conn.close();
    }
}
