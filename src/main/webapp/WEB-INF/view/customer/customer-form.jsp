<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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
			<form:form action="confirmCustomer" modelAttribute="customer"
				method="GET">

				<form:hidden path="id" />

				<table>
					<tbody>
						<tr>
							<td><label>Imię:</label></td>
							<td><form:input path="firstName" />
								<form:errors path="firstName"/></td>
						</tr>
						<tr>
							<td><label>Nazwisko:</label></td>
							<td><form:input path="lastName" />
								<form:errors path="lastName"/></td>
						</tr>
						<tr>
							<td><label>E-mail:</label></td>
							<td><form:input path="email" />
								<form:errors path="email"/></td>
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

									<c:choose>
										<c:when test="${customer.accountManager.id >= 1}">
											<form:option selected="true"
												value="${customer.accountManager.id}"
												label="${customer.accountManager.firstName} ${customer.accountManager.lastName}" />
											<form:options items="${accountManagersMap}" />
										</c:when>

										<c:otherwise>
											<form:option value="" label="--- Wybierz ---" />
											<form:options items="${accountManagersMap}" />
										</c:otherwise>

									</c:choose>
								</form:select>
								<form:errors path="accountManager"/></td>
						</tr>


						<tr>
							<td><label>Program lojalnościowy:</label></td>


							<td><c:choose>
									<c:when test="${empty programsIDs}">
										<form:checkboxes items="${loyaltyProgramsMap}" path="programs" />
									</c:when>
									<c:otherwise>
										<c:forEach var="tempProg" items="${loyaltyProgramsMap}">
											<spring:eval var="containsValue"
												expression="programsIDs.contains(${tempProg.key})" />
											<form:checkbox path="programs" value="${tempProg.key}"
												label="${tempProg.value}"
												checked="${containsValue ? 'checked':''}" />
										</c:forEach>
									</c:otherwise>
								</c:choose></td>
						</tr>


					</tbody>
				</table>

				<input type="submit" value="Zapisz" />

			</form:form>


		</div>
	</div>
	</section>




</body>
</html>
