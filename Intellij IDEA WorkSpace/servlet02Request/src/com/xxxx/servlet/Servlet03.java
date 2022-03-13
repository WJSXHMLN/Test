package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 请求转发跳转
*   request.getRequestDispatcher("url").forward(request,response)
*   可以让请求从服务端跳转到客户端  或者 跳转到 servlet
*   服务器控制
*特点：
*   1.服务端行为
*   2.地址栏不发生改变
*   3.从始至终只有一个请求
*   4.数据可以共享
*
*
*
* */

@WebServlet("/ser03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
            String  uname = request.getParameter("uname");
            System.out.println("Servlet03 uname:"+ uname);

            //请求转发跳转到servlet04
        //request.getRequestDispatcher("ser04").forward(request,response);

            //请求转发到jsp页面
        //request.getRequestDispatcher("login.jsp").forward(request,response);
            //请求转发到html页面
        request.getRequestDispatcher("login.html").forward(request,response);
    }
}
