<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
            <security:authorize access="hasRole('ADMIN')">
            <th>Operations</th>
            </security:authorize>
        </tr>

        <jsp:useBean id="projects" scope="request" type="java.util.List"/>

        <security:authorize access="hasRole('ADMIN')">
            <input type="button" value="Add New Project"
                   onclick="window.location.href = '/project/addProject'"/>
        </security:authorize>

        <br>
        <br>

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
                <td><fmt:formatDate value="${project.projectDateOfCreate}" pattern="yyyy.MM.dd" /></td>
                <security:authorize access="hasRole('ADMIN')">
                <td>
                    <input type="button" value="Update"
                           onclick="window.location.href='${updateButton}'"/>
                    <input type="button" value="Delete"
                           onclick="window.location.href='${deleteButton}'"/>
                </td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
</div>
<br>

<input type="button" value="Back"
       onclick="window.location.href = '/'"/>
<br>


</body>

</html>