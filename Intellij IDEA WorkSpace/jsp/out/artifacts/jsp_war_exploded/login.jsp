<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="loginServlet" method="post">
    姓名：<input type="text" name="uname"> <br>
    密码：<input type="password" name="upwd"> <br>
    <button>登录</button>
    <%-- 获取后台设置在作用域的数据 并显示 --%>
    <%--<span style="color: red;font-size: 12px"><%=request.getAttribute("msg")%></span>--%>
    <span style="color: red;font-size: 12px">${msg}</span>  <%-- ${msg}默认空字符串 --%>
</form>


</body>
</html>
