<%--
  Created by IntelliJ IDEA.
  User: dianamohanu
  Date: 12/07/2016
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>

<h1>
    Delete user
</h1>
<form action="deleteuser" method="post">
    Id:
    <br>
    <input type="number" name="id">
    <br>
    </br>
    <input type="submit" value="Submit">
</form>

<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>

</body>
</html>
