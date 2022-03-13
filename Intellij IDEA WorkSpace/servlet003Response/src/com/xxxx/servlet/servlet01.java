package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 响应数据
*           getWriter()         字符输出流  (输出字符串)
*           getOutputStream()   字节输出流  (输出一切类型的字符数据)
*
*两个流不可以同时使用，因为一次只可以有一个response
* */


@WebServlet("/ser01")
public class servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getWriter()         字符输出流  (输出字符串)
        /*获取字符输出流*/
        PrintWriter  write  = response.getWriter();
        //输出数据
        write.write("Hello");

        // getOutputStream()   字节输出流  (输出一切类型的字符数据)
        //得到字节输出流
        ServletOutputStream out = response.getOutputStream();
        out.write("hi".getBytes());

    }
}
