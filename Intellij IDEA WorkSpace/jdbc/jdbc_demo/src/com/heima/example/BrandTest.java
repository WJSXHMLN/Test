package com.heima.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.heima.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 *           品牌数据的增删改
 * */
public class BrandTest {


    /*
     *       查询所有
     *           1.sql : select * FROM tb_brand;
     *           2.参数：无
     *           3.结果 list<Brand>
     * */

    @Test
    public void testSelectAll() throws Exception {

        //System.out.println(System.getProperty("user.dir"));

        //1.获取连接 Connection对象  (加载配置文件 + 获取数据池对象 + 获取数据库连接)
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:/Intellij IDEA WorkSpace/jdbc/jdbc_demo/src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection conn = dataSource.getConnection();


        //2.定义sql
        String sql = "select * FROM tb_brand;";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数

        //5.执行sql
        ResultSet rs = pstmt.executeQuery();

        //6.处理结果     List<Brand> 封装Brand对象，状态List集合

        Brand brand = null;  //Brand放外面解决栈空间， 里面可以复用
        List<Brand> brands = new ArrayList<>();

        while (rs.next()) {
            //获取数据  rs.getXx()方法
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //封装对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            //装在集合
            brands.add(brand);
        }
        System.out.println(brands);

        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }


    /*
     *       添加
     *           1.sql : insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);
     *           2.参数：要，除了id
     *           3.结果：boolean
     * */

    @Test
    public void testAdd() throws Exception {

        /*
         *       接受页面提交的参数
         * */
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "香飘飘一年卖出3亿杯";
        int status = 1;


        //System.out.println(System.getProperty("user.dir"));

        //1.获取连接 Connection对象  (加载配置文件 + 获取数据池对象 + 获取数据库连接)
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:/Intellij IDEA WorkSpace/jdbc/jdbc_demo/src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection conn = dataSource.getConnection();


        //2.定义sql
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

        //5.执行sql  (add)
        int count = pstmt.executeUpdate();   //影响的行数

        //6.处理结果
        System.out.println(count > 0);


        //7.释放资源
        pstmt.close();
        conn.close();

    }


    /*
     *       修改
                1.sql : update tb_brand
                        set brand_name = ?,
                            company_name=?,
                            ordered=?,
                            description=?,
                            status=?
                          where id = ?
     *           2.参数：要Brand对象所有数据
     *           3.结果：boolean
     * */

    @Test
    public void testUpdate() throws Exception {

        /*
         *       接受页面提交的参数
         * */
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "傻逼";
        int status = 1;
        int id = 7;


        //System.out.println(System.getProperty("user.dir"));

        //1.获取连接 Connection对象  (加载配置文件 + 获取数据池对象 + 获取数据库连接)
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:/Intellij IDEA WorkSpace/jdbc/jdbc_demo/src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection conn = dataSource.getConnection();


        //2.定义sql
        String sql = "update tb_brand \n" +
                "     set brand_name = ?, \n" +
                "         company_name=?,\n" +
                "         ordered=?,\n" +
                "         description=?,\n" +
                "         status=? \n" +
                "      where id = ?";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6,id);

        //5.执行sql  (add)
        int count = pstmt.executeUpdate();   //影响的行数

        //6.处理结果
        System.out.println(count > 0);


        //7.释放资源
        pstmt.close();
        conn.close();

    }


    /**
     *    删除  按照id删除
     *          1.sql  :       delete from tb_brand where id = ?
     *          2.参数           id
     *          3.返回结果      boolean
      @throws Exception
     */


    @Test
    public void testDeleteById() throws Exception {

        /*
         *       接受页面提交的参数
         * */
        int id = 7;


        //System.out.println(System.getProperty("user.dir"));

        //1.获取连接 Connection对象  (加载配置文件 + 获取数据池对象 + 获取数据库连接)
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:/Intellij IDEA WorkSpace/jdbc/jdbc_demo/src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection conn = dataSource.getConnection();


        //2.定义sql
        String sql = "delete from tb_brand where id = ?";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setInt(1,id);

        //5.执行sql  (add)
        int count = pstmt.executeUpdate();   //影响的行数

        //6.处理结果
        System.out.println(count > 0);


        //7.释放资源
        pstmt.close();
        conn.close();

    }

}
