<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>

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

<%!
    public String myString = "Bob";
%>
 User with name <%= name %>  was <%= text %>!



<br>
<security:authorize access="hasAnyAuthority('ADMIN')">
    <a href="${pageContext.request.contextPath}/user/list/">List of Users</a>
</security:authorize>

<br>
<a href="${pageContext.request.contextPath}/">Home page</a>

</body>
</html>