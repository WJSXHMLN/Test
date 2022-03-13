<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.xxxx.po.User" %><%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/9
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式的使用</title>
</head>
<body>
<%--
        EL表达式的使用
                request.setAttribute("list",list);
                获取List
                       获取List的size值   ${list.size()}
                       获取List的指定下标值  ${list[下标]}
                 注意：list代表的是 限域变量名

                request.setAttribute("ok",list)
                获取List
                        获取List的size值  ${ok.size()}
                        获取List的指定下标值  ${ok[1]}
                 注意：ok代表的是 限域变量名


                 获取Map
                        获取Map中指定key的value   ${map.key}   或者  ${map["key"]}

                 获取javabean对象
                        获取javabean中的属性
                                ${javaBean.属性名}  或者  ${javabean.get属性名()}
                         注意：javaBean中的属性字段必须提供get方法 比如：get汤家凤()
--%>


        <%
                //List
            List<String> list = new ArrayList<>();
            list.add("aaa");
            list.add("bbb");
            list.add("ccc");
            request.setAttribute("ok",list);

                //Map
            Map map = new HashMap();
            map.put("aaa","111");
            map.put("bbb",2222);
            map.put("ccc",333);
            request.setAttribute("map",map);

                //javaBean对象
            User user = new User();
            user.setUserId(1);
            user.setUname("zhangsan");
            user.setUpwd("123456");
            request.setAttribute("user",user);  //限域 变量名user

        %>

<h4>获取List</h4>
获取List的size值：${ok.size()} <br>
获取List的指定下标值：${ok[1]} <br>
这里的ok是限域变量名，是requst.setAttribute("ok",list)里的ok
<hr>

<h4>获取Map</h4>
获取Map指定的key的value值：${map.aaa} -- ${map["bbb"]}
<hr>

<h4>获取javaBean</h4>
获取javaBean对象：${user} <br>
获取javaBean中的属性：${user.uname} ------ ${user.getUpwd()}


</body>
</html>
