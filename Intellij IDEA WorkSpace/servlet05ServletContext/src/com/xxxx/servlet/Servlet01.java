package com.xxxx.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*ServletContext
*           获取ServletContext对象 -------------------->getServletContext()
*               1.通过request对象获取
*               2.通过session对象获取
*               3.通过servletConfig对象获取
*               4.直接获取
*
*           常用方法：
*                  1.获取服务器的版本信息
*                               request.getServletContext().getServerInfo();
*                   2.获取项目的真实路径
*                               request.getServletContext().getRealPath("/");
*
**/


@WebServlet("/s01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* 获取ServletContext的对象*/

        //1.通过request对象获取
        ServletContext servletContext1 = request.getServletContext();

        //2.通过session对象获取
        ServletContext servletContext2 = request.getSession().getServletContext();

        //3.通过servletConfig对象获取
        ServletContext servletContext3 = getServletConfig().getServletContext();

        //4.直接获取  (只可以在servlet中)
        ServletContext servletContext4 = getServletContext();

        //常用方法
        //1.获取当前服务器版本信息
        String serverinfo = request.getServletContext().getServerInfo();
        System.out.println("获取当前服务器的版本信息： "+ serverinfo );
        //2.获取项目真实路径
        String  realPath = request.getServletContext().getRealPath("/");
        System.out.println("获取项目的真实路径："+realPath);



    }
}
