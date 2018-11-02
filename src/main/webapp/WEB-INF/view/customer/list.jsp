<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>CRM System</title>
</head>
<body>


<section id="viewtable">
	<div class="container">
		<div id="result">

		<input type="button" value="Dodaj klienta"	onclick="window.location.href='showAddForm'" />		
		
		<br>
		<br>
		
			<table>
				<tr>
					<th>IMIĘ</th>
					<th>NAZWISKO</th>
					<th>E-MAIL</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${customers}">
		
				<tr>
					<td> ${tempCustomer.firstName} </td>
					<td> ${tempCustomer.lastName} </td>
					<td> ${tempCustomer.email} </td>
				</tr>
		
				</c:forEach>
					
			</table>
		</div>
	</div>
</section>




</body>
</html>
