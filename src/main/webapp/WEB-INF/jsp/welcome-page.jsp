<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>

<style>
    .name {
        color: midnightblue;
    }
</style>

<%
    String s = request.getParameter("userId");
    long parseUserId = Long.parseLong(s);
    String text;
    if (parseUserId == 0){
        text = "created";
    } else {
        text = "updated";
    }
    String name = request.getParameter("userName");
%>

<h2>User with name <i style="color: red"><%= name %></i>   was <i style="color: red"><%= text %></i> !</h2>



<br>
<security:authorize access="hasAnyAuthority('ADMIN')">
    <a href="${pageContext.request.contextPath}/user/list/">List of Users</a>
</security:authorize>

<br>
<a href="${pageContext.request.contextPath}/">Home page</a>

</body>
</html>