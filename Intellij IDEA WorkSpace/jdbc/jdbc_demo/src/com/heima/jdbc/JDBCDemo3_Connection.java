package com.heima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JDBCDemo3_Connection {

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
        String sql1 = "UPDATE account set money = 3000 where id = 1";
        String sql2 = "UPDATE account set money = 3000 where id = 2";

        //4.获取执行sql的对象
        Statement stmt = conn.createStatement();






        //开始 + 提交事务
        /**
         * 异常处理快捷键  ctrl + alt + t
         */
        try {
            /*开启事务*/
            //conn.setAutoCommit(false);

            int count1 = stmt.executeUpdate(sql1);
            System.out.println(count1);

                    //制造异常
                    int i = 3/0;

            int count2 = stmt.executeUpdate(sql2);
            System.out.println(count2);


            //提交事务
            //conn.commit();
        } catch (Exception e) {
            //不管出现什么异常，回滚事务
            //conn.rollback();


            e.printStackTrace();
        }





        //7.释放资源   (先开后关)
        stmt.close();
        conn.close();
    }
}
