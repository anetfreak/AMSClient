<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - List Customers</title>
</head>
<body>

	<div id="container" style="padding-top: 40px;" align="center">
		<table class="table table-bordered table-striped" border="1">
			<tr>
				<td><BR>Customer Id</td>
				<td><BR>Nationality</td>
				<td><BR>PassportNumber</td>
				<td><BR>First Name</td>
				<td><BR>Last Name</td>
				<td><BR>DOB</td>
				<td><BR>Address</td>
				<td><BR>City</td>
				<td><BR>State</td>
				<td><BR>Zip Code</td>
				<td><BR>Username</td>
				
			</tr>
			<c:if test="${Customers ne null}">
				<c:forEach items="${Customers}" var="customer">
					<tr>
						<c:if test="${customer ne null}">
							<td>${customer.customerId}</td>
							<td>${customer.nationality}</td>
							<td>${customer.passportNumber}</td>
							<td>${customer.person.firstName}</td>
							<td>${customer.person.lastName}</td>
							<td>${customer.person.DOB}</td>
							<td>${customer.person.address}</td>
							<td>${customer.person.city}</td>
							<td>${customer.person.state}</td>
							<td>${customer.person.zip}</td>
							<td>${customer.person.username}</td>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</table>


	</div>

</body>
</html>
