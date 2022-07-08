<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Projects</title>

</head>
<body>
<h1>Projects List</h1>

<br>


<security:authorize access="hasAnyAuthority('ADMIN')">
    <input type="button" value="Add New Project"
           onclick="window.location.href = '/project/addProject'"/>


    <br>
    <br>
</security:authorize>

<form:form action="/project/list/sort/" method="get">
    <i> Sort By:</i>
<select id="dropdown" name="dropdown">
        <option value="id lowest first">Id L-H</option>
        <option value="id highest first">Id H-L</option>
        <option value="name a-z">Name A-Z</option>
        <option value="name z-a">Name Z-A</option>
        <option value="description a-z">Description A-Z</option>
        <option value="description z-a">Description Z-A</option>
        <option value="date lowest first">Date L-H</option>
        <option value="date highest first">Date H-L</option>
</select>
    <input type="submit" value="Sort">
</form:form>

<br>

<div>
    <table border="3">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <security:authorize access="hasAuthority('ADMIN')">
            <th>Operations</th>
            </security:authorize>
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
                <td><fmt:formatDate value="${project.projectDateOfCreate}" pattern="yyyy.MM.dd" /></td>
                <security:authorize access="hasAuthority('ADMIN')">
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