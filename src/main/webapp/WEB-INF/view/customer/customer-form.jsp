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



			<form:form action="saveCustomer" modelAttribute="customer"	method="POST">

				<table>
					<tbody>
						<tr>
							<td><label>Imię:</label></td>
							<td><form:input path="firstName" />
						</tr>
						<tr>
							<td><label>Nazwisko:</label></td>
							<td><form:input path="lastName" />
						</tr>
						<tr>
							<td><label>E-mail:</label></td>
							<td><form:input path="email" />
						</tr>

					</tbody>
				</table>

				<input type="submit" value="Dodaj" />

			</form:form>


		</div>
	</div>
	</section>




</body>
</html>
