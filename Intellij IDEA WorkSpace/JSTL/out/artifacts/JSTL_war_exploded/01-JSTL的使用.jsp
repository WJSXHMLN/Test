<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/10
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>

<%--
        JSTL
                通过taglib标签引入所需要的标签库
          语法： <@taglib uri = ""  prefix = ""%>
                    core核心库    fmt格式化


          JSTL使用流程:
                1.下载jstl所需要的jar包   standard.jar  和  jstl.jar
                2. 将项目的web目录下的WEB-INF中新建一个  lib 目录 ，将jar包 copy进去
                3. 将lib目录 引入到 项目中
                            File --  project Structure  -- module --- dependencies -- 选择jar包目录 ，勾选tomcat和jar目录
                4.在需要使用标签库的jsp页面通过taglib标签引入 库
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>JSTL的使用</title>
</head>
<body>
        <c:if test="${1 == 1}">
            Hello JSTL
        </c:if>
</body>
</html>
