<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xxxx.po.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/10
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>forEach迭代标签</title>
</head>
<body>
        <%--
                forEach迭代
                    格式：
                        <c:forEach
                            items = "<object>"
                            begin = "<int>"
                            end = "<int>"
                            step = "<int>"
                            var = "<string>"
                            varStatus = "<string>">
                        </c:forEach>
                   属性：
                           begin  开始数
                           end  结束数
                           step   间隔数
                           var  限域变量名，用来接受当前遍历的成员
                           items  要循环的数据，（数组 list Map）

                       varStatus的属性：
                                index  当前这次迭代从0 开始的迭代索引
                                count  当前这次迭代从1 开始的迭代计数
                                first  用来表明当前这次迭代是否为第一次迭代的标志
                                last   用来表面当前这次迭代是否为最后一次迭代的标志


                            1.迭代主体内容多次
                                <c:forEach begin = "开始数" end = "结束数" step = "间隔数" var = "限域变量名" >
                                </c:forEach>
                                相当于java中
                                    for(int i = 0; i < 10 ; i++){

                                    }
                            2.循环
                            <c:forEach items = "要被循环的数据" var = "限域变量名">
                            </c:forEach>
                            相当于java的foreach
                            foreach(String str : list){
                            }
        --%>

        <%--迭代主体内容多次--%>
        <c:forEach var = "i" begin="1" end="10" step="2">
                ${i}&nbsp;
        </c:forEach>
        <hr>
        <%--循环--%>
        <%
                List<String> list = new ArrayList<>();
                for(int i = 0 ; i <= 10 ; i++){
                        list.add("A:" + i);
                }
                pageContext.setAttribute("li",list);
        %>
        <c:forEach items="${li}" var="item">
                ${item}&nbsp;
        </c:forEach>
        <hr>
        <hr>
        <%--forEach 循环--%>
        <table style="border-collapse: collapse" align="center" width="800" border="1">
                <tr>
                        <th>名称</th>
                        <th>当前成员下标</th>
                        <th>当前成员循环数</th>
                        <th>是否第一次被循环</th>
                        <th>是否最后一次被循环</th>
                </tr>
                <c:forEach items="${li}" var="item" varStatus="itemp">
                <tr>
                        <td>${item}</td>
                        <td>${itemp.index}</td>
                        <td>${itemp.count}</td>
                        <td>${itemp.first}</td>
                        <td>${itemp.last}</td>
                </tr>
                </c:forEach>
        </table>
        <hr>
        <hr>
        <br>
        <br>

        <%-- 循环对象集合 --%>
        <%
                //创建一个 User的 对象集合
                List<User> userList = new ArrayList<User>();
                //创建User 对象
                User user1 = new User(1,"zhangsan","111111");
                User user2 = new User(2,"lisi","222222");
                User user3 = new User(3,"wangwu","333333");
                //给User的对象集合 添加 对象
                userList.add(user1);
                userList.add(user2);
                userList.add(user3);
                //将数据设置到作用域中
                request.setAttribute("userList",userList);
        %>
        <%--遍历之前，先对集合做非空判断--%>
        <c:if test="${!empty userList}">
                <%--当 集合 不为空 则遍历集合--%>
                <table align="center" width="800" border="1" style="border-collapse: collapse">
                        <tr>
                                <th>用户编号</th>
                                <th>用户名称</th>
                                <th>用户密码</th>
                                <th>用户操作</th>
                        </tr>
                        <c:forEach items="${userList}" var="user">
                                <tr align="center">
                                        <td>${user.userId}</td>
                                        <td>${user.uname}</td>
                                        <td>${user.upwd}</td>
                                        <td><button>修改</button></td>
                                </tr>
                        </c:forEach>
                </table>
        </c:if>

        <%-- 循环Map --%>
        <%
                Map<String ,Object> map = new HashMap<>();

                map.put("map1","aaa");
                map.put("map2","bbb");
                map.put("map3","ccc");
                //给数据设置到作用域中
                request.setAttribute("map",map);

        %>
        <%-- 遍历map --%>
        <c:forEach items="${map}" var = "item">
                key：${item.key} &nbsp; value:${item.value} <br>
        </c:forEach>

</body>
</html>
