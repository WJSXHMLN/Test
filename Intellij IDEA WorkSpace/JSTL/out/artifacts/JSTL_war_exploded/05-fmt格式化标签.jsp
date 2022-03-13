<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/10
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>fmt格式化标签</title>
</head>
<body>
    <%-- format格式化标签
            formatNumber标签
                将数值型转化为指定格式的字符串
               语法格式：
                    <fmt:formatNumber>
                        value = "<string>"
                        type = "<string>"
                        var =  "<string>"
                        scope = "<string>"/>
                 常用属性：
                        value  要格式化的数值
                        type   要格式化的类型
                                number数值型
                                percent 百分比 默认
                                currency 货币类型
                         var  限域变量名 ，用来接受格式化后的结果
                         scope  var限域变量名的范围   (page|request|session|application)

                    注意：如果使用了var属性，标签不会输出结果，需要EL（Expression language）表达式获取
                          type 默认 number




           formatdate标签
                将Date型的数据转化成指定格式的字符串
                语法格式：
                        <fmt:formatDate
                            value = "<string>"
                            type =  "<string>"
                            dateStyle = "<string>"
                            timeStyle ="<string>"
                            pattern = "<string>"
                            timeZone = "<string>"
                            var = "<string>"
                            scope = "<string>"/>
                 value  要格式的日期
                 type   格式化的类型
                            date   日期    年月日
                            time   时间     时分秒
                            both  日期+时间   年月日时分秒
                 datestyle  日期格式
                 timestyle  时间格式
                        FULL  LONG  MEDIUM  SHORT DEFALUT

                 pattern   自定义模式
                        y  M  d  h  H  m  s
                 timezone
                 var


           parseNumber标签
                        将指定格式的数值字符串转化为数值型
                            语法格式
                                <fmt:parseNumber
                                value = "<string>"
                                type = "<string>"
                                var = "<string>"
                                scope =  "<string>"/>


           parseDate标签
                        将指定格式的日期字符串转换为Date型
                            语法格式：
                                <fmt:pareDate
                                    value = "<string>"
                                    type = "<string>"
                                    dateStyle = "<string>"
                                    timeStyle = "<string>"
                                    pattern = "<string>"
                                    var = "<string>"
                                    scope = "<string>"/>




    --%>
    <fmt:formatNumber value="10" type="number" var="num"/> ${num} var是定义num这个变量，来接收数据的 <br>
    <fmt:formatNumber value="10" type="percent"/> <br>
    <fmt:formatNumber value="10" type="currency"/> &nbsp;中国<br>
    <%-- 设置时区 --%>
    <fmt:setLocale value="en_US"/>  &nbsp;设置美国时区&nbsp;
    <fmt:formatNumber value="10" type="currency"/> &nbsp;美国<br>
    <hr>
    <hr>
    <br>
    <%--    格式化日期   --%>
    <%
        request.setAttribute("mydate",new Date());
    %>
    默认：${mydate} <br>
    <%-- 使用标签来转下 --%>
    date:<fmt:formatDate value="${mydate}"/> <br>
    time:<fmt:formatDate value="${mydate}" type="time"/> <br>
    date:<fmt:formatDate value="${mydate}" type="date"/> <br>
    both:<fmt:formatDate value="${mydate}" type="both"/> <br>
    datestyle:<fmt:formatDate value="${mydate}" type="both" dateStyle="FULL"/> <br>
    timestyle:<fmt:formatDate value="${mydate}" type="both" timeStyle="short"/> <br>
    自定义：<fmt:formatDate value="${mydate}" pattern="yyyy-MM-dd"/> 自己指定的日期格式<br>
    var:<fmt:formatDate value="${mydate}" var="hello"/> 用了var,需要单独获取 ${hello}<br>
    <hr>
自己格式化一个看看 : &nbsp;&nbsp;
<fmt:formatDate value="${mydate}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
    <hr>
    <hr>

    <%--parseNumber--%>

    <fmt:parseNumber value="100" /> <br>
    <fmt:parseNumber value="100" type="number" /> <br>
    <fmt:parseNumber value="100%" type="percent"/> <br>
    <fmt:setLocale value="en_US"/>
    <fmt:parseNumber value="$100.00" type="currency"/> <br>
    <hr>
    <%-- 日期  parseDate --%>
<%--<fmt:parseDate value="2018-10-01" type="date"/>--%>
<fmt:parseDate value="2020/10/01" pattern="yyyy/MM/dd"/>




</body>
</html>
