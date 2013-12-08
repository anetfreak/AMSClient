<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS! - Search an Employee</title>
<%@include file="includes.jsp"%>
<script type="text/javascript">
		$(document).ready(function(){
			
			$('#departDate').datepicker();
			
			$('#btnSearchFlight').click(function(e){
				e.preventDefault();
				var source = $('#source').val();
				var destination = $('#destination').val();
				var departDate = $('#departDate').val();
				$.ajax({
					url : "SearchEmployee.htm",
				    type: "POST",
				    data : "source=" + source + "&destination=" + destination + "&departDate=" + departDate,
				    success:function(data, textStatus, jqXHR){
				    	$('#searchFlightError').css('display', 'none;');
				    },
				    error: function(jqXHR, textStatus, errorThrown){
				    	$('#searchFlightError').css('display', 'block');
// 				    	alert("Could not process request.. " + errorThrown);
				    }
				});
			});
		});
	</script>
</head>
<body>

	<%@include file="header.jsp"%>
	<div id="container" style="margin: 0px 0px 40px 0px;">
		<div class="container-fluid">
			<div id="searchFlightError"
				class="alert alert-error alert-dismissable" style="display: none;">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				No Employees found. Please try again.....
			</div>
			<div class="row-fluid">
				<div id="searchOptions" style="margin: 30px 0px 0px 0px;">
					<div>
						<span><h3>Search Employee</h3></span>
						<h5>First Name</h5>
						<div class="input-group">
							<input type="text" id="firstName" class="required"
								placeholder="First Name">
						</div>

						<h5>Last Name</h5>
						<div class="input-group">
							<input type="text" id="lastName" class="required"
								placeholder="Last Name">
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div id="employeeSearchResult">
					<c:if test="${flights ne null}">
						<table class="table table-bordered table-striped" border="1">
							<tr>
								<td><BR>SSN</td>
								<td><BR>First Name</td>
								<td><BR>Last Name</td>
								<td><BR>Email</td>
								<td><BR>Destination</td>
								<td><BR>No. Of Seat</td>
								<td><BR>Flight Day</td>
								<td><BR>Flight Time</td>
							</tr>
							<c:forEach items="${flights}" var="flight">
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
											</c:forEach></td>

										<td><c:forEach items="${flight.flightTime}" var="timing">
												<c:if test="${timing  ne null}">
												${timing.flightTime}
												<br>
												</c:if>
											</c:forEach></td>

									</c:if>
								</tr>
							</c:forEach>
							<tr>
							</tr>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>
