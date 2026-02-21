<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>

<h2>Edit Employee</h2>

<form action="${pageContext.request.contextPath}/update" method="post">

    <input type="hidden" name="id" value="${employee.id}"/>

    Name:<br/>
    <input type="text" name="name" value="${employee.name}" required/><br/><br/>

    Email:<br/>
    <input type="email" name="email" value="${employee.email}" required/><br/><br/>

    Department:<br/>
    <input type="text" name="department" value="${employee.department}" required/><br/><br/>

    <input type="submit" value="Update"/>

</form>

<br/>
<a href="${pageContext.request.contextPath}/">Back to List</a>

</body>
</html>