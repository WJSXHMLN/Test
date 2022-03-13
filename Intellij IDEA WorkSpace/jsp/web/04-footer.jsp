<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>底部</title>
</head>
<body>
                <h2>底部内容</h2>
                <%
                    int a = 1;  //include动态包含可以出现同名的变量
                    //获取动态包含传递的参数
                    String uname =  request.getParameter("uname");
                    String msg =  request.getParameter("msg");
                    out.print(uname + "," + msg);
                %>
</body>
</html>
