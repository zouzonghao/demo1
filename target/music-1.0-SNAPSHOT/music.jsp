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
    <title>Music</title>
</head>
<body>
<%--<audio controls src="https://ws.stream.qqmusic.qq.com/C4000020wJDo3cx0j3.m4a?guid=494700126&vkey=30F2B248EA8A1C9FB1640F1AA2E6CB792E8D61AD0E025232478AEE133925D67435F3416F9EBA0861811E42DD5729292D1FBC9C3FBE54F6BA&uin=626567678&fromtag=103032"></audio>--%>
<%--<input type="button" value="新建" id="add"><input type="button" value="搜索"><br>--%>
<form action="/music_war/selectByLikeMusicServlet" method="get">
    <input name="music"><input type="submit" value="搜索歌名">
</form><a href="/music_war/picServlet">下载</a>   <a href="/music_war/upload.jsp">上传</a>

<a href="/music_war/add.jsp">添加</a>   <a href="/music_war/escServlet">退出</a>
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
            </form>
<%--                <a href="#">暂停</a> <a href=${music.url}>下载</a> </td>--%>
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

<%--<script>--%>
<%--    function sendBtn(node) {--%>
<%--        var url = node.id;--%>
<%--        $.ajax({--%>
<%--            url:url,--%>
<%--            type:'POST'--%>
<%--        })--%>

<%--    }--%>
<%--</script>--%>

</body>
</html>
