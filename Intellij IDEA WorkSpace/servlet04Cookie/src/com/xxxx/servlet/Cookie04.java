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

/*Cookie的注意点
            1.cookie存只在当前浏览器有效，不跨浏览器和电脑
            2.cookie不能够存中文
                    如果要存在中文 URLEncoder.encode(name)   URLEncoder.encode(value)
                                  URLDecoder.decode(name)   URLDecoder.decode(value)
            3.如果出现同名的cookie,则会覆盖
            4.cookie的存储数量有上限  ， cookie的存储大小有限

*
* */


@WebServlet("/cook04")
public class Cookie04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            /*cookie的中文*/
        String name = "姓名";
        String value = "张三";
        //将中文通URLEncoder.encode()
        name = URLEncoder.encode(name);
        value= URLEncoder.encode(value);


        //创建对象
        Cookie cookie = new Cookie(name,value);
        //响应cookie
        response.addCookie(cookie);

        //获取cookie时同通过URLDecoder进行解码
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cook:cookies) {
                //解码
                System.out.println(URLDecoder.decode(cook.getName()));
                System.out.println(URLDecoder.decode(cook.getValue()));
            }
        }


        //重名  将原来cook01中对象重更新设置
        Cookie cookie2 = new Cookie("name","老何");
        response.addCookie(cookie2);
    }
}
