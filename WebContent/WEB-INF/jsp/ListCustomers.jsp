<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - List Customers</title>
<%@include file="includes.jsp" %>
</head>
<body>
	<%@include file="header.jsp" %>
	<div id="container" style="padding-top: 40px;" align="center">
		<table class="table table-bordered table-striped" border="1">
			<tr>
				<td><B>First Name</B></td>
				<td><B>Last Name</B></td>
				<td><B>Address</B></td>
				<td><B>City</B></td>
				<td><B>State</B></td>
				<td><B>Zip Code</B></td>
				<td><B>User Name</B></td>
				<td><B>Passport No.</B></td>
				<td><B>SSN</B></td>
				<td><B>Nationality</B></td>
				<td><B>DOB</B></td>
			</tr>
			<c:if test="${Customers ne null}">
				<c:forEach items="${Customers}" var="customer">
					<tr>
						<c:if test="${customer ne null}">
						<td>${customer.person.firstName}</td>
							<td>${customer.person.lastName}</td>
							<td>${customer.person.address}</td>
							<td>${customer.person.city}</td>
							<td>${customer.person.state}</td>
							<td>${customer.person.zip}</td>
							<td>${customer.person.username}</td>
							<td>${customer.passportNumber}</td>
							<td>${customer.customerId}</td>
							<td>${customer.nationality}</td>
							<td>${customer.person.DOB}</td>
							<td><div class="col-sm-offset-2 col-sm-10">
									<a href="/AMSClient/deleteCustomer/${customer.customerId}.htm" class="btn btn-default" 
									id="deleteCustomer" name="deleteCustomer">Delete Customer</a>
								</div></td>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</table>


	</div>
<%@include file="footer.jsp" %>
</body>
</html>
