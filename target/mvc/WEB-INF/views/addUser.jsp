<%--
  Created by IntelliJ IDEA.
  User: dianamohanu
  Date: 11/07/2016
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>

<h1>
    Add new user
</h1>
<form action="adduser" method="post">
    First name:
    <br>
    <input type="text" name="firstname">
    <br>
    Last name:
    <br>
    <input type="text" name="lastname">
    <br>
    </br>
    <input type="submit" value="Submit">
</form>

<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>

</body>
</html>
