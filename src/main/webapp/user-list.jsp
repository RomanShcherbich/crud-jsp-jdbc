<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="<%=request.getContextPath()%>/list" class="navbar-brand"> User
                Management App </a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<User> userList = (List<User>) request.getAttribute("listUser");
                for (int i = 0; i < userList.size(); i++) {
                    User user = userList.get(i);
                    String htmlTr = "<tr>%s</tr>";
                    String htmlTd = "<td>%s</td>";
                    String htmlActionEdit = "<a href=\"edit?id=%s\">Edit</a>";
                    String htmlActionDelete = "<a href=\"delete?id=%s\">Delete</a>";
                    int userId = user.getId();
                    StringBuilder htmlTableRow = new StringBuilder();
                    htmlTableRow.append(String.format(htmlTd, userId));
                    htmlTableRow.append(String.format(htmlTd, user.getName()));
                    htmlTableRow.append(String.format(htmlTd, user.getEmail()));
                    htmlTableRow.append(String.format(htmlTd, user.getCountry()));
                    htmlActionEdit = String.format(htmlActionEdit, userId);
                    htmlActionDelete = String.format(htmlActionDelete, userId);
                    htmlTableRow.append(String.format(htmlTd, String.join("\t",htmlActionEdit,htmlActionDelete)));
                    out.write(String.format(htmlTr, htmlTableRow.toString()));
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>