<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>employee details</title>
</head>
<body>

<h5>Enter employee id to get certain employee details</h5>

<c:if test="${notsuccess }">
	<div>No Employee found, try with another emp id</div>
</c:if>
<br>
<br>

<form action="employeedetailsform" method="post">
	Enter Employee emp id:<input type="text" name="id">
	<input type="submit" value="Submit">
</form>

</body>
</html>