<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基础语法</title>
</head>
<body>
<pre>
    JSP页面中有两种类型的注释：
                1.显式注释
                    能够在客户端查看的注释
                        1.继承HTML风格的注释
                                    &lt;!-- HTML风格注释 --&gt;
                2.隐式注释
                    不能够在客户端查看的注释
                        1.jsp自己的注释    &lt;%-- JSP自己的注释 --%&gt;
                                            <%-- JSP自己的注释 --%>
                        2.继承java风格的注释
                            //单行注释
                            /*多行注释*/
</pre>

<%--java脚本段--%>
<%
    //这是单行注释
    /*这是多行注释*/
%>

</body>
</html>
