package com.heima.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API  详解：Statement
 */
public class JDBCDemo4_Statement {
    /**
     * 执行DML语句     对数据操作  UPDATE account set money = 3000 where id = 1
     * @throws Exception
     */

    //@Test是注解
    @Test
    public void testDML() throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        /*
         * 如果连接本机mysql+端口号3306 ，简化为jdbc:mysql:///
         * */


        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";

        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //3.定义sql
        String sql = "UPDATE account set money = 3000 where id = 1";

        //4.获取执行sql的对象
        Statement stmt = conn.createStatement();

        //5.执行sql对象
        int count = stmt.executeUpdate(sql);  //执行DML语句后，受影响的行数值

        //6.处理结果
        //System.out.println(count);
        if (count > 0){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }

        //7.释放资源   (先开后关)
        stmt.close();
        conn.close();
    }


    /**
     * 执行DDL语句     对表和库进行操作   create database db2
     * @throws Exception
     */

    //@Test是注解
    @Test
    public void testDDL() throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        /*
         * 如果连接本机mysql+端口号3306 ，简化为jdbc:mysql:///
         * */


        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";

        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //3.定义sql
        String sql = "drop database db2";

        //4.获取执行sql的对象
        Statement stmt = conn.createStatement();

        //5.执行sql对象
        int count = stmt.executeUpdate(sql);  //执行DDL语句后，返回的可能是0,比如删除表

        //6.处理结果
        //System.out.println(count);
        /*if (count > 0){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }*/
        System.out.println(count);

        //7.释放资源   (先开后关)
        stmt.close();
        conn.close();
    }


}
