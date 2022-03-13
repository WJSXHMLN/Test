package com.heima.jdbc;

import com.heima.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo6_UserLogin {

    @Test
    public void testLogin() throws Exception {

        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //1.接受用户名+密码
        String name = "zhangsan";
        String pwd = "123";

        String sql = " select * from tb_user where username = '"+name+"' and password = '"+pwd+"' ";

        //2.获取statement对象
        Statement stmt = conn.createStatement();

        //3.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //4.判断是否登录成功
        if(rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        //5.释放资源
        rs.close();
        stmt.close();
        conn.close();

    }

    /**
     * 演示sql注入
     * @throws Exception
     */
    @Test
    public void testLogin_Inject() throws Exception {

        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //1.接受用户名+密码
        String name = "zhangsan";
        String pwd = "'or '1' = '1";

        String sql = " select * from tb_user where username = '"+name+"' and password = '"+pwd+"' ";
        //核心是拼接字符串
        System.out.println(sql);

        //2.获取statement对象
        Statement stmt = conn.createStatement();

        //3.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //4.判断是否登录成功
        if(rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        //5.释放资源
        rs.close();
        stmt.close();
        conn.close();

    }


}
