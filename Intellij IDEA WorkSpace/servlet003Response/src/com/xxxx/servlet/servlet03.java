package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*字节流响应数据*/


@WebServlet("/ser03")
public class servlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //同时设置客户端和服务端编码
        response.setContentType("text/html;charset=UTF-8");

        // getOutputStream()   字节输出流  (输出一切类型的字符数据)
        //得到字节输出流
        ServletOutputStream out = response.getOutputStream();
        out.write("<h2>我很嗨</h2>".getBytes("UTF-8"));

    }
}
