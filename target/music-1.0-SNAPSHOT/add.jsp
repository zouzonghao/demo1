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
    <title>添加</title>
</head>
<body>
<h3>添加</h3>
<form action="/music_war/addServlet" method="post">
    名称: <input name="music"><br>
    描述: <input name="musician"><br>
    URL地址:<input name="url"><br><br>


    <input type="submit" value="提交">
</form>
<br><br>
<a href="/music_war/selectAllServlet">_____________(-返回主页-)____________</a>
</body>
</html>
