<%@ page import="java.awt.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.xxxx.po.User" %><%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式的使用</title>
</head>
<body>
<%--
     empty属性
        判断 域对象 是否为空
                为空 返回true
              不为空 返回false
        1 如果域对象是字符串
                    1不存在的域对象  返回 true
                    2 空字符串 ，返回true
                    3 null，    返回true
        2 如果域对象是List集合
                    null:true
                    没有长度的List (size):true
                    有长度：false
        3 如果域对象是Map
                     null: true
                   空Map对象  : true
                   非空Map对象 ： false

        4 如果域对象是 JavaBean
                    null     ture
                    空对象   false
                   非空对象   false
      判断域对象不为空  ：  ${!empty  限域变量名}

--%>
        <%
            //字符串
            request.setAttribute("str1","abc");
            request.setAttribute("str2","");
            request.setAttribute("str3",null);

            //list
            List list1 = new ArrayList<>();
            List list2 = null;
            List list3 = new ArrayList<>();
            list3.add(1);
            request.setAttribute("list1",list1);
            request.setAttribute("list2",list2);
            request.setAttribute("list3",list3);

            //Map
            Map map1 = null;
            Map map2 = new HashMap<>();
            Map map3 = new HashMap<>();
            map3.put(1,2);
            request.setAttribute("map1",map1);
            request.setAttribute("map2",map2);
            request.setAttribute("map3",map3);


            //javaBean
            User user1 = null;
            User user2 = new User();
            User user3 = new User();
            user3.setUserId(1);
            request.setAttribute("user1",user1);
            request.setAttribute("user2",user2);
            request.setAttribute("user3",user3);
        %>

<div>判断字符串是否存在</div>
str ${empty str} <br>
str1${empty str1} <br>
str2 ${empty str2} <br>
str3 ${empty str3} <br>
<hr>
<div>判断集合list是否存在</div>
list1 ${empty list1} <br>
list2 ${empty list2} <br>
list3 ${empty list3} <br>
<hr>
<div>判断集合Map是否存在</div>
map1 ${empty map1} <br>
map2 ${empty map2} <br>
map3 ${empty map3} <br>
<hr>
<div>判断JavaBean是否存在</div>
map1 ${empty user1} <br>
map2 ${empty user2} <br>
map3 ${empty user3} <br>

<hr>
<hr>
<%
    request.setAttribute("a",10);
    request.setAttribute("b",2);
    request.setAttribute("c","aa");
    request.setAttribute("d","bb");
%>
<%--
比较两个值是否相等   返回 true 或者  false
        ==  或者  eq

--%>
a == b   ${a == b} <br>
c == d   ${c == d}  <br>
c eq d   ${c eq d}  <br>
a == 5   ${a == 5}  <br>
c == "aa"   ${c == "aa"}  <br>
<hr>
<%--
        +
        -
        *
        /或者 div
--%>
${a + b} <br>
${a / b} 或者  ${a div b} <br>
<hr>

<%--
        >  < >=  <=
--%>
${a > b} <br>
${a + 1 > 10} <br>
${a + b >= 10} <br>
${a > b && b > 5} <br>
${a + b > 10 || a - b > 5} <br>



</body>
</html>
