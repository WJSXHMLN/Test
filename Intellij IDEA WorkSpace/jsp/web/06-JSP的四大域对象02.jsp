<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP四大域对象02</title>
</head>
<body>
        <%
                //获取域对象值
                out.print("page范围："+ pageContext.getAttribute("name1") + "<br>");
                out.print("request范围："+ request.getAttribute("name2") + "<br>");
                out.print("session范围："+ session.getAttribute("name3") + "<br>");
                out.print("application范围："+ application.getAttribute("name4") + "<br>");

        %>


</body>
</html>
