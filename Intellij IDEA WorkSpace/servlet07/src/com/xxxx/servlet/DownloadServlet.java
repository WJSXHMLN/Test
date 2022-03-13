package com.xxxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
*       文件下载
*               1.使用response.setContentType 方法设置 Content-type 头字段的值，
*           为浏览器无法使用某种方式或激活某个应用程序的MIME类型
*                           application/octet-stream  或者  application/x-msdownload
*               2.使用respone.setHeader 方法设置
*                            Content-Dispotion 弹出框 头的值为 "attachment;filename = 文件名"
*               3.读取下载文件，调用response.getOutputstream 方法向客户端写入附件内容
* */

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("文件下载......");

        //1.设置请求编码格式
        request.setCharacterEncoding("UTF-8");

        //2.获取参数（文件名），得到要下载的文件名
        String fileName = request.getParameter("fileName");

        //3.参数的非空判断， 可能没有写文件名   trim()去除字符串前后空格，中间不管
        if (fileName == null || fileName.trim() == "") {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("请输入要下载的文件名!!!");   //浏览器显示提示信息
            response.getWriter().close();  //关闭流
            return;
        }

        //4.得到图片的存放路径 path
        String path = request.getServletContext().getRealPath("/download/");

        //5.通过路径得到一个file对象
        File file = new File(path + fileName);

        //6.判断文件对象是否存在，并且是一个标准文件
        if (file.exists() && file.isFile()) {
            //设置响应类型 ( 为浏览器无法使用某种方式或激活某个应用程序的MIME类型)
            response.setContentType("application/x-msdownload");
            //设置响应头
            response.setHeader("Content-Dispotion", "attachment;filename=" + fileName);

            /*响应文件*/
            //得到file文件输入流
            InputStream in = new FileInputStream(file);
            //得到字节输出流
            ServletOutputStream out = response.getOutputStream();
            //输出资源，定义一个byte[]
            byte[] bytes = new byte[1024];
            //定义一个长度，遍历用
            int len = 0;
            //循环输出
            while ((len = in.read(bytes)) != -1) {
                //输出内容
                out.write(bytes, 0, len);
            }
            //关闭资源 (一般是先打开的后关闭)
            out.close();
            in.close();


        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("文件不存在，请重试！！！");
            response.getWriter().close();
        }
    }
}
