<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>User Management App</title>
</head>
<header>
    <button onclick="window.location.href='list';">User Management App</button>
</header>
<body>
<table border="1">
    <caption>Users list</caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Actions</th>
    </tr>
    <%=request.getAttribute("userRowsHtml")%>
</table>
<br>
<button onclick="window.location.href='new';">Add new user</button>
</body>
</html>