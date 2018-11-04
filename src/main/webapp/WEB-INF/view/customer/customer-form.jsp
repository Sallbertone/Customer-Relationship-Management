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


<!--   change GET to POST after testing  -->
			<form:form action="confirmCustomer" modelAttribute="customer"	method="GET">

				<table>
					<tbody>
						<tr>
							<td><label>Imię:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><label>Nazwisko:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><label>E-mail:</label></td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td><label>Miasto:</label></td>
							<td><form:input path="customerDetail.city" /></td>
						</tr>
						<tr>
							<td><label>Telefon:</label></td>
							<td><form:input path="customerDetail.phoneNumber" /></td>
						</tr>
						
 					
						<tr>
							<td><label>Data urodzenia:</label></td>
							<td><form:input path="customerDetail.dateOfBirth" /></td>
						</tr>

						
 						<tr>
							<td><label>Opiekun klienta:</label></td>
							<td><form:select path="accountManager">
									<form:option value="NONE" label="--- Wybierz ---" />
									<form:options items="${accountManagersMap}" />
								</form:select></td>
						</tr>
						
<!--
						<tr>
							<td><label>Program lojalnościowy:</label></td>
							<td><form:checkboxes path="programs" items="${loyaltyProgramsMap}"/></td>
						</tr>
-->
					</tbody>
				</table>

				<input type="submit" value="Dodaj" />

			</form:form>


		</div>
	</div>
	</section>




</body>
</html>
