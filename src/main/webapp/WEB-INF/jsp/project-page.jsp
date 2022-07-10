<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project</title>

    <style>
        .failed {
            color: red;
        }
    </style>

</head>
<body>
<h2>
    Project
</h2>
<br>


<%--@elvariable id="project" type="com"--%>
<form:form action="addProject" modelAttribute="project">

    <form:hidden path="projectId"/>

    Project name: <form:input type="text" path="projectName" placeholder = "Enter project name"/><br>
    <i> <form:errors cssClass="failed" path="projectName"/><br></i>
    <br>
    Description: <form:input type = "text" path="projectDescription" placeholder ="Enter description"/>
    <br><br>

    <input type="submit" value="Save">
    <input type="button" value="Back"
           onclick="window.location.href = '/project/list/'"/>

</form:form>

</body>
</html>