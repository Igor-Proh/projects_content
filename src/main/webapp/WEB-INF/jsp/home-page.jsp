<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<body>

<h1>Projects Content</h1>

<br>
<a href="${pageContext.request.contextPath}/project/list/">List of Projects (for Everyone)</a>
<br>
<br>
<security:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath}/user/list">List of Users (for Admin)</a>
</security:authorize>
<br>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/login">Log in</a>
<br>
<a href="${pageContext.request.contextPath}/logout">Log out</a>
<br>
<a href="${pageContext.request.contextPath}/user/addUser">Add user</a>
<br>
<br>

</body>

</html>