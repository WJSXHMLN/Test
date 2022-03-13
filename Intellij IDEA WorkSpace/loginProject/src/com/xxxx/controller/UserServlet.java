package com.xxxx.controller;

import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {

    //controller层  调用 service层
    //实例化UserService对象  (属于service层)
    private UserService userService = new UserService();

    /*
    * 用户登录
    *       controller  （接受请求，响应结果）
                                1.接受客户端的请求（接受参数：姓名，密码）
                                2.调用service层的方法，返回消息模型对象
                                3.判断消息模型状态码
                                      如果状态码失败
                                        将消息模型对象设置到request作用域中,请求转发跳转到登录页面login.jsp
                                      如果状态码成功
                                        将消息模型中的用户信息设置到session作用域中，重定向跳转到index.jsp
    * */

    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        //1.接受客户端的请求（接受参数：姓名，密码）  login.jsp
        String uname = requset.getParameter("uname");
        String upwd = requset.getParameter("upwd");

        //2.调用service层的方法，返回消息模型对象
        MessageModel messageModel = userService.userLogin(uname,upwd);

        //3.判断消息模型的状态码
        if(messageModel.getCode() == 1 ){ //成功
            //将消息模型中的用户信息设置到session作用域中，重定向跳转到 index.jsp
                /*user 存入 messageModel.getObject()这个对象 中*/
            requset.getSession().setAttribute("user",messageModel.getObject());
            response.sendRedirect("index.jsp");

        }else { //失败
            //将消息模型对象设置到request作用域中,请求转发跳转到登录页面login.jsp
            requset.setAttribute("messageModel",messageModel);
            requset.getRequestDispatcher("login.jsp").forward(requset,response);

        }


    }
}
