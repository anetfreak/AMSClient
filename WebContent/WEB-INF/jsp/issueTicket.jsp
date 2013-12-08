<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<c:if test="${Reservations ne null}" var = "reservation">
					<p><b>Reservation Id : ${reservation.reservationId}</b></p>
					<p><b>Reservation Number : ${reservation.reservationNo}</b></p>
				</c:if>
			</div>
			<div style = "padding-top: 10px;">
				<p><b>Customer Info</b></p>
				<table border = "1">
					<tr style = "text-align: center;">
					<td style = "width: 250px;"><b>ID</b></td>
						<td style = "width: 250px;"><b>First Name</b></td>
						<td style = "width: 250px;"><b>Last Name</b></td>
						<td style = "width: 250px;"><b>Email</b></td>
						<td style = "width: 250px;"><b>Gender</b></td>
						<td style = "width: 250px;"><b>Address</b></td>
						<td style = "width: 250px;"><b>Nationality</b></td>
					</tr>
					<tr style = "text-align: center;">
					<c:if test="${customer ne null}" var = "customer">
						<td>${customer.customerId}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>${customer.sex}</td>
						<td>${customer.address}</td>
						<td>${customer.nationality}</td>
					</c:if>
					</tr>
				</table>
			</div>
			<div style = "padding-top: 30px;">
				<p><b>Travellers' Info</b></p>
				<table border = "1">
					<tr style = "text-align:center;">
						<td style = "width: 250px;"><b>Traveller ID</b></td>
						<td style = "width: 250px;"><b>First Name</b></td>
						<td style = "width: 250px;"><b>Last Name</b></td>
						<td style = "width: 250px;"><b>Age</b></td>
						<td style = "width: 250px;"><b>Gender</b></td>
					</tr>
					<tr style = "text-align:center;">
						<td><c:forEach items="${Reservations.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.travellerId}
									<br>
								</c:if>
							</c:forEach>
						</td>
						<td><c:forEach items="${Reservations.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.firstName}
									<br>
								</c:if>
							</c:forEach>
						</td>
						<td><c:forEach items="${Reservations.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.lastName}
									<br>
								</c:if>
							</c:forEach>
						</td>
						<td><c:forEach items="${Reservations.travellers}" var="travellers">
								<c:if test="${travellers  ne null}">
									${travellers.age}
									<br>
								</c:if>
							</c:forEach>
						</td>
						<td><c:forEach items="${Reservations.travellers}" var="travellers">
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
					<c:if test="${Flight ne null}">
					<c:forEach items="${Flight}" var="flight">
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
