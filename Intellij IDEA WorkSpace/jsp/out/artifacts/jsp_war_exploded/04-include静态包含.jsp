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
    <title>include静态包含</title>
</head>
<body>
        <%--
                    include静态包含
                            格式：<%@include = "要包含的页面地址"%>
                            特点：
                                1.将内容进行直接的替换
                                2.静态包含只会生成一个源码文件，最终全部在jspServie方法体中（源码文件中）
                                3.不能出现同名变量
                                4.运行效率高，耦合性高，不够灵活
        --%>


    <%@include file="04-header.jsp"%>
            <h2>主体内容</h2>
    <%@include file="04-footer.jsp"%>
</body>
</html>
