<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>

<h2>Employee List</h2>

<a href="${pageContext.request.contextPath}/new">Add Employee</a>

<br/><br/>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.department}</td>
            <td>
                <a href="${pageContext.request.contextPath}/edit/${emp.id}">Edit</a>
                |
                <a href="${pageContext.request.contextPath}/delete/${emp.id}"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>