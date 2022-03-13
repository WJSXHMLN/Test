package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*   请求转发  和  重定向
*           1.请求转发的地址栏不会发生改变，重定向地址栏会发生变化
*           2.请求转发只有一次请求，而重定向有两次请求
*           3.请求转发时，request对象可以共享； 重定向时request对象不可以共享。
*           4.请求转发是服务端行为，重定向是客户端行为
*           5.请求转发的地址是项目的（站点）资源，重定向的地址是任何地址
*
*
* */


@WebServlet("/ser06")
public class servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet06....");

        //接收参数
        String uname = request.getParameter("uname");
        System.out.println(uname);

        //设置域对象
        request.setAttribute("upwd","123456");

        //请求转发
        //request.getRequestDispatcher("index.jsp").forward(request,response);

        //请求转发到百度 ------（不行） 直接404
        //request.getRequestDispatcher("http://www.baidu.com").forward(request,response);


        //重定向
        //response.sendRedirect("index.jsp");

        //重定向到百度
        //response.sendRedirect("http://www.baidu.com");



    }
}
