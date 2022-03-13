package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
*   request作用域
*           通过该对象在一个请求中传递数据 ，只会在请求跳转中有效
*
* 设置域对象内容
*               request.setAttribute(String name, Object value);
* 获取域对象内容
*               request.getAttribute(String name);
* 删除域对象内容
*               request.removeAttribute(String name);
*
* */

@WebServlet("/ser06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet06 ...");

        //获取域对象内容
        String name = request.getAttribute("name").toString();
        System.out.println("name: "+ name);

        Integer age = (Integer) request.getAttribute("age");
        System.out.println("age: "+ age);

        List<String> list = (List<String>) request.getAttribute("list");
        System.out.println(list.get(0));



    }
}
