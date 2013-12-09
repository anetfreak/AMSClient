<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - Issue Ticket</title>

<%@include file="includes.jsp" %>

</head>
<body>
<%@include file="header.jsp" %>
	<div>
		<div style = "padding: 20px;">
			<div>
				<span><h3>Itinerary and Reservation Details</h3></span>
<%-- 				<c:if test="${res ne null}"> --%>
<%-- 					<p><b>Reservation Id : ${reservation.reservationId}</b></p> --%>
<%-- 					<p><b>Reservation Number : ${reservation.reservationNo}</b></p> --%>
<%-- 				</c:if> --%>
			</div>
			<div style = "padding-top: 10px;">
				<p><b>Customer Info</b></p>
				<table border = "1">
					<tr style = "text-align: center;">
					<td style = "width: 250px;"><b>ID</b></td>
						<td style = "width: 250px;"><b>First Name</b></td>
						<td style = "width: 250px;"><b>Last Name</b></td>
						<td style = "width: 250px;"><b>Email</b></td>
						<td style = "width: 250px;"><b>Address</b></td>
						<td style = "width: 250px;"><b>Nationality</b></td>
					</tr>
					<tr style = "text-align: center;">
					<c:if test="${customer ne null}">
						<td>${customer.customerId}</td>
						<td>${customer.person.firstName}</td>
						<td>${customer.person.lastName}</td>
						<td>${customer.person.username}</td>
						<td>${customer.person.address}</td>
						<td>${customer.nationality}</td>
					</c:if>
					</tr>
				</table>
			</div>
			<div style = "padding-top: 30px;">
				<p><b>Travellers' Info</b></p>
				<table border = "1">
					<tr style = "text-align:center;">
						<td style = "width: 250px;"><b>First Name</b></td>
						<td style = "width: 250px;"><b>Last Name</b></td>
						<td style = "width: 250px;"><b>Age</b></td>
						<td style = "width: 250px;"><b>Gender</b></td>
					</tr>
					<tr style = "text-align:center;">
						<td><c:forEach items="${res.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.firstName}
									<br>
								</c:if>
							</c:forEach>
						</td>
						<td><c:forEach items="${res.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.lastName}
									<br>
								</c:if>
							</c:forEach>
						</td>
						<td><c:forEach items="${res.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.age}
									<br>
								</c:if>
							</c:forEach>
						</td>
						<td><c:forEach items="${res.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.sex}
									<br>
								</c:if>
							</c:forEach>
						</td>
					</tr>
				</table>
			</div>
			<div style = "padding-top: 30px;">
				<p><b>Flight Info</b></p>
				<table border = "1">
					<tr style = "text-align:center;">
						<td style = "width: 250px;"><b>Departure</b></td>
						<td style = "width: 250px;"><b>Arrival</b></td>
						<td style = "width: 250px;"><b>Flight Number</b></td>
						<td style = "width: 250px;"><b>Flight Time</b></td>
						<td style = "width: 250px;"><b>Aircraft</b></td>
					</tr>
					<c:if test="${flights ne null}">
					<c:forEach items="${flights}" var="flight">
					<tr style = "text-align:center;">
						<td>${flight.source}</td>
						<td>${flight.destination}</td>
						<td>${flight.flightNo}</td>
						<td>${flight.flightTime}</td>
						<td>${flight.airlineName}</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
			</div>
			<div>
				<%@include file="footer.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>
