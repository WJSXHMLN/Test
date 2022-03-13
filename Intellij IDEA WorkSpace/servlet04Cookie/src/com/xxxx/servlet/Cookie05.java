package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
*           Cookie路径问题
*                   1.当前服务器下任何项目的任何资源 都可以获取cookie对象
*                   2.当前项目下的资源可获取cookie对象  （默认不设置Cookie对象）  或者设置成当前站点名
*                   3.指定项目下的资源可以获取Cookie对象
*                   4.指定目录（再指定一个资源）可以获取Cookie对象
*
*           总结：
*                   只有访问路径中包含Cookie对象的path值，才可以获取该cookie对象
* */


@WebServlet("/cook05")
public class Cookie05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.当前服务器下任何项目的任何资源 都可以获取cookie对象
        Cookie cookie01 = new Cookie("cookie01","cookie01");
        //设置路径 "/"表示在当前服务器下任何项目都可以访问Cookie对象
        cookie01.setPath("/");
        response.addCookie(cookie01);

        /*当前项目下的资源可获取cookie对象  （默认不设置Cookie对象）  或者设置成当前站点名 s04*/
        Cookie cookie02 = new Cookie("cookie02","cookie02");
        cookie02.setPath("/s04");
        response.addCookie(cookie02);

       /* *//*指定项目下的资源可以获取Cookie对象*//*
        Cookie cookie03 = new Cookie("cookie03","cookie03");
        //设置指定项目的站点名
        cookie03.setPath("/sr03");   //比如之前的站点名
        response.addCookie(cookie03);*/

        /*指定项目下的资源可以获取Cookie对象*/
        Cookie cookie04 = new Cookie("cookie04","cookie04");
        //设置指定项目的站点名  s04下面的cook02才可以拿到
        cookie04.setPath("/s04/cook02");
        response.addCookie(cookie04);

        

    }
}
