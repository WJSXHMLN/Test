<%--
  Created by IntelliJ IDEA.
  User: HPF
  Date: 2022/2/6
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%-- java脚本段 --%>
      <%
          //获取参数
            String uname = request.getParameter("uname");

          //获取作用域  因为在ser06中设置了upwd的域对象
            String upwd = (String) request.getAttribute("upwd");

            //输出内容
          out.print(uname);
          out.print("\n");
          out.print(upwd);
      %>
  </body>
</html>
