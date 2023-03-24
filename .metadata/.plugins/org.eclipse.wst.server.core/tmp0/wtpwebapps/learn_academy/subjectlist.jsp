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
<h1>Subject List</h1>
<br>
<sql:setDataSource var="conn"
driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/academy"
user="root" password="Kajol@1995"
/>
<sql:query var="result" dataSource="${conn }">

			select * from subject
</sql:query>


<table border=1 cellSpacing=0 cellpadding=10>
<tr><th>Subject Id</th><th>Subject Name</th><th>class</th><th>Subject Code</th></tr>

<c:forEach items="${result.rows }" var="p"> 

<tr>

<td><c:out value="${p.sub_id }"></c:out></td>
<td><c:out value="${p.sname }"></c:out></td>
<td><c:out value="${p.std}"></c:out></td>
<td><c:out value="${p.sub_code }"></c:out></td>

</tr>

</c:forEach>
</table>

</body>
</html>