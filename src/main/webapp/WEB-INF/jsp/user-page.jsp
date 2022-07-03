<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    User
</h2>
<br>

<form:form action="saveUser" modelAttribute="user">

    <form:hidden path="userId"/>

    Name: <form:input path="userName"/>
    <br><br>
    Surname: <form:input path="userSurname"/>
    <br><br>
    Email: <form:input path="userEmail"/>
    <br><br>
    Is Active: <form:checkbox path="userIsActive"/>
    <br><br>

    <input type="submit" value="Save">
    <button href="/project/list/">Back</button>

</form:form>

</body>
</html>