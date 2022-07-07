<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>

<h1>Projects Content</h1>

<br>
<security:authorize access="hasAnyAuthority('ADMIN','USER')">
<a href="${pageContext.request.contextPath}/project/list/">List of Projects (for Everyone)</a>

<br>
<br>
</security:authorize>
<security:authorize access="hasAuthority('ADMIN')">
<%--<security:authorize access="hasRole('ADMIN')">--%>
<a href="${pageContext.request.contextPath}/user/list">List of Users (for Admin)</a>

<br>
<br>
<br>
<br>
</security:authorize>

<a type="button" href="${pageContext.request.contextPath}/login">Log in</a>

<%--<button onclick=window.location.href='${pageContext.request.contextPath}'>Log In</button>--%>


<%--<form:form action="/login" method="get" >--%>
<%--    <input type="submit" value="Log In">--%>
<%--</form:form>--%>
<br>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Log Out">
</form:form>

<br>
<a href="${pageContext.request.contextPath}/user/registration">Add user</a>
<br>
<br>

</body>

</html>