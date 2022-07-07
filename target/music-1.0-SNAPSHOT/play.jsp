<%--
  Created by IntelliJ IDEA.
  User: zzh
  Date: 2022/6/30
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Play</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--String url = request.getParameter("url");%>--%>
<%--<video controls autoplay src="<%=url%>"></video><br><br>--%>
<%--<a href="/music_war/selectAllServlet">_____________(-返回主页-)____________</a>--%>



<%--</body>--%>
<%--</html>--%>

<head>
    <link href="https://vjs.zencdn.net/7.19.2/video-js.css" rel="stylesheet" />

    <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->
    <!-- <script src="https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script> -->
</head>

<body>
<%String url = request.getParameter("url");%>
<video
        id="my-video"
        class="video-js"
        controls
        preload="auto"
        width="640"
        height="264"
        poster="MY_VIDEO_POSTER.jpg"
        data-setup="{}"
        fluid="ture"
        autoplay
>
    <source src="<%=url%>" type="video/mp4" />
    <source src="<%=url%>" type="video/webm" />
    <p class="vjs-no-js">
        To view this video please enable JavaScript, and consider upgrading to a
        web browser that
        <a href="https://videojs.com/html5-video-support/" target="_blank"
        >supports HTML5 video</a
        >
    </p>
</video>

<script src="https://vjs.zencdn.net/7.19.2/video.min.js"></script>
<br><br>
<a href="/music_war/selectAllServlet">_____________(-返回主页-)____________</a>
</body>