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
				<td><BR>Flight Id</td>
				<td><BR>Flight No.</td>
				<td><BR>Airline Name</td>
				<td><BR>Source</td>
				<td><BR>Destination</td>
				<td><BR>No. Of Seat</td>
				<td><BR>Flight Day</td>
				<td><BR>Flight Time</td>
			</tr>
				<c:forEach items="${flights}" var="flight">
					<tr>
						<td>${flight.flightId}</td>
						<td>${flight.flightNo}</td>
						<td>${flight.airlineName}</td>
						<td>${flight.source}</td>
						<td>${flight.destination}</td>
						<td>${flight.noOfSeats}</td>
					</tr>
				</c:forEach>
			<tr>
			</tr>
		</table>


	</div>
<%@include file="footer.jsp" %>
</body>
</html>
