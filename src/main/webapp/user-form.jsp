<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Тег FORM</title>
</head>
<header>
    <button onclick="window.location.href='list';">User Management App</button>
</header>
<body>
<%=request.getAttribute("form")%>
</body>
</html>