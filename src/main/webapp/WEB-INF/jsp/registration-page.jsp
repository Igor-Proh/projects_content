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
           modelAttribute="userForm" method="post">

<%--    <p>--%>
<%--        Name: <input type="text" name="userName"/>--%>
<%--    </p>--%>

<%--    <p>--%>
<%--        Password: <input type="password" name="userPassword"/>--%>
<%--    </p>--%>
<%--    <p>--%>
<%--        Password: <input type="password" name="userConfirmPassword"/>--%>
<%--    </p>--%>
    Name:
    <br>
    <spring:bind path="userName">

             ${status.error ? 'has-error' : ''}
            <form:input type="text" path="userName"  placeholder="Username"/>
            <form:errors path="userName"/>

    </spring:bind>

    <br>

    Password:
    <br>
    <spring:bind path="userPassword">
         ${status.error ? 'has-error' : ''}
            <form:input type="password" path="userPassword"  placeholder="Password"/>
            <form:errors path="userPassword"/>

    </spring:bind>

    <br>

    Confirm password:
    <spring:bind path="userConfirmPassword">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="userConfirmPassword"
                        placeholder="Confirm your password"/>
            <form:errors path="userConfirmPassword"/>
        </div>
    </spring:bind>
    <br>

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