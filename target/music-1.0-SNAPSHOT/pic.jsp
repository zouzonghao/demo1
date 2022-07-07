<%@ page import="java.io.FileInputStream" %>
<%@ page import="org.apache.commons.io.IOUtils" %><%--
  Created by IntelliJ IDEA.
  User: zzh
  Date: 2022/7/1
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% FileInputStream fileInputStream = new FileInputStream("C://Users/zzh/Downloads/Music/月老掉线.m4a");
ServletOutputStream servletOutputStream = response.getOutputStream();
    IOUtils.copy(fileInputStream,servletOutputStream);
%>

</body>
</html>
