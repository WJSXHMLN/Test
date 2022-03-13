<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/10
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>if 标签</title>
</head>
<body>
        <%--
                if标签
                    格式：
                           <c:if test= "<boolean>" var = "<string>" scope ="<string>"></c:if>
                    常用属性：
                        test：  条件判断，操作的是域对象，接受返回结果是 true 或者 false   ---- 必须
                        var： 限域变量名（存放在作用域中的变量名）,用来接受判断结果
                        scope: 限域变量名的范围， page, request ,session, application
                    注意：
                        1.标签操作的一般都是域对象
                        2.if标签没有else  如果要else的效果，需要设置两个完全相反的条件
        --%>
        <%
            //为了测试方便，直接在jsp页面中写
            //设置数据
            request.setAttribute("num",10);
        %>

        <%-- 取的是域对象的值，所以使用的是EL表达式 --%>
        <c:if test="${ num > 0}">
            1.&nbsp;&nbsp;&nbsp;数值大于0  --- ${num > 0}
        </c:if>
        <c:if test="${num <= 10}">
            2. 数值小于等于0 ----${num <= 10}
        </c:if>

        <br>
        <c:if test="${num > 100}" var = "flag" scope="request"></c:if>
        ${flag} ---  ${requestScope.flag}   ---   ${sessionScope.flag}


</body>
</html>
