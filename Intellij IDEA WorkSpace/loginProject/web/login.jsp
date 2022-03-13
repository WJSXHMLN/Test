<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2022/2/11
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div style="text-align: center">
    <form action="/login" method="post" id="loginForm" >
        姓名：<input type="text" name="uname" id="uname" value ="${messageMoel.object.userName}"><br>
        密码：<input type="password" name="upwd" id="upwd" value ="${messageMoel.object.userPwd}"><br>
        <span id="msg" style="font-size: 12px;color: blue">${messageModel.msg}</span><br>
        <button type="button" id="loginBtn">登录</button>
        <button type="button">注册</button>
    </form>
</div>
</body>
<%-- 引入jquery.js文件 --%>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
    /*
    * 登录表单验证
        1.给登录按钮绑定点击事件 (通过id选择器绑定)
        2.获取用户姓名和密码值
        3.判断姓名是否为空
            姓名为空，(span赋值) 提示用户 并且 return
        4.判断密码是否为空
            密码为空，(span赋值) 提示用户 并且 return
        5.如果都不为空，手动提交表单。
    * */
    $("#loginBtn").click(function () {
        /*获取用户名和密码*/
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();

        /*判空姓名*/
        if( isEmpty(uname) ){
            //span提醒
            //如果用户名为空，提示用户 并且return  html()
            $("#msg").html("用户名不能为空！");
            return;
        }
        /*判断密码是否为空*/
        if (isEmpty(upwd)){
            $("#msg").html("用户密码不能为空！");
            return ;
        }

        //提交表单
        $("#loginForm").submit();
    });

    /* function: 判空
    *       判断字符串  是否为空
    *           为空   返回true
    *         不为空   返回false
    * */
    function isEmpty(str) {
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }
</script>

</html>
