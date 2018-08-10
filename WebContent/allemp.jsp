<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow"> 
<center>
<table style="width:50%"></center>
</center>
<h1 style="background-color:red;">Employee Details</h1></center>

<c:forEach items="${list }" var="Employee"><center>
 <tr><center>      
 <td>${Employee.id}</td>
 <td>${Employee.name}</td>
 <td>${Employee.age}</td>
 <td>${Employee.salary}</td>
 <td>${Employee.designation}</td>  
 </tr>
</c:forEach>
</center>
</table>
</body>
</html>