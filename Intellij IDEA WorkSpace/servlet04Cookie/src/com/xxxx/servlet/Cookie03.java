package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*   Cookie的到期时间
*           负整数
*                       表示只在浏览器的内存中存活
*           正整数
*                       表示存活秒数
*             0
*                       表示删除cookie
* */


@WebServlet("/cook03")
public class Cookie03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                /*到期时间， 负整数（默认值-1，表示只在浏览器内存中存活，关闭浏览器则失效） */
                Cookie cookie = new Cookie("uname1","张三");
                cookie.setMaxAge(-1); //关闭浏览器则失效
                response.addCookie(cookie); //响应浏览器


                /*正整数，表示存活秒数，表示会将数据存在磁盘中*/
                Cookie cookie2 = new Cookie("uname2","李四");
                cookie2.setMaxAge(30);  //存活30秒
                response.addCookie(cookie2);  //响应

                /*0 ， 表示删除cookie*/
                Cookie cookie3 = new Cookie("uname3","王五");
                cookie3.setMaxAge(0);  //删除Cookie
                response.addCookie(cookie3);  //响应浏览器
    }
}
