package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
   //乱码原因：解析过程使用  iso-8859-1
* 请求乱码问题
*       Tomcat 8 以上
* GET 请求   不会乱码
*
* POST 请求  乱码
*       设置服务器解析编码的格式
*        request.setCharacterEncoding("UTF-8")  只针对post请求乱码
*乱码：post请求，无论什么版本都是会乱码，解决request.setCharacterEncoding("UTF-8")
* */
/*
*   1.request.setCharacterEncoding("UTF-8")   只针对post请求乱码有效
*   2.new String(request.getParameter("uname").getBytes(charsetName:"ISO-8859-1",charsetName:"UTF-8")针对任何方式请求
*
* */

@WebServlet("/ser02")
public class Servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的编码格式
        requset.setCharacterEncoding("UTF-8");

        //获取前台客户端传递的参数
        String uname = requset.getParameter("uname");
        String upwd = requset.getParameter("upwd");
        System.out.println("姓名："+ uname);
        System.out.println("年龄："+ upwd);

    }
}
