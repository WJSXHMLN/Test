package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ser05")
public class Servlet05 extends HttpServlet {

    /*
     * 服务方法 (处理请求数据)
     * 系统方法,服务器自动调用
     * 当有请求到达servlet时，就会调用该方法,方法可以被多次调用
     * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet被调用了...");
    }
/*
* 初始化方法
* 系统方法，服务器自己调用
* 当请求到达serlvet容器时，servlet容器会判断该servlet对象是否存在，不存在则创建并初始化
* 方法只会执行一次
* */

    @Override
    public void init() throws ServletException {
        System.out.println("servlet被创建了");
    }
/*
*   销毁方法
*   系统方法,服务器自动调用
*  当服务器或应用程序停止时调用该方法
*   方法只会执行一次
* */
    @Override
    public void destroy() {
        System.out.println("servlet被销毁了");
    }
}
