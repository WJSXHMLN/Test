<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scriptlet脚本小程序</title>
</head>
<body>
        <%--
                Scriptlet脚本小程序
                        jsp一共有三种Scriptlet脚本小程序：
                               1. java脚本段，可以写java代码，定义局部变量，编写语句
                                    <%
                                            //可以写java代码
                                    %>
                                    生成的代码在servlet的service方法体中
                               2.声明
                                    声明全局变量，方法，类
                                    <%!
                                            //声明全局变量
                                    %>
                                    生成的代码在servlet的类体中
                               3.输出表达式
                                    可以输出变量和字面量
                                    <%=数值 %>
                                    生成的代码在servlet的service方法体中，相当于out.print()输出
        --%>

<%-- 1. java脚本段，可以写java代码，定义局部变量，编写语句--%>
        <%
                //定义局部变量
            String str = "Hello jsp";
                //输出到控制台
            System.out.println(str);
                //输出到浏览器
            out.print(str);
            out.write("----------------------------");

            //输出全局变量
            out.print("输出全局变量："+ num);
            out.write("----------------------------");
        %>



<%-- 2.声明全局变量，方法，类--%>
        <%!
            //声明全局变量
            int num = 10;
        %>

<%-- 3.输出表达式 可以输出变量和字面量--%>
<%=str %>





</body>
</html>
