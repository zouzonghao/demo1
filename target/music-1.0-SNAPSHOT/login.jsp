<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zzh
  Date: 2022/7/2
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>ZZH欢迎您！</h1>
<form action="/music_war/loginServlet" method="post">
    <div id="msg" style="color: red">${msg}</div>
    <p>请输入账号：<input name="username" value="${cookie.username.value}"></p>
    <p>请输入密码：<input name="password" value="${cookie.password.value}" type="password"></p>
    <input type="submit" value="登录">  <input type="button" value="注册" onclick="on()"><br><br>

        记住我<input type="checkbox" name="rem" value="1" checked>




</form>
    <script>
        function on() {
            location.href = "/music_war/register.jsp" ;
        }
    </script>

</body>
</html>
