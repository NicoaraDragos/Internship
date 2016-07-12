<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Hello world!
</h1>

<P> The time on the server is ${serverTime}. </P>


<c:if test="${not empty users}">
    <h3>Users</h3>

    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Fist name</th>
            <th>Last name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${not empty addresses}">
    <h3>Addresses </h3>

    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Street</th>
            <th>Number</th>
            <th>Type</th>
            <th>User_id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="address" items="${addresses}">
            <tr>
                <td>${address.id}</td>
                <td>${address.street}</td>
                <td>${address.number}</td>
                <td>${address.type}</td>
                <td>${address.user.id}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<h3>Delivery addresses for a given user </h3>

<form action="" method="post">
    Name:
    <br>
    <input type="number" name="user">
    <br>
    </br>
    <input type="submit" value="Submit">
</form>

<c:if test="${not empty addresses2}">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Street</th>
            <th>Number</th>
            <th>Type</th>
            <th>User_id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="address" items="${addresses2}">
            <tr>
                <td>${address.id}</td>
                <td>${address.street}</td>
                <td>${address.number}</td>
                <td>${address.type}</td>
                <td>${address.user.id}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
