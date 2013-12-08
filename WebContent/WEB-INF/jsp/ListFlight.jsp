<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - List Flight</title>
<%@include file="includes.jsp" %>
</head>
<body>
	<%@include file="header.jsp" %>
	<div id="container" style="padding-top: 40px;" align="center">
		<table class="table table-bordered table-striped" border="1">
			<tr>
				<td><B>Flight Id</B></td>
				<td><B>Flight No.</B></td>
				<td><B>Airline Name</B></td>
				<td><B>Source</B></td>
				<td><B>Destination</B></td>
				<td><B>No. Of Seats</B></td>
				<td><B>Flight Day</B></td>
				<td><B>Flight Time</B></td>
			</tr>
			<c:if test="${arr_flights ne null}">
				<c:forEach items="${arr_flights}" var="flight">
					<tr>
						<c:if test="${flight ne null}">
							<td>${flight.flightId}</td>
							<td>${flight.flightNo}</td>
							<td>${flight.airlineName}</td>
							<td>${flight.source}</td>
							<td>${flight.destination}</td>
							<td>${flight.noOfSeats}</td>

							<td><c:forEach items="${flight.flightTime}" var="timing">
									<c:if test="${timing  ne null}">
									${timing.flightDay}
									<br>
									</c:if>
								</c:forEach>
							</td>

							<td><c:forEach items="${flight.flightTime}" var="timing">
									<c:if test="${timing  ne null}">
									${timing.flightTime}
									<br>
									</c:if>
								</c:forEach>
							</td>

						</c:if>
					</tr>
				</c:forEach>
			</c:if>

			<tr>
			</tr>
		</table>


	</div>
<%@include file="footer.jsp" %>
</body>
</html>
