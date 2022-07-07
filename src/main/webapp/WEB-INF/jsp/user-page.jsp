<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    User
</h2>
<br>

<%--@elvariable id="user" type="aj"--%>
<form:form action="saveUser" modelAttribute="user">

    Name: <form:input path="userName"/>
    <br><br>
    Password: <form:input path="userPassword"/>
    <br><br>
<%--    Enabled: <form:input path="userEnabled"/>--%>
    Enabled: <form:checkbox path="userEnabled"/>
    <br><br>

    <input type="submit" value="Save">
    <input type="button" value="Back"
           onclick="window.location.href = '/user/list'"/>

</form:form>

</body>
</html>