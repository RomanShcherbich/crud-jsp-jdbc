<%@ page import="model.User" %>
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <%
                User user = (User) request.getAttribute("user");
                String openForm = "<form action=\"%s\" method=\"post\"><caption><h2>%s</h2></caption>";
                String fieldSet = "<fieldset class=\"openForm-group\">\n%s%s\n</fieldset>";
                String label = "<label>%s</label>";
                String input = "<input type=\"text\" value=\"%s\" class=\"openForm-control\" name=\"%s\">";
                String inputRequired = "<input type=\"text\" value=\"%s\" class=\"openForm-control\" name=\"%s\" required=\"required\">";
                String inputHidden = "<input type=\"hidden\" value=\"%s\" class=\"openForm-control\" name=\"%s\" required=\"required\">";
                String button = "<button type=\"submit\" class=\"btn btn-success\">Save</button>";
                String closeForm = "</form>";
                if (user == null) {
                    openForm = String.format(openForm, "insert", "Add New User");
                    String labelName = String.format(label, "User Name");
                    String inputName = String.format(inputRequired, "", "name");
                    String fieldSetName = String.format(fieldSet, labelName, inputName);
                    String labelEmail = String.format(label, "User Email");
                    String inputEmail = String.format(input, "", "email");
                    String fieldSetEmail = String.format(fieldSet, labelEmail, inputEmail);
                    String labelCountry = String.format(label, "User Country");
                    String inputCountry = String.format(input, "", "country");
                    String fieldCountry = String.format(fieldSet, labelCountry, inputCountry);
                    StringBuilder outHtml = new StringBuilder(openForm);
                    outHtml.append(fieldSetName);
                    outHtml.append(fieldSetEmail);
                    outHtml.append(fieldCountry);
                    outHtml.append(button);
                    outHtml.append(closeForm);
                    out.write(outHtml.toString());
                }
                if (user != null) {
                    openForm = String.format(openForm, "update", "Edit User");
                    String inputId = String.format(inputHidden, user.getId(), "id");
                    String labelName = String.format(label, "User Name");
                    String inputName = String.format(inputRequired, user.getName(), "name");
                    String fieldSetName = String.format(fieldSet, labelName, inputName);
                    String labelEmail = String.format(label, "User Email");
                    String inputEmail = String.format(input, user.getEmail(), "email");
                    String fieldSetEmail = String.format(fieldSet, labelEmail, inputEmail);
                    String labelCountry = String.format(label, "User Country");
                    String inputCountry = String.format(input, user.getCountry(), "country");
                    String fieldCountry = String.format(fieldSet, labelCountry, inputCountry);
                    StringBuilder outHtml = new StringBuilder(openForm);
                    outHtml.append(inputId);
                    outHtml.append(fieldSetName);
                    outHtml.append(fieldSetEmail);
                    outHtml.append(fieldCountry);
                    outHtml.append(button);
                    outHtml.append(closeForm);
                    out.write(outHtml.toString());
                }
            %>
        </div>
    </div>
</div>
</body>
</html>