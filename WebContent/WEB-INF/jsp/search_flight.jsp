<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>AMS! - Search a Flight</title>
	<%@include file="includes.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#departDate').datetimepicker({
			      pickTime: false
			});
			$('#returnDate').datetimepicker({
			      pickTime: false
			});
			
			$('#btnSearchFlight').click(function(){
				var source = $('#source').val();
				var destination = $('#destination').val();
				var departPicker = $('#departDate').data('datetimepicker');
				var departDate = departPicker.getDate();
				var returnPicker = $('#returnDate').data('datetimepicker');
				var returnDate = returnPicker.getDate();
				
				$.ajax({
					url : "searchFlights.htm",
				    type: "POST",
				    data : "source=" + source + "&destination=" + destination + "&departDate=" + departDate + "&returnDate=" + returnDate,
				    success:function(data, textStatus, jqXHR){
				    	$('#searchFlightError').css('display', 'none;');
// 				    	if(data.response == "success") {
// 				    		window.location.href="/AMSClient/";
// 				    	} else {
// 				    		$('#loginError').css('display', 'block');
// 				    		$('#email').val('');
// 				    		$('#password').val('');
// 				    	}
				    },
				    error: function(jqXHR, textStatus, errorThrown){
				    	$('#searchFlightError').css('display', 'block');
				    	alert("Could not process request.. " + errorThrown);
				    }
				});
			});
		});
	</script>
</head>
<body>
	
	<%@include file="header.jsp" %>
	<div id="container" style="margin: 0px 0px 40px 0px;">
		<div class="container-fluid">
			<div id="searchFlightError" class="alert alert-error alert-dismissable" style="display: none;">
			  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			  No Flights found. Please try again.
			</div>
			<div id="searchOptions" style="margin: 30px 0px 0px 0px;">
				<div class="span6">
					<div>
						<span><h3>Search a Flight</h3></span>
						<form class="form-inline">
					      <input type="text" id="source" placeholder="Source">
					      <input type="text" id="destination" placeholder="Destination">
						  <div class="control-group">
						    <label class="control-label" for="departDate">Departure Date</label>
						      <div id="departDate">
							    <input data-format="yyyy-MM-dd" type="text"></input>
							    <span class="add-on">
							      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
							      </i>
							    </span>
							  </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="returnDate">Return Date</label>
						    <div id="returnDate">
							    <input data-format="yyyy-MM-dd" type="text"></input>
							    <span class="add-on">
							      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
							      </i>
							    </span>
							</div>	
						  </div>
					      <button type="submit" class="btn" id="btnSearchFlight">Search</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp" %>
</body>
</html>