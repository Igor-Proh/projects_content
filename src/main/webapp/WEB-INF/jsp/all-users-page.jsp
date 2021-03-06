<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>

    <meta charset="UTF-8"/>

    <title>Users List</title>
</head>
<body>
<h1>Users List</h1>

<br>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Password</th>
            <th>Enabled</th>
            <th>Roles</th>
            <th>Operations</th>
        </tr>

        <c:forEach var="user" items="${user}" >


            <c:url var="updateButton" value="/user/updateUser">
                <c:param name="userId" value="${user.userId}"/>
            </c:url>

            <c:url var="deleteButton" value="/user/deleteUser">
                <c:param name="userId" value="${user.userId}"/>
            </c:url>


            <tr>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.userPassword}</td>
                <td>${user.userEnabled}</td>
                <td>${user.listOfRoles}</td>
                <td>
                    <input type="button" value="Update"
                           onclick="window.location.href='${updateButton}'"/>
                    <input type="button" value="Delete"
                           onclick="window.location.href='${deleteButton}'"/>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>

<br>
<input type="button" value="Add New User"
       onclick="window.location.href = '/user/registration'"/>
<br>
<br>

<input type="button" value="Back"
       onclick="window.location.href = '/'"/>
<br>


</body>

</html>