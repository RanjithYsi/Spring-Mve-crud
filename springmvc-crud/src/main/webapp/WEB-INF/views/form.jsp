<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>

<h2>Add Employee</h2>

<form action="${pageContext.request.contextPath}/save" method="post">

    Name:<br/>
    <input type="text" name="name" required/><br/><br/>

    Email:<br/>
    <input type="email" name="email" required/><br/><br/>

    Department:<br/>
    <input type="text" name="department" required/><br/><br/>

    <input type="submit" value="Save"/>

</form>

<br/>
<a href="${pageContext.request.contextPath}/">Back to List</a>

</body>
</html>