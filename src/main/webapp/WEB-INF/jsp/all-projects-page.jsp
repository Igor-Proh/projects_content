<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Person List</title>
    <%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>--%>
</head>
<body>
<h1>Projects List</h1>

<br>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Operations</th>
        </tr>
        <c:forEach items="${projects}" var="project">

<%--            <c:url var="updateButton" value="/updateInfo">--%>
<%--                <c:param name="empId" value="${emp.id}"/>--%>
<%--            </c:url>--%>
<%----%>
<%--            <c:url var="deleteButton" value="/deleteEmployee">--%>
<%--                <c:param name="empId" value="${emp.id}"/>--%>
<%--            </c:url>--%>


            <tr>
                <td>${project.projectId} </td>
                <td><a href="">${project.projectName}</a></td>
                <td>${project.projectDescription}</td>
                <td>${project.projectDateOfCreate}</td>
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
<input type="button" value="Add New Project"
       onclick="window.location.href = '/com_spring_mvc_hb_aop/addNewEmployee'"/>
<br>
<br>

<input type="button" value="Back"
       onclick="window.location.href = '/'"/>
<br>


</body>

</html>