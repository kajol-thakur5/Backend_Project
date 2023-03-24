<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student List</h1>
<br>
<sql:setDataSource var="conn"
driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/academy"
user="root" password="Kajol@1995"
/>

<sql:query var="result" dataSource="${conn }">

			select * from student
</sql:query>
<table border=1 cellSpacing=0 cellpadding=10>
<tr><th>Student Id</th> <th>Name</th><th>Class</th><th>Gender</th><th>Date Of Birth</th></tr>

<c:forEach items="${result.rows }" var="p"> 

<tr>

<td><c:out value="${p.sid}"></c:out></td>
<td><c:out value="${p.name}"></c:out></td>
<td><c:out value="${p.std}"></c:out></td>
<td><c:out value="${p.gender }"></c:out></td>
<td><c:out value="${p.dob}"></c:out></td>

</tr>

</c:forEach>
</table>


</body>
</html>