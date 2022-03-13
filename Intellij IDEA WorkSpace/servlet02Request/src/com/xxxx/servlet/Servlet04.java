package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 请求转发跳转
*   可以让请求从服务端跳转到客户端  或者 跳转到 servlet
*   服务器控制
*
*
*
*
* */

@WebServlet("/ser04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
            String  uname = request.getParameter("uname");
        System.out.println("Servlet04 uname:"+ uname);
    }
}
