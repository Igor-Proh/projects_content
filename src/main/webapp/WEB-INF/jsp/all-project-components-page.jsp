<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Components List</title>
    <%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>--%>
</head>
<body>
<h1>Components List</h1>

<br>
<div>
    <table border="3">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Description</th>
            <th>Date</th>
            <th>Operations</th>
        </tr>

        <jsp:useBean id="components" scope="request" type="java.util.List"/>
        <c:forEach var="component" items="${components}">


            <c:url var="updateButton" value="/component/updateComponent">
                <c:param name="componentId" value="${component.componentId}"/>
            </c:url>

            <c:url var="deleteButton" value="/component/deleteComponent">
                <c:param name="componentId" value="${component.componentId}"/>
            </c:url>


            <tr>
                <td>${component.componentId}</td>
                <td>${component.componentName}</td>
                <td>${component.componentQuantity}</td>
                <td>${component.componentDescription}</td>
                <td>${component.componentDateOfCreate}</td>

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
<input type="button" value="Add New Component"
       onclick="window.location.href = '/component/addComponent'"/>
<br>
<br>

<input type="button" value="Back"
       onclick="window.location.href = '${pageContext.request.contextPath}/project/list'"/>
<br>


</body>

</html>