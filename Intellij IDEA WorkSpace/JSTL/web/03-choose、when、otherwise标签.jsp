<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/10
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>choose、when、otherwise标签</title>
</head>
<body>
            <%--
                    choose、when、otherwise标签
                           格式：
                           <c:choose>
                                <c:when test="${score < 60}">
                                    .........
                                </c:when>
                                <c:when test="${score == 60}">
                                    .........
                                </c:when>
                                <c:when test="${score > 60 && score < 80}">
                                    .........
                                </c:when>
                                <c:otherwise>
                                    .........
                                </c:otherwise>
                            </c:choose>

                   说明：
                            1.choose标签 是没有属性---------------------------------switch
                            2.when标签只有一个test属性，必须有的---------------------case
                            3.otherwise标签 没有属性--------------------------------default

                   注意点：
                        1.choose、othewise没有属性 ，when必须有属性test
                        2.choose标签中必须中 必须包含一个when标签，可以没有otherwise标签
                        3.choose中的otherwise标签必须设置在最后一个when标签后
                        4.choose中只能设置when标签与otherwise标签
                        5.when标签和otherwise标签可以嵌套其他标签
                        6.otherwise 只有在所有when都不满足时才会执行

            --%>

<%
    //定义一些数据
    request.setAttribute("score",80);
%>
<c:choose>
       <%--非法标签在choose中 Illegal child tag in "c:choose" tag: "c:if" tag</p>--%>
    <c:when test="${score < 60}">
        <h2>你个小渣渣！</h2>
    </c:when>
    <c:when test="${score == 60}">
        <h2>分不在高，及格就行！</h2>
    </c:when>
    <c:when test="${score > 60 && score < 80}">
        <h2>也不错了！！！</h2>
        <c:if test="${1==1}">Hello World!!!</c:if>
    </c:when>
    <c:otherwise>
        <h2>你很不错呀！！！</h2>
        <c:if test="${1==1}">Hello World!!!</c:if>
    </c:otherwise>
</c:choose>

</body>
</html>
