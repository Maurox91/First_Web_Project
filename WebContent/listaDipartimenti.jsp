<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista dei dipartimenti</title>
</head>
<body>
	<form action=listEmployee>
	<c:forEach items="${list}" var="list">
		<input type="radio" value="${list.getNdep()}" name="department">${list.getName()}<br>
	</c:forEach>           
	<input type="submit" value="visualizza"/>
	</form>
	
	<form action=InsertEmp.jsp>      
	<input type="submit" value="inserisci"/>
	</form>
	
</body>
</html>