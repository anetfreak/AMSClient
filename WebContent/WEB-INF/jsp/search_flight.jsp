<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>AMS! - Search a Flight</title>
	
	<%@include file="includes.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#departDate').datepicker();
			
			$('.flightIds').click(function(e) {
		        e.preventDefault();
		        var index = this.id;
// 		        alert(index);
		        var secondId = $('#'+index).val();
		        var firstId = $('#'+index-1).val();
// 		        alert(secondId + "" + firstId);
		    });
			
			$('#btnSearchFlight').click(function(e){
				e.preventDefault();
				var source = $('#source').val();
				var destination = $('#destination').val();
				var departDate = $('#departDate').val();
				$.ajax({
					url : "searchFlights.htm",
				    type: "POST",
				    data : "source=" + source + "&destination=" + destination + "&departDate=" + departDate,
				    success:function(data, textStatus, jqXHR){
				    	$('#searchFlightError').css('display', 'none;');
				    	$('#body').html(data);
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
<body id="body">
	
	<%@include file="header.jsp" %>
	<div id="container" style="margin: 0px 0px 40px 0px;">
		<div class="container-fluid">
			<div id="searchFlightError" class="alert alert-error alert-dismissable" style="display: none;">
			  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			  No Flights found. Please try again.....
			</div>
			<div class="row-fluid">
				<div id="searchOptions" style="margin: 30px 0px 0px 0px;">
					<div>
						<span><h3>Search Flight</h3></span>
						<form class="form-inline">
						  <span>Source: </span>
							<c:if test="${locations ne null}">
							  <select id="source">
							  	<c:forEach items="${locations}" var="loc">
								    <option value="${loc.airportCode}"><c:out value="${loc.airportCode}"/></option>
							    </c:forEach>
							  </select>
						  </c:if>
						  <span style="margin-left:10px;">Destination: </span>
							<c:if test="${locations ne null}">
							  <select id="destination">
							  	<c:forEach items="${locations}" var="loc">
								    <option>${loc.airportCode}</option>
							    </c:forEach>
							  </select>
						  </c:if>
						  <input id="departDate" size="16" type="text" readonly data-date-format="yyyy-mm-dd" placeholder="Departure Date">
					      <button type="submit" class="btn" id="btnSearchFlight">Search</button>
						</form>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div id="flightSearchResults">
					<c:choose>
					<c:when test="${flights ne null}">
					<table class="table table-bordered table-striped" border="1">
						<tr>
							<td><BR></td>
							<td><BR>Flight Id</td>
							<td><BR>Flight No.</td>
							<td><BR>Airline Name</td>
							<td><BR>Source</td>
							<td><BR>Destination</td>
							<td><BR>No. Of Seat</td>
							<td><BR>Flight Time</td>
						</tr>
							<c:forEach items="${flights}" var="flight" varStatus="flightCounter">
								<tr>
									<c:if test="${flight ne null}">
										<c:choose>
										<c:when test="${flightCounter.count % 2 == 0}">
											<td><input type="button" class="flightIds" id="${flightCounter}" value="Select Flight"/></td>
										</c:when>
										<c:otherwise>
											<td></td>
										</c:otherwise>
										</c:choose>
										<td id="${flightCounter}">${flight.flightId}</td>
										<td>${flight.flightNo}</td>
										<td>${flight.airlineName}</td>
										<td>${flight.source}</td>
										<td>${flight.destination}</td>
										<td>${flight.noOfSeats}</td>
			
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
						<tr>
						</tr>
					</table>
					</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp" %>
</body>
</html>
