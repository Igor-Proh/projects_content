<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Form</title>

    <style>
        .failed{
            color: red;
        }
    </style>
</head>

<body>
<h3>Please Sign In</h3>



<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
           method="post">

    <!-- Check for login error -->
    <c:if test="${param.error!=null}">

        <i class="failed">Sorry! You entered invalid username/password.</i>

    </c:if>

    <p>
        User name: <input type="text" name="username"/>
    </p>

    <p>
        Password: <input type="password" name="password"/>
    </p>


    <input type="submit" value="Sign in"/>
<%--    <input type="button" value="Registration"--%>
<%--           onclick="window.location.href='/user/registration'"/>--%>
    <input type="button" value="Home Page"
           onclick="window.location.href='/'"/>

</form:form>


</body>

</html>