package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止乱码
        request.setCharacterEncoding("UTF-8");


        //接收客户端传递的参数
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        //判断参数是否为空
        if( uname == null || "".equals(uname.trim())){
            //提示用户信息
            request.setAttribute("msg","用户姓名不为空");
            //请求转发跳转到login.jsp
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return ;
        }

        if( upwd == null || "".equals(upwd.trim())){
            //提示用户信息
            request.setAttribute("msg","用户密码不为空");
            //请求转发跳转到login.jsp
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return ;
        }

        //判断账户密码是否正确  uname = admin  upwd = admin
        if(!"admin".equals(uname) || !"admin".equals(upwd)){
            //提示用户信息
            request.setAttribute("msg","登录失败");
            //请求转发跳转回原来的login.jsp页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return ;
        }

        //登录成功
        //设置登录信息到session作用域
        request.getSession().setAttribute("uname",uname);

        //跳转到首页
        response.sendRedirect("index.jsp");

    }
}
