<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    User
</h2>
<br>

<form:form action="saveComponent" modelAttribute="component">

    <form:hidden path="userId"/>

    Name: <form:input path="componentName"/>
    <br><br>
    Quantity: <form:input path="componentQuantity"/>
    <br><br>
    Description: <form:input path="componentDescription"/>
    <br><br>

    <input type="submit" value="Save">
<%--    <button href="/project/list/">Back</button>--%>

</form:form>

</body>
</html>