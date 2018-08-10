<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration form</title>
</head>
<body>
<h2 align="center">Employee Registration Form</h2>

<c:if test="${notsuccess}">
<div style="color:red;"> Registration failed, please try again </div>
</c:if>
<form action="registerform" method="post"><br>
Emp id: <input type="text" name="id"><br>
Name: <input type="text" name="name"><br>
age: <input type="text" name="age"><br>
salary: <input type="text" name="salary"><br>
designation: <input type="text" name="designation"><br>

<input type="submit" value="submit">

</form>


</body>
</html>