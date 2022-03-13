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

@WebServlet("/ser05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet05 ...");

        //设置域对象内容
        request.setAttribute("name","admin");
        request.setAttribute("age",18);

        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");

        request.setAttribute("list",list);

        //请求转发跳转到servlet06
        //request.getRequestDispatcher("ser06").forward(request,response);
        //请求转发到jsp 并通过域对象像传递数据
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }
}
