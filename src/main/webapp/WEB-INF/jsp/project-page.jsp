<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    Project
</h2>
<br>

<form:form action="saveProject" modelAttribute="project">

    <form:hidden path="projectId"/>

    Name: <form:input path="projectName"/>
    <br><br>
    Description: <form:input path="projectDescription"/>
    <br><br>

    <input type="submit" value="Save">
    <button href="/project/list/">Back</button>

</form:form>

</body>
</html>