<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
    <title>Registration</title>

    <style>
        .failed{
            color: red;
        }
    </style>

</head>

<body>
<h3>Registration Form</h3>



<%--@elvariable id="userForm" type="com"--%>

<form:form action="/user/saveUser"
           modelAttribute="userForm">

<%--    <p>--%>
<%--        Name: <input type="text" name="userName"/>--%>
<%--    </p>--%>
Name:
    <spring:bind path="userName">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="userName"  placeholder="Username"/>
            <form:errors path="userName"/>
        </div>
    </spring:bind>

    <p>
        Password: <input type="password" name="userPassword"/>
    </p>
    <c:if test="${param.error!=null}">

        <i class="failed">Sorry! You entered invalid username/password.</i>

    </c:if>
    <p>
        Password: <input type="password" name="userConfirmPassword"/>
    </p>



    <input type="submit" value="Create User"/>

</form:form>

<security:authorize access="!isAuthenticated()">
    <input type="button" value="Back"
           onclick="window.location.href='/'"/>

</security:authorize>
<security:authorize access="isAuthenticated()">
    <input type="button" value="Back"
           onclick="window.location.href='/user/list'"/>

</security:authorize>


</body>

</html>