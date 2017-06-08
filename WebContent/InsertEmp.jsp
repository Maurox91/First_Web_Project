<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista dei dipendenti</title>
</head>
<body>
<form action=InsertEmployee> 
	
	<br><b>Inserisci un nuovo dipendente:</b>
	    <p>
	    Id: <input type="text" name="emp_no">
	    </p>
	    <p>
        Data di nascita: <input type="text" name="birth_date">   
        </p>
        <p>
        Nome: <input type="text" name="first_name">
        </p>
        <p>
        Cognome: <input type="text" name="last_name">
        </p>
        <p>
        Data: <input type="text" name="hire_date">
        </p>
        <p>
        Genere: <input type="text" name="gender">
        </p>
        <p>
        Nome dipartimento: <input type="text" name="nameDp">
        </p>
        <p>
        Data di assunzione: <input type="text" name="dataIns">
        </p>
        
    <input type="submit" value="Inserisci"> 
           
</form>
</body>
</html>