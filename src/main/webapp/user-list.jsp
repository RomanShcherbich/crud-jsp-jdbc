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
<body>
<table border="1">
    <caption>Users list</caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <tr>
        <td>dsf</td>
        <td>eerev</td>
        <td>ffff</td>
        <td>
            <p style="text-align: center">
                <button onclick="window.location.href = 'edit?id=6';">Edit</button>
                <button onclick="window.location.href = 'delete';">Delete</button>
        </td>
    </tr>
</table>
</body>
</html>