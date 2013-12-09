<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - Update Flight</title>

<%@include file="includes.jsp"%>

<script type="text/javascript">
	function validateForm() {
		var airlineName = $('#airlineName').val();
		var source = $('#source').val();
		var destination = $('#destination').val();
		var day = $('#day').val();
		var time = $('#time').val();
		var seats = $('#seats').val();
		var numbers = /^[0-9]+$/;
		var letters = /^[A-Za-z]+$/;
		//var timere = /^\d{1,2}:\d{2}([ap]m)?$/;
		var timere = /^([0-9]{2})\:([0-9]{2})$/;

		if ((airlineName == null) || (airlineName.trim() == '')) {
			alert("Please enter value for Airline Name");
			return false;
		}
		if ((source == null) || (source.trim() == '')) {
			alert("Please enter value for Source");
			return false;
		}
		if ((destination == null) || (destination.trim() == '')) {
			alert("Please enter value for Destination");
			return false;
		}
		if ((day == null) || (day.trim() == '')) {
			alert("Please enter values for Day");
			return false;
		}
		if ((time == null) || (time.trim() == '')) {
			alert("Please enter values for Time");
			return false;
		}
		if ((seats == null) || (seats.trim() == '')) {
			alert("Please enter value for Number of Seats");
			return false;
		}
		if (!airlineName.match(letters)) {
			alert("Not a valid airline name. Only alphabets allowed.");
			return false;
		}
		if (!seats.match(numbers)) {
			alert("Not a valid seat number. Only numbers allowed.");
			return false;
		}
		if (!time.match(timere)) {
			alert("Time is not in valid format.");
			return false;
		}
	};

	$(document).ready(function() {
						$('#updateFlight').click(function(e) {
								e.preventDefault();
											if (validateForm) {
												var flightId = $('#flightId').val();
												var airlineName = $('#airlineName').val();
												var flightNo = $('#flightNo').val();
												var source = $('#source').val();
												var destination = $('#destination').val();
												var day = $('#day').val();
												var time = $('#time').val();
												var seats = $('#seats').val();
												$
														.ajax({
															url : "/AMSClient/UpdateFlight.htm",
															type : "POST",
															data : "flightId="
																	+ flightId
																	+ "&airlineName="
																	+ airlineName
																	+ "&flightNo="
																	+ flightNo
																	+ "&source="
																	+ source
																	+ "&destination="
																	+ destination
																	+ "&day="
																	+ day
																	+ "&time="
																	+ time
																	+ "&seats="
																	+ seats,
															success : function(
																	data,
																	textStatus,
																	jqXHR) {
																alert("Inside Success..")
																$('#searchFlightError').css('display','none;');
																if (data.response == "success") {
 																	window.location.href = "ListFlight.htm";
																} else {
																	$('#loginError').css('display','block');
																}
															},

														});
											}
										});
					});
</script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="container" style="padding: 40px 0px 80px 0px;">
		<div class="container-fluid">
			<div id="loginError" class="alert alert-success alert-dismissable"
				style="display: none;">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				Flight Information updated successfully. Please view it <a
					href="ListFlight.htm">here</a>
			</div>
			<div style="padding: 30px;">
				<div>
					<span><h3>Update Flight Info</h3></span>
				</div>
				<div>
					<form name="updateflightform" method="post">
						<table>
							<tr>
								<td>Airlines Name :</td>
								<td><input type="text" id="airlineName" name="airlineName"
									value="${flight.airlineName}"></td>
							</tr>
							<tr>
								<td>Flight ID :</td>
								<td><input type="text" id="flightId" name="flightId"
									readonly value="${flight.flightId}"></td>
							</tr>
							<tr>
								<td>Flight Number :</td>
								<td><input type="text" id="flightNo" name="flightNo"
									readonly value="${flight.flightNo}"></td>
							</tr>
							<tr>
								<td>Source:</td>
								<td><c:if test="${locations ne null}">
										<select id="source">
											<c:forEach items="${locations}" var="loc">
												<option>${loc.airportCode}</option>
											</c:forEach>
										</select>
									</c:if></td>
							</tr>
							<tr>
								<td>Destination:</td>
								<td><c:if test="${locations ne null}">
										<select id="destination">
											<c:forEach items="${locations}" var="loc">
												<option>${loc.airportCode}</option>
											</c:forEach>
										</select>
									</c:if></td>
							</tr>
							<tr>
								<td>Number of Seats :</td>
								<td><input type="text" id="seats" name="seats"
									value="${flight.noOfSeats}"></td>
							</tr>
							<tr>
								<td>Flight Day :</td>
								<td><select name="day" id="day">
										<option value="mon" <c:if test="${day eq 'mon'}">selected="selected"</c:if>>Monday</option>
										<option value="tue" <c:if test="${day eq 'tue'}">selected="selected"</c:if>>Tuesday</option>
										<option value="wed" <c:if test="${day eq 'wed'}">selected="selected"</c:if>>Wednesday</option>
										<option value="thu" <c:if test="${day eq 'thu'}">selected="selected"</c:if>>Thursday</option>
										<option value="fri" <c:if test="${day eq 'fri'}">selected="selected"</c:if>>Friday</option>
										<option value="sat" <c:if test="${day eq 'sat'}">selected="selected"</c:if>>Saturday</option>
										<option value="sun" <c:if test="${day eq 'sun'}">selected="selected"</c:if>>Sunday</option>
								</select></td>
							</tr>
							<tr>
								<td>Flight Time (hh:mm):</td>
								<td><input type="text" id="time" name="seats"
									value="${time}"></td>
							</tr>
							<tr>
								<td><input class="btn btn-primary" type="submit"
									name="updateFlight" id="updateFlight" value="Update"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>