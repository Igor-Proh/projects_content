<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <title>Home page</title>
</head>
<body>

<h1>Home Page</h1>
<br>
<security:authorize access="hasAnyAuthority('ADMIN','USER')">
<a href="${pageContext.request.contextPath}/project/list/">List of Projects (for Everyone)</a>
    <br><br>
</security:authorize>

<security:authorize access="hasAuthority('ADMIN')">
<a href="${pageContext.request.contextPath}/user/list">List of Users (for Admin)</a>
<br><br><br><br>
</security:authorize>

<security:authorize access="!isAuthenticated()">
    <a type="button" href="${pageContext.request.contextPath}/login">Log in</a>
</security:authorize>

<br>

<security:authorize access="hasAnyAuthority('ADMIN','USER')">
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Log Out">
    </form:form>
</security:authorize>

<security:authorize access="!isAuthenticated()">
    <br>
    <a href="${pageContext.request.contextPath}/user/registration">Registration</a>
</security:authorize>

</body>
</html>