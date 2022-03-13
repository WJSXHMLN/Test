package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*字符流响应数据
*
*乱码：
*       getWriter()响应中文一定乱码，内部是iso-8859-1
*解决：
*       1.设置 服务端 编码格式
*           response.setCharacterEncoding();
*       2.设置 客户端 编码格式
*           response.setHeader("context-type","text/html;charset=utf-8")
*总结：
*       设置客户端和服务端的编码都支持中文，且都保持一致
*
* 同时设置客户端和服务端的编码格式：  response.setContentType("text/html;charset=UTF-8)
*
* */


@WebServlet("/ser02")
public class servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*        //设置服务端编码设置
        response.setCharacterEncoding("UTF-8");
        //设置客户端编码格式 和 响应的MIME类型
        response.setHeader("content-type","text/html;charset=UTF-8");
*/

        //方案二，同时设置客户端 服务端
        response.setContentType("text/html;charset=UTF-8");

        //getWriter()         字符输出流  (输出字符串)
        /*获取字符输出流*/
        PrintWriter  write  = response.getWriter();
        //输出数据
        write.write("<h2>您好</h2>");

    }
}
