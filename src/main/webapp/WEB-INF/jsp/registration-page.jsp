<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<form:form action="/user/registration"
           method="post" modelAttribute="userForm">

<%--    <p>--%>
<%--        Name: <input type="text" name="userName"/>--%>
<%--    </p>--%>

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
    <br>
    <br>
    <input type="button" value="Back"
           onclick="window.location.href='/login'"/>

</form:form>


</body>

</html>