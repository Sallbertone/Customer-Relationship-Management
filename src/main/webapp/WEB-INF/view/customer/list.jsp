<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>CRM System</title>
</head>
<body>


	<section id="viewtable">

	<div id="container">
		<div id="content">

			<input type="button" value="Dodaj klienta"
				onclick="window.location.href='showAddForm'" /> <br> <br>

			<table>
				<tr>
					<th>IMIĘ</th>
					<th>NAZWISKO</th>
					<th>E-MAIL</th>
				</tr>

				<c:forEach var="tempCustomer" items="${customers}">

					<c:url var="updateLink" value="/customer/showUpdateForm">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						
						<td><a href="${updateLink}">Edytuj</a>
						 ||| 
						<td><a href="${deleteLink}">Usuń</a>
					</tr>

				</c:forEach>

			</table>
		</div>

		<!-- Handle "First" and "Prev" links -->
		<c:choose>
			<c:when test="${currentPage == 1}">
				<a href="#" class="disabled">First</a>
				<a href="#" class="disabled">Prev</a>
			</c:when>
			<c:otherwise>
				<c:url var="firstPageLink" value="/customer/list">
					<c:param name="pageNumber" value="1" />
				</c:url>
				<a href="${firstPageLink}">First</a>

				<c:url var="prevPageLink" value="/customer/list">
					<c:param name="pageNumber" value="${currentPage - 1}" />
				</c:url>
				<a href="${prevPageLink}">Prev</a>
			</c:otherwise>
		</c:choose>

		<!-- Handle Page Number links -->
		<c:forEach begin="1" end="${totalCustomerCount}" step="${pageSize}"
			varStatus="loop">
			<c:choose>

				<c:when
					test="${loop.count > (currentPage-5) && loop.count <= (currentPage+5) || (currentPage <= 5 && loop.count <= 10) || totalPages <=10}">

					<c:url var="pageLink" value="/customer/list">
						<c:param name="pageNumber" value="${loop.count}" />
					</c:url>

					<c:choose>
						<c:when test="${loop.count == currentPage}">
							<a href="${pageLink}" class="selected-page">${loop.count}</a>
						</c:when>
						<c:otherwise>
							<a href="${pageLink}">${loop.count}</a>
						</c:otherwise>
					</c:choose>

				</c:when>

			</c:choose>
		</c:forEach>

		<!-- Handle "..." if there are more pages -->
		<c:choose>
			<c:when test="${currentPage < (totalPages-5) && (totalPages > 10)}">
					...
				</c:when>
		</c:choose>

		<!-- Handle "Next" and "Last" links -->
		<c:choose>

			<c:when test="${currentPage == totalPages}">
				<a href="#" class="disabled">Next</a>
				<a href="#" class="disabled">Last</a>
			</c:when>

			<c:otherwise>
				<c:url var="nextPageLink" value="/customer/list">
					<c:param name="pageNumber" value="${currentPage + 1}" />
				</c:url>
				<a href="${nextPageLink}">Next</a>

				<c:url var="lastPageLink" value="/customer/list">
					<c:param name="pageNumber" value="${totalPages}" />
				</c:url>
				<a href="${lastPageLink}">Last</a>
			</c:otherwise>

		</c:choose>

	</div>
	</section>




</body>
</html>
