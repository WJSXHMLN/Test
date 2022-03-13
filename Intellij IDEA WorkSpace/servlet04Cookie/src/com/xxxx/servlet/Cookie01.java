package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*Cookie的创建和发送
*
* */


@WebServlet("/cook01")
public class Cookie01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cookie的创建
        Cookie cookie = new Cookie("name","admin");
        //响应 发送    cookie对象
        response.addCookie(cookie);
    }
}
