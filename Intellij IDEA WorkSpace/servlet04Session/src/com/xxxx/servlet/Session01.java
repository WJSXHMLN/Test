package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*session对象
*       session的获取
*               request.getSession()
*               当获取session对象时，先判断session对象是否存在，存在则获取session对象，不存在则创建
*
*       常用方法
*               获取session的会话唯一标识符  session.getId()
*               获取session的创建时间        session.getCreationTime()
*               获取最后一次访问时间          session.getLastAccessedTime()
*               获取判断是否是新的session对象  session.isNew()
* */

@WebServlet("/s01")
public class Session01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取session对象
        HttpSession session  =  request.getSession();

            //获取session的会话唯一标识符
        String id = session.getId();
        System.out.println("id: "+id);
            //获取session的创建时间
        System.out.println("create time: "+session.getCreationTime());
        //获取最后一次访问时间
        System.out.println("visit time: "+session.getLastAccessedTime());
        //获取判断是否是新的session对象
        System.out.println("is new object: "+session.isNew());
    }
}
