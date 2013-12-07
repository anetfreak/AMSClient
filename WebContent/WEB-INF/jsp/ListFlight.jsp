<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - List Flight</title>
</head>
<body>

	<div id="container" style="padding-top: 40px;" align="center">
		<table class="table table-bordered table-striped" border="1">
			<tr>
				<td><BR>Flight Id</td>
				<td><BR>Flight No.</td>
				<td><BR>Airline Name</td>
				<td><BR>Source</td>
				<td><BR>Destination</td>
				<td><BR>No. Of Seat</td>
				<td><BR>Flight Day</td>
				<td><BR>Flight Time</td>
			</tr>
			<c:if test="${arr_flights ne null}">
				<p>
					<b>In first if</b>
				</p>
				<c:forEach items="${arr_flights}" var="flight">
					<p>
						<b>In first for</b>
					</p>
					<tr>
						<c:if test="${flight ne null}">
							<p>
								<b>In second if</b>
							</p>
							<td>${flight.flightId}</td>
							<td>${flight.flightNo}</td>
							<td>${flight.airlineName}</td>
							<td>${flight.source}</td>
							<td>${flight.destination}</td>
							<td>${flight.noOfSeats}</td>

							<td><c:forEach items="${flight}" var="timing">
									<p>
										<b>In second for</b>
									</p>
									<c:if test="${timing  ne null}">
									${timing.flightDay}
									</c:if>
								</c:forEach>
							</td>

							<td><c:forEach items="${flight}" var="timing">
									<c:if test="${timing  ne null}">
									${timing.flightTime}
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

</body>
</html>
