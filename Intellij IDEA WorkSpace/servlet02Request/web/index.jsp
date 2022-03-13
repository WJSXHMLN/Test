<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HPF
  Date: 2022/2/5
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>index页面</h2>
<%--如果要在jsp中写java代码，需要写在脚本段中--%>
  <%
      //获取对象
    String name = request.getAttribute("name").toString();
    System.out.println("name: "+ name);

    Integer age = (Integer) request.getAttribute("age");
    System.out.println("age: "+ age);

    List<String> list = (List<String>) request.getAttribute("list");
    System.out.println(list.get(0));
  %>
  </body>
</html>
