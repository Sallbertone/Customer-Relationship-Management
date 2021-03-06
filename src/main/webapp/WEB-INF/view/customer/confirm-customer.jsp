<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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


			<table>
				<tbody>
					<tr>
						<td><label>Imię:</label></td>
						<td>${customer.firstName}</td>
					</tr>
					<tr>
						<td><label>Nazwisko:</label></td>
						<td>${customer.lastName}</td>
					</tr>
					<tr>
						<td><label>E-mail:</label></td>
						<td>${customer.email}</td>
					</tr>
					<tr>
						<td><label>Miasto:</label></td>
						<td>${customer.customerDetail.city}</td>
					</tr>

					<tr>
						<td><label>Telefon:</label></td>
						<td>${customer.customerDetail.phoneNumber}</td>
					</tr>

					<tr>
						<td><label>Data urodzenia:</label></td>
						<td>${customer.customerDetail.dateOfBirth}</td>
					</tr>


					<tr>
						<td><label>Opiekun klienta:</label></td>
						<td>${customer.accountManager.firstName}
							${customer.accountManager.lastName}</td>
					</tr>


					<tr>
						<td><label>Program lojalnościowy:</label></td>
						<td><c:forEach items="${customer.programs}" var="program">
						    		${program.title}   
								</c:forEach></td>

					</tr>

				</tbody>
			</table>

			<br>

			<form action="deleteCustomer" method="GET">
				<input type="hidden" name="customerId" value="${customer.id}"> 
				<input type="submit" value="Usuń klienta">
			</form>



		</div>
	</div>
	</section>




</body>
</html>
