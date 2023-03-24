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
<h1>Teacher List</h1><br>

<sql:setDataSource var="conn"
driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/academy"
user="root" password="Kajol@1995"
/>

<sql:query var="result" dataSource="${conn }">

			select * from teacher
</sql:query>
<table border=1 cellSpacing=0 cellpadding=10>
<tr><th>Teacher Id</th><th>Teacher Name </th><th>Email Id</th><th>Gender</th><th>Mobile no</th></tr>

<c:forEach items="${result.rows }" var="p"> 

<tr>

<td><c:out value="${p.tid }"></c:out></td>
<td><c:out value="${p.tname }"></c:out></td>
<td><c:out value="${p.email}"></c:out></td>
<td><c:out value="${p.gender }"></c:out></td>
<td><c:out value="${p.mob}"></c:out></td>


</tr>

</c:forEach>
</table>


</body>
</html>