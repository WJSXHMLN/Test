package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 实现Servlet
*   1.创建普通java类
*   2.实现servlet的规范，继承HttpServlet的类
*   3.重写service方法，用来处理请求
*   4.设置注解，指定访问的路径
* */
@WebServlet("/ser01")           //这就是注解，指定访问路径 ，/不要忘记
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  打印内容
        System.out.println("hello,servelt");
        // 通过流输出数据到浏览器
        resp.getWriter().write("hello servlet");
    }
}
