<%--
  Created by IntelliJ IDEA.
  User: zzh
  Date: 2022/6/30
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<input type="button" value="新建" id="add"><input type="button" value="搜索"><br>--%>
<h1>搜索结果</h1><br> <a href="/music_war/selectAllServlet">返回主页</a>
<hr>
<table border = "1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>名称</th>
        <th>描述</th>
        <th>操作</th>
        <th>编辑</th>
    </tr>

    <c:forEach items="${musics}" var="music" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${music.music}</td>
            <td>${music.musician}</td>
            <td><form action="/music_war/play.jsp" method="post">
                <input type="hidden" name="url" value="${music.url}" ><input type="submit" value="播放">
            </form> </td>
            <td><a href="/music_war/selectByMusicServlet?music=${music.music}">编辑</a> <a href="/music_war/deleteServlet?music=${music.music}">删除</a> </td>
        </tr>
    </c:forEach>
</table>
<%--<script>--%>
<%--    document.getElementById("delete").onclick = function (){--%>
<%--        var flag = confirm("确认删除？");--%>
<%--        if (flag){--%>
<%--            location.href = "/music_war/deleteServlet?music=${music.music}";--%>
<%--        }--%>

<%--    }--%>
<%--</script>--%>



</body>
</html>
