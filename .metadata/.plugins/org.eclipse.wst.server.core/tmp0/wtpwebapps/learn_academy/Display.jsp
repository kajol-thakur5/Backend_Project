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
<h1>Class Report</h1>
<sql:setDataSource var="conn"
driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/academy"
user="root" password="Kajol@1995"
/>


<sql:query var="result" dataSource="${conn }">
 select sb.std, ct.ctime, sb.sname,sb.sub_code, t.tname, s.name  from  class_table  ct ,student  s , subject sb, teacher t where ct.cid=s.ct_cid and ct.cid=sb.ct_cid and ct.cid=t.ct_cid
</sql:query>


<table border=1 cellSpacing=0 cellpadding=10>
<tr><th>Class</th> <th>Class Time</th> <th>Subject Name</th> <th>Teacher Name </th><th>Teacher Id</th><th>Student Name</th></tr>

<c:forEach items="${result.rows }" var="p"> 

<tr>

<td><c:out value="${p.std }"></c:out></td>
<td><c:out value="${p.ctime }"></c:out></td>
<td><c:out value="${p.sname}"></c:out></td>
<td><c:out value="${p.sub_code }"></c:out></td>
<td><c:out value="${p.tname}"></c:out></td>
<td><c:out value="${p.name }"></c:out></td>
</tr>

</c:forEach>
</table>


</body>
</html>