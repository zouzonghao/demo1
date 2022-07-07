<%--
  Created by IntelliJ IDEA.
  User: zzh
  Date: 2022/6/30
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>编辑</title>
</head>
<body>
<h3>编辑</h3>
<form action="/music_war/updateServlet" method="post">
    名称:_   ${music.music}<br>
    描述:  <input name="musician"  value="${music.musician}"><br>
    URL地址：<input name="url" value="${music.url}"><br><br>
            <input type="hidden" name="music" value=${music.music}>

    <input type="submit" value="提交">
</form><br>
<input type="button" id="fanhui" value="取消">
<script>
    document.getElementById("fanhui").onclick = function (){
        location.href="/music_war/selectAllServlet";
    }
</script>
</body>
</html>
