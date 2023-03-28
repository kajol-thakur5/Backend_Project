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
<h1>Fly Away</h1>
<h4></h4>
<sql:setDataSource var="conn"
driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/fly"
user="root" password="Kajol@1995"
/>

<sql:query var="result" dataSource="${conn }">

			select * from booking ORDER BY bid DESC LIMIT 1;
</sql:query>

<c:forEach items="${result.rows }" var="p"> 
PNR:fly
<c:out value="${p.fid}" ></c:out>
<c:out value="${p.User_uid}"></c:out>
<c:out value="${p.bid}"></c:out>
<sql:query var="resul" dataSource="${conn }">

 select * from air, user, booking where air.aid="${p.fid}" and user.uid="${p.User_uid}" and booking.bid="${p.bid}";
			
</sql:query>

<c:forEach items="${resul.rows }" var="q"> 

<br>
<h4>
<table border=0 cellSpacing=0 cellpadding=10>
<tr>
<td>name: </td><td><c:out value="${q.uname}"></c:out></td></tr>
<tr><td>Flight Name:</td><td><c:out value="${q.aname}"></c:out></td></tr>
<tr><td>To: </td><td><c:out value="${q.desti}"></c:out></td></tr>
<tr><td>From: </td><td><c:out value="${q.arr}"></c:out></td></tr>
<tr><td>DoB: </td><td><c:out value="${q.dob}"></c:out></td></tr>
<tr><td>D_Time: </td><td><c:out value="${q.d_time}"></c:out></td></tr>
<tr><td>A_Time: </td><td><c:out value="${q.a_time}"></c:out></td></tr>
<tr><td>Nop: </td><td><c:out value="${q.nop}"></c:out></td></tr>
<tr><td>Amount paid: </td><td><c:out value="${q.price}"></c:out></td></tr>
<tr><td>Mode: </td><td><c:out value="${q.mode}"></c:out></td></tr>
</table>
</h4>
<h6>Thanks for Using Fly Away Visit Again</h6>
</c:forEach>

</c:forEach>
</body>
</html>