<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - Update Flight</title>

<%@include file="includes.jsp"%>

<script type="text/javascript">

	function validateForm() {
		var airlineName = $('#airlineName').val();
		var flightNo = $('#flightNo').val();
		var source = $('#source').val();
		var destination = $('#destination').val();
		var day = $('#day').val();
		var time = $('#time').val();
		var seats = $('#seats').val();
		var result = false;

		if ((airlineName == null) || (airlineName == ""))
		{
			alert("Please enter value for Airline Name");
		}
		else if((flightNo == null) || (flightNo == "")){
			alert("Please enter value for Flight Number");
		}
		else if((source == null) || (source == "")){
			alert("Please enter value for Source");
		}
		else if ((destination == null) || (destination == "")){
			alert("Please enter value for Destination");
		} 
		else if ((day == null) || (day == "")){
			alert("Please enter values for Day");
		}
		else if ((time == null) || (time == "")){
			alert("Please enter values for Time");
		}
		else if((seats == null) || (seats == "")) {
			alert("Please enter value for Number of Seats");
		}
		else
			result = true;
		
		return result;
	};
	
	$(document).ready(function(){
		$('#updateFlight').click(function(e){
			if(validateForm){
			var flightId = $('#flightId').val();
			var airlineName = $('#airlineName').val();
			var flightNo = $('#flightNo').val();
			var source = $('#source').val();
			var destination = $('#destination').val();
			var day = $('#day').val();
			var time = $('#time').val();
			var seats = $('#seats').val();
			$.ajax({
				url : "UpdateFlight.htm",
			    type: "POST",
			    data : "flightId=" + flightId + "&airlineName" + airlineName + "&flightNo" + flightNo +
			    "&source" + source + "&destination" + destination + "&day" + day + "&time" + time +
			    "&seats" + seats,
			    success:function(data, textStatus, jqXHR){
			    	$('#searchFlightError').css('display', 'none;');
			    	if(data.response == "success") 
			    	{
			    		window.location.href="ListFlight.htm";
			    	} else 
			    	{
			    		$('#loginError').css('display', 'block');
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
					<form name="updateflightform" action="" method="post">
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
								<td>Source Airport :</td>
								<td><input type="text" id="source" name="source"
									value="${flight.source}"></td>
							</tr>
							<tr>
								<td>Destination Airport :</td>
								<td><input type="text" id="destination" name="destination"
									value="${flight.destination}"></td>
							</tr>
							<tr>
								<td>Number of Seats :</td>
								<td><input type="text" id="seats" name="seats"
									value="${flight.noOfSeats}"></td>
							</tr>
							<tr>
								<td>Flight Day :</td>
								<td><select name="day" id="day" value="${day}">
										<option value="">--Select--</option>
										<option value="mon">Monday</option>
										<option value="tue">Tuesday</option>
										<option value="wed">Wednesday</option>
										<option value="thu">Thursday</option>
										<option value="fri">Friday</option>
										<option value="sat">Saturday</option>
										<option value="sun">Sunday</option>
								</select></td>
							</tr>
							<tr>
								<td>Flight Time (hh:mm:ss):</td>
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