package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*重定向
*          服务端指导，客户端行为
*           存在两次请求   我的request对象是新的，到了其他的request对象也还是新的，数据无法共享
*           地址栏会发生改变
*
* request一般是拿数据
* response一般是给数据
* */


@WebServlet("/ser04")
public class servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet04 ...");


        //重定向跳转到05
        response.sendRedirect("ser05");

    }
}
