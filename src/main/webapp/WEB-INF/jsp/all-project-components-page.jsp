<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html>
<head>

    <meta charset="UTF-8"/>
    <title>Components</title>

</head>
<body>
<h2>Components List</h2>

<h1>${nameOfProject}</h1>

<c:url var="addButton" value="/components/addComponent">
    <c:param name="projectId" value="${id}"/>
</c:url>

<input type="button" value="Add New Component"
       onclick="window.location.href = '${addButton}'"/>
<br><br>

<div>
    <table border="3">
        <tr>
            <th>Name</th>
            <th>Quantity</th>
            <th>Description</th>
            <th>Date</th>
            <th>Operations</th>
        </tr>

        <jsp:useBean id="components" scope="request" type="java.util.List"/>

        <c:forEach var="component" items="${components}">

            <c:url var="updateButton" value="/components/updateComponent">
                <c:param name="componentId" value="${component.componentId}"/>
                <c:param name="projectId" value="${id}"/>
            </c:url>

            <c:url var="deleteButton" value="/components/deleteComponent">
                <c:param name="componentId" value="${component.componentId}"/>
                <c:param name="projectId" value="${id}"/>
            </c:url>

            <tr>
                <td>${component.componentName}</td>
                <td>${component.componentQuantity}</td>
                <td>${component.componentDescription}</td>
                <td><fmt:formatDate value="${component.componentDateOfCreate}" pattern="yyyy.MM.dd" /></td>
                <td>

                    <input type="button" value="Update"
                           onclick="window.location.href='${updateButton}'" />
                    <input type="button" value="Delete"
                           onclick="window.location.href='${deleteButton}'"/>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<br>

<input type="button" value="Back"
       onclick="window.location.href = '${pageContext.request.contextPath}/project/list'"/>
<br>

</body>
</html>