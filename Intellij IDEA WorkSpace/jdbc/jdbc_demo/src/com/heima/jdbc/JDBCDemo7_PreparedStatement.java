package com.heima.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * api 详解 preparedStatement
 */
public class JDBCDemo7_PreparedStatement {

    /**
     * preparedStatement
     *      1.获取PreparedStatement对象
     *      2.设置PreparedStatement对象值  setXx()
     *      3.执行sql
     * @throws Exception
     */
    @Test
    public void testPreparedStatement() throws Exception {

        /* useServerPrepStmts=true 这是开启预编译 */
        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //1.接受用户名+密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        String sql = " select * from tb_user where username = ? and password = ? ";
        //核心是拼接字符串
        System.out.println(sql);

        //2.获取Preparedstatment对象,传入sql
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //核心设置  ？ 的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //3.执行sql
        ResultSet rs = pstmt.executeQuery();

        //4.判断是否登录成功
        if(rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        //5.释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }


    /**
     * preparedStatement原理
     *
     * @throws Exception
     */
    @Test
    public void testPreparedStatement2() throws Exception {

        /* useServerPrepStmts=true 这是开启预编译 */
        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //1.接受用户名+密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        String sql = " select * from tb_user where username = ? and password = ? ";
        //核心是拼接字符串
        System.out.println(sql);

        /*      时间： 在把sql传递给preparedStatement对象时就已经预编译了，不会等到执行时才编译
        *       预编译  只会prepare一次
        *               execute执行n次
        *       效率高的一批哦
        * */

        //2.获取Preparedstatment对象,传入sql
        PreparedStatement pstmt = conn.prepareStatement(sql);


                    //测试 （先预编译 ，再执行）
                    Thread.sleep(10000);   //停止10ms

        //核心设置  ？ 的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

                ResultSet rs = null;

        //3.执行sql
         rs = pstmt.executeQuery();

        //核心设置  ？ 的值
        pstmt.setString(1,"aaa");
        pstmt.setString(2,"bbb");

        //3.执行sql
        rs = pstmt.executeQuery();






        //4.判断是否登录成功
        if(rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        //5.释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }


}
