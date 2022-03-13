<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include动态包含</title>
</head>
<body>
<%--
        include动态包含
                格式：
                        <jsp:include page="要包含页面的地址"></jsp:include>
                特点：
                        1.动态包含相当于方法的调用
                        2.动态包含会生成多个源码文件
                        3.可以定义同名变量
                        4.效率高，耦合低
                 注意：
                        当动态包含不需要传递参数时，include标签之间不要有任何内容，包括空格和换行✔✔✔✔✔✔✔✔

                  使用动态包含传递参数
                                <jsp:include page="要包含的页面的地址">
                                        <jsp:param name="参数名" value="参数值"/>
                                </jsp:include>
                                住：name属性不支持表达式， value属性支持动态表达式

                            获取参数
                                        request.getParameter(name);  通过指定参数名获取参数值
--%>
        <jsp:include page="04-header.jsp"></jsp:include>
        <h2>主体内容</h2>
        <% int a = 1; //include动态包含可以出现同名的变量，相当于方法的调用 %>
        <jsp:include page="04-footer.jsp"></jsp:include>

        <%-- 动态包含传递参数 --%>
        <%
                String str = "Hello World";
        %>

        <jsp:include page="04-footer.jsp">
                <jsp:param name="uname" value="admin"/>
                <jsp:param name="msg" value="<%=str%>"/>
        </jsp:include>
</body>
</html>
