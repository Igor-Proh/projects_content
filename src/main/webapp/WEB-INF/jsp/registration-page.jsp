<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
    <title>Registration</title>

    <style>
        .failed {
            color: red;
        }
    </style>

</head>

<body>
<h3>Registration Form</h3>

<%--@elvariable id="userForm" type="com"--%>
<form:form action="/user/registration"
           modelAttribute="userForm" >


    Username(*):

    <spring:bind path="userName">

        <form:input type="text" path="userName" placeholder="Username"/><br>
        <i> <form:errors cssClass="failed" path="userName"/></i>
    </spring:bind>

    <br><br>
    Password(*):

    <spring:bind path="userPassword">

        <form:input type="password" path="userPassword" placeholder="Password"/><br>
        <i><form:errors cssClass="failed" path="userPassword"/></i>
    </spring:bind>

    <br><br>
    Password(*):
    <spring:bind path="userConfirmPassword">
        <form:input type="password" path="userConfirmPassword"
                    placeholder="Confirm your password"/><br>
        <i><form:errors cssClass="failed" path="userConfirmPassword"/></i>
    </spring:bind>
    <br><br>
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