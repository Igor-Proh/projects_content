<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Projects</title>
    <%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>--%>
</head>
<body>
<h1>Projects List</h1>

<br>
<div>
    <table border="3">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Operations</th>
        </tr>

        <jsp:useBean id="projects" scope="request" type="java.util.List"/>
        <c:forEach var="project" items="${projects}">


            <c:url var="updateButton" value="/project/updateProject">
                <c:param name="projectId" value="${project.projectId}"/>
            </c:url>

            <c:url var="deleteButton" value="/project/deleteProject">
                <c:param name="projectId" value="${project.projectId}"/>
            </c:url>


            <tr>
                <td>${project.projectId}</td>
                <td><a href="${project.projectId}">${project.projectName}</a></td>
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
       onclick="window.location.href = '/project/addProject'"/>
<br>
<br>

<input type="button" value="Back"
       onclick="window.location.href = '/'"/>
<br>


</body>

</html>