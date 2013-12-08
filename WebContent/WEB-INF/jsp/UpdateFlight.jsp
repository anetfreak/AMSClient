<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - Update Flight</title>

<%@include file="includes.jsp"%>
<script type = "text/javascript">
	function validateForm() {
		var airlineName = $('#airlineName').val();
		var flightId = $('#flightId').val();
		var flightNo = $('#flightNo').val();
		var source = $('#source').val();
		var destination = $('#destination').val();
		var time = $('#time').val();
		var seats = $('#seats').val();
		
		if((airlineName == null) || (airlineName == "") || (flightId == null) || (flightId == "") || (flightNo == null)
				|| (flightNo == "") || (source == null) || (source == "") || (destination == null) ||
					(destination == "") || (time == null) || (time == "") || (seats == null) || (seats == "")){
			alert("All fields should be filled!");
			return false;
		}
	}
</script>
</head>
<body>
	<%@include file="header.jsp"%>
		<div style = "padding: 30px;">
			<div>
				<span><h3>Update Flight</h3></span>
			</div>
			<div>
			<form name = "updateflightform" action = "" method = "post" onsubmit = "return validateForm()">
			<table>
				<tr>
					<td>Airlines Name : </td>
					<td><input type = "text" id = "airlineName" name = "airlineName" value="${flight.airlineName}"></td>
				</tr>
				<tr>
					<td>Flight ID : </td>
					<td><input type = "text" id = "flightId" name = "flightId" value="${flight.flightId}"></td>
				</tr>
				<tr>
					<td>Flight Number : </td>
					<td><input type = "text" id = "flightNo" name = "flightNo" value="${flight.flightNo}"></td>
				</tr>
				<tr>
					<td>Source Airport : </td>
					<td><select id = "source" name = "source">
							<option>--Select--</option>
							<!--<c:forEach items="${.journey}" var="travellers">
								<c:if test="${travellers  ne null}">
									<option>${travellers.travellerId}</option>
								</c:if>
							</c:forEach>-->
						</select>
					</td>
				</tr>
				<tr>
					<td>Destination Airport : </td>
					<td><select id="destination" name = "destination">
							<option>--Select--</option>
						 	<option>SFO</option>
						    <option>LAX</option>
						    <option>SJC</option>
						    <option>NEW</option>
						    <option>JFK</option>
						    <option>BOS</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Flight Time : </td>
					<td><input type = "text" id="time" name = "time" value="${flight.flightTime}"></td>
				</tr>
				<tr>
					<td>Number of Seats : </td>
					<td><input type = "text" id="seats" name = "seats" value="${flight.noOfSeats}"></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="btn btn-primary" type = "submit" name = "updateFlight" id = "updateFlight" value = "Update"></td>
				</tr>
			</table>
			</form>
		</div>
		</div>
	<%@include file="footer.jsp"%>
</body>
</html>