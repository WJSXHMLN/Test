package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* Session对象的销毁
*       1.默认到期时间  tomcat 30分钟 可再tomcat的conf目录中 web.xml文件中进行修改
*               这是修改服务器的session时间
*              <session-config>
*                    <session-timeout>30</session-timeout>
*               </session-config>
*
*       2.手动设置session到期时间
*                session.setMaxInactiveInterval(int)   来设定 session 的最大不活动时间，单位为秒
*                getMaxInactiveInterval() 查看当前session 对象的最大不活动时间
*
*       3.立即销毁
*                     session.invalidate();
*       4.管理浏览器失效
*                     session底层默认依赖cookie
*                     cookie对象默认在浏览器内存中存活，管理浏览器则失效
*
*       5.关闭服务器,session失效
*
* */

@WebServlet("/s03")
public class Session03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取session对象
        HttpSession session = request.getSession();
            //设置session域对象
        session.setAttribute("uname","admin");

        /*//获取session的最大不活动时间
        System.out.println("最大不活动时间: "+ session.getMaxInactiveInterval());
        //设置（修改）session的最大不活动时间
        session.setMaxInactiveInterval(15);   //15秒即失效*/


        //session立刻销毁
        session.invalidate();




    }
}
