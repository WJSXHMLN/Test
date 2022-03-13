<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <%--
                EL表达式
                   作用：
                        简化jsp代码
                   格式：
                        ${域对象名称}
                    操作对象：
                           EL表达式一般操作域对象，不能操作局部变量
                    操作范围：
                            page            在当前页面
                            request         在一次请求
                            session         在一次会话
                            application     在应用程序
                 注意：1.如果EL表达式获取域对象的值为空，默认显示 空字符串
                      2.默认从小到达范围去找，找到即止   page < request  < session < application
                      如果四个都没有找到，则显示 空字符串
                      3. 如果想要查找指定范围
    --%>

<%--准备数据--%>
    <%
        pageContext.setAttribute("uname","zhangsan");   //page作用域
        request.setAttribute("uname","lisi");
        session.setAttribute("uname","wangwu");
        application.setAttribute("uname","zhaoliu");

        //定义局部变量
        String str = "hello";
    %>
<%-- 获取数据 --%>
    获取局部变量：${str} <br>
    获取域对象： ${uname} <br>
    获取指定范围的域对象：<br>
    &nbsp;&nbsp;page范围：${pageScope.uname}<br>
    &nbsp;&nbsp;request范围：${requestScope.uname}<br>
    &nbsp;&nbsp;session范围：${sessionScope.uname}<br>
    &nbsp;&nbsp;application范围：${applicationScope.uname}<br>


</body>
</html>
