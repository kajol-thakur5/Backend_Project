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
<h1>Flight List</h1><br><br>

<sql:setDataSource var="conn"
driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/fly"
user="root" password="Kajol@1995"
/>
<sql:query var="result" dataSource="${conn }">
select * from air
</sql:query>
<table border=1 cellSpacing=0 cellpadding=10>
<tr><th>ID</th> <th>Name of Flight</th> <th>Dest</th> <th>Arr</th><th>D.Time</th><th>A.Time</th><th>Price</th><th>Capacity</th><th>Mode
</th></tr>

<c:forEach items="${result.rows }" var="p"> 

<tr>

<td><c:out value="${p.aid }"></c:out></td>
<td><c:out value="${p.aname }"></c:out></td>
<td><c:out value="${p.desti}"></c:out></td>
<td><c:out value="${p.arr }"></c:out></td>
<td><c:out value="${p.d_time}"></c:out></td>
<td><c:out value="${p.a_time}"></c:out></td>
<td><c:out value="${p.price}"></c:out></td>
<td><c:out value="${p.capacity}"></c:out></td>
<td><c:out value="${p.mode}"></c:out></td>
</tr>

</c:forEach>
</table>


</body>
</html>