package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/*
*       文件上传
*              使用 @MultipartConfig将一个servlet标识为文件上传
*               Servlet将Multipart/form-data封装成 Part对象 ,通过part对上传的文件进行操作
* */



@WebServlet("/UploadServlet")   //以前台的路径为准★
@MultipartConfig    //如果 文件上传表单，必须加这个注解
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("文件上传......");

        //1.设置请求的编码格式
        request.setCharacterEncoding("UTF-8");

        //2.获取普通的表单项（获取参数）
        String uname = request.getParameter("uname");//表单中表单元素的name值
        System.out.println("uname" + uname);

        //上传文件，获取part对象 (Servlet将 multipart/form-data的请求POST封装成  Part对象)
        Part part = request.getPart("myfile");        //表单中type文件域的  name属性值
        //通过Part对象得到上传的文件名
        String fileName = part.getSubmittedFileName();
        System.out.println("文件名："+ fileName);

        //得到文件的存放路径
        String filePath = request.getServletContext().getRealPath("/");  //根目录
        System.out.println("文件上传路径：" + filePath);
        //上传文件到指定目录
        part.write(filePath + "/" + fileName);

    }
}
