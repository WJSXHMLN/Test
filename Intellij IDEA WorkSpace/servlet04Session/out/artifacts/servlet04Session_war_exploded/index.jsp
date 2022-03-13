<%--
  Created by IntelliJ IDEA.
  User: HPF
  Date: 2022/2/8
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>获取域对象 request和session</title>
  </head>
  <body>
            <%
                    //获取session域对象
                String uname = (String) request.getSession().getAttribute("uname");
                String upwd = (String) request.getSession().getAttribute("upwd");

                    //获取request域对象
                String name = (String) request.getAttribute("name");

                out.print("uname: "+ uname + ", upwd: "+ upwd + ", name: " + name );           //浏览器打印

            %>
  </body>
</html>
