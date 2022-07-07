<%--
  Created by IntelliJ IDEA.
  User: zzh
  Date: 2022/7/2
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="/music_war/registerServlet" method="post">
    <div id="msg" style="color: red">${msg}</div>
    用户名: <input name="username"><br>
      密码: <input id="p1" name="password" type="password"><br>
    确认密码:<input id="p2" name="passwordc" type="password" ><br>
    <div id="d1" style=" color: red;display: none " >两次密码不一致！</div>
    验证码:<input id="img" name="checkcode" style="width:80px"><br><img src="/music_war/checkCodeServlet" id="check" style="CURSOR: hand">

    <br>
    <input type="submit" value="提交" style="display: none" id="d2">
</form>
<br>
<a href="/music_war/login.jsp">--返回登录--</a>
<script>
    document.getElementById("p2").onblur=function () {
        var p1 = document.getElementById("p1").value.trim();
        var p2 = document.getElementById("p2").value.trim();
        var d1 = document.getElementById("d1");
        var d2 = document.getElementById("d2");
        if (p1!=null && p1 != p2){
            d1.style.display='';
            d2.style.display='none';
        }else {
            d1.style.display='none';
            d2.style.display='';
        }
    }
    document.getElementById("p1").onblur=function () {
        var p1 = document.getElementById("p1").value.trim();
        var p2 = document.getElementById("p2").value.trim();
        var d1 = document.getElementById("d1");
        var d2 = document.getElementById("d2");
        if (p1!=null && p1 != p2){
            d1.style.display='';
            d2.style.display='none';
        }else {
            d1.style.display='none';
            d2.style.display='';
        }
    }
    document.getElementById("check").onclick=function (){
        document.getElementById("check").src="/music_war/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>
</body>
</html>
