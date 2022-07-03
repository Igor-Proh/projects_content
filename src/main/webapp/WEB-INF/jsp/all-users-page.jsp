<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Users List</title>
    <%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>--%>
</head>
<body>
<h1>Users List</h1>

<br>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
<%--            <th>Role</th>--%>
            <th>Is Active</th>
            <th>Operations</th>
        </tr>
<%--        <jsp:useBean id="projects" scope="request" type="java.util.List"/>--%>

        <c:forEach var="user" items="${users}" >


            <c:url var="updateButton" value="/user/updateUser">
                <c:param name="userId" value="${user.userId}"/>
            </c:url>

            <c:url var="deleteButton" value="/user/deleteUser">
                <c:param name="userId" value="${user.userId}"/>
            </c:url>


            <tr>
                <td>${user.userId} </td>
                <td>${user.userName}</td>
                <td>${user.userSurname}</td>
                <td>${user.userEmail}</td>
<%--                <td>${user.userRole}</td>--%>
                <td>${user.userIsActive}</td>
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
       onclick="window.location.href = '/user/addUser'"/>
<br>
<br>

<input type="button" value="Back"
       onclick="window.location.href = '/'"/>
<br>


</body>

</html>