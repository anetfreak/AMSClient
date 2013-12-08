<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - List Reservations</title>
<%@include file="includes.jsp" %>
</head>
<body>
	<%@include file="header.jsp" %>
	<div id="container" style="padding-top: 40px;" align="center">
		<table class="table table-bordered table-striped" border="1">
			<tr>
				<td><BR>Reservation Id</td>
				<td><BR>Reservation No</td>
				<td><BR>Customer Id</td>
				<td><BR>Reservation Status</td>
				<td><BR>Seats Booked</td>
				<td><BR>flightId</td>
				<td><BR>source</td>
				<td><BR>destination</td>
				<td><BR>dateTime</td>
				<td><BR>travellerId</td>
				<td><BR>firstName</td>
				<td><BR>lastName</td>
				<td><BR>age</td>
				<td><BR>sex</td>
				
			</tr>
			<c:if test="${Reservations ne null}">
				<c:forEach items="${Reservations}" var="reservation">
					<tr>
						<c:if test="${customer ne null}">
							<td>${reservation.reservationId}</td>
							<td>${reservation.reservationNo}</td>
							<td>${reservation.customerId}</td>
							<td>${reservation.reservationStatus}</td>
							<td>${reservation.seatsBooked}</td>
							<td><c:forEach items="${reservation.journey}" var="journey">
									<c:if test="${journey  ne null}">
									${journey.flightId}
									<br>
									</c:if>
								</c:forEach>
							</td>
							<td><c:forEach items="${reservation.journey}" var="journey">
									<c:if test="${journey  ne null}">
									${journey.source}
									<br>
									</c:if>
								</c:forEach>
							</td>
							<td><c:forEach items="${reservation.journey}" var="journey">
									<c:if test="${journey  ne null}">
									${journey.destination}
									<br>
									</c:if>
								</c:forEach>
							</td>
							<td><c:forEach items="${reservation.journey}" var="journey">
									<c:if test="${journey  ne null}">
									${journey.dateTime}
									<br>
									</c:if>
								</c:forEach>
							</td>
							
							<td><c:forEach items="${reservation.journey}" var="travellers">
									<c:if test="${travellers  ne null}">
									${travellers.travellerId}
									<br>
									</c:if>
								</c:forEach>
							</td>
							<td><c:forEach items="${reservation.journey}" var="travellers">
									<c:if test="${travellers  ne null}">
									${travellers.firstName}
									<br>
									</c:if>
								</c:forEach>
							</td>
							<td><c:forEach items="${reservation.journey}" var="travellers">
									<c:if test="${travellers  ne null}">
									${travellers.lastName}
									<br>
									</c:if>
								</c:forEach>
							</td>
							<td><c:forEach items="${reservation.journey}" var="travellers">
									<c:if test="${travellers  ne null}">
									${travellers.age}
									<br>
									</c:if>
								</c:forEach>
							</td>
							<td><c:forEach items="${reservation.journey}" var="travellers">
									<c:if test="${travellers  ne null}">
									${travellers.sex}
									<br>
									</c:if>
								</c:forEach>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</table>


	</div>
<%@include file="footer.jsp" %>
</body>
</html>
