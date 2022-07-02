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

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${projects}" var="project">
            <tr>
                <td>${project.projectId} </td>
                <td><a href="">${project.projectName}</a></td>
                <td>${project.projectDescription}</td>
                <td>${project.projectDateOfCreate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="/">Back</a>


</body>

</html>