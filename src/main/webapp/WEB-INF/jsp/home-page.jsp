<%@ page import="org.springframework.security.web.authentication.AuthenticationFailureHandler" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="java.security.Principal" %>
<%@ page import="sun.security.acl.PrincipalImpl" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>

<h1>Home Page</h1>
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
<security:authorize access="!isAuthenticated()">

<a type="button" href="${pageContext.request.contextPath}/login">Log in</a>
</security:authorize>
<%--<button onclick=window.location.href='${pageContext.request.contextPath}'>Log In</button>--%>


<%--<form:form action="/login" method="get" >--%>
<%--    <input type="submit" value="Log In">--%>
<%--</form:form>--%>
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