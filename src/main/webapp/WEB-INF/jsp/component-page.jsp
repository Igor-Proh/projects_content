<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    Component
</h2>
<br>



<%--@elvariable id="component" type="aj"--%>
<form:form action="saveComponent/${projectId}" modelAttribute="component">

    <form:hidden path="componentId"/>

    Name: <form:input path="componentName"/>
    <br><br>
    Quantity: <form:input path="componentQuantity"/>
    <br><br>
    Description: <form:input path="componentDescription"/>
    <br><br>

    <c:url var="backButton" value="/project/list/${projectId}"/>

    <input type="submit" value="Save"/>

    <input type="button" value="Back"
           onclick="window.location.href = '${backButton}'"/>

</form:form>

</body>
</html>