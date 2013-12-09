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
				
				<td><B>Reservation No</B></td>
				<td><B>Customer Id</B></td>
				<td><B>Reservation Status</B></td>
				<td><B>Seats Booked</B></td>
				<td><B>FlightId</B></td>
				<td><B>Source</B></td>
				<td><B>Destination</B></td>
				<td><B>Date-Time</B></td>
				<td><B>Traveller Id</B></td>
				<td><B>Traveller's First Name</B></td>
				<td><B>Traveller's Last Name</B></td>
				<td><B>Age</B></td>
				<td><B>Sex</B></td>
				
			</tr>
			<c:if test="${Reservations ne null}">
				<c:forEach items="${Reservations}" var="reservation">
					<tr>
						<c:if test="${reservation ne null}">
							<td><div class="col-sm-offset-2 col-sm-10">
									<a href="/AMSClient/cancelReservation/${Reservations.reservationId}.htm" class="btn btn-default" 
									id="cancelReservation" name="cancelReservation">Delete Employee</a>
								</div></td>
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
