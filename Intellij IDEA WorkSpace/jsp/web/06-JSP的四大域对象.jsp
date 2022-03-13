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
    <title>JSP四大域对象</title>
</head>
<body>
        <%--
                JSP四大域对象
                    page作用域
                            当前页面有效，跳转后无效
                    request作用域
                            在一次请求中有效，在服务端跳转有效，在客户端跳转失效
                    session作用域
                            在一次会话中有效，在服务端跳转有效，在客户端跳转有效  ------ 都有效
                    application作用域
                            在整个应用中有效


               JSP跳转方式：
                 1.服务端跳转
                        <jsp:forward page="要跳转的页面地址"></jsp:forward>
                 2.客户端跳转
                         超链接 a标签   （request失效）

        --%>

    <%
        //设置page范围的域对象
        pageContext.setAttribute("name1","zhangsan");
        //设置request范围的域对象
        request.setAttribute("name2","lisi");
        //设置session范围的域对象
        session.setAttribute("name3","wangwu");
        //设置application范围的域对象
        application.setAttribute("name4","zhaoliu");
    %>

        <%-- jsp中服务端跳转 --%>
                <%--<jsp:forward page="06-JSP的四大域对象02.jsp"></jsp:forward>--%>
        <%--jsp中客户端跳转  超链接跳转--%>
        <a href="06-JSP的四大域对象02.jsp">跳转</a>

</body>
</html>
