package com.heima.jdbc;

import com.heima.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC API  详解：ResultSet测试
 */
public class JDBCDemo5_ResultSet {
    /**
     * 执行DQL语句     对数据操作  UPDATE account set money = 3000 where id = 1
     * @throws Exception
     */

    //@Test是注解
    @Test
    public void testResultSet() throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        //如果连接本机mysql+端口号3306 ，简化为jdbc:mysql:///


        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";

        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //3.定义sql
        String sql = "SELECT * FROM account";

        //4.获取statement对象
        Statement stmt = conn.createStatement();

        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果 （遍历结果集）
        //6.1光标向下移动一行，判断当前行受否有数据
        while(rs.next()){
/*            //6.2 获取数据 getXxx()   游标在第一行 （id  name money）
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int money = rs.getInt(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("--------------");*/

            //6.2 获取数据 getXxx()   游标在第一行 （id  name money）
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int money = rs.getInt("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("--------------");


        }

        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();

    }


    /**
     * 查询account账户表数据，封装为Account对象中，并且存储得到ArrayList集合中
     *      1.定义实体类 Account
     *      2.查询数据，封装到Account对象中
     *      3.将Account对象存入ArrayList集合中
     *
     * @throws Exception
     */
    @Test
    public void testResultSet02() throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        //如果连接本机mysql+端口号3306 ，简化为jdbc:mysql:///


        String url = "jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);  //ctrl + alt + v

        //3.定义sql
        String sql = "SELECT * FROM account";

        //4.获取statement对象
        Statement stmt = conn.createStatement();

        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //创建一个集合
        List<Account> list = new ArrayList<>();


            while(rs.next()) {
                Account account = new Account();   //对象


                //6.2 获取数据 getXxx()   游标在第一行 （id  name money）
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int money = rs.getInt("money");

                //赋值
                account.setId(id);
                account.setName(name);
                account.setMoney(money);

                //存入集合
                list.add(account);
            }
        System.out.println(list);

        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();

    }


}
