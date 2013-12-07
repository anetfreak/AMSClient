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
		});
	</script>
</head>
<body>
	
	<%@include file="header.jsp" %>
	<div id="container" style="margin: 0px 0px 40px 0px;">
		<div class="container-fluid">
			<div id="searchFlightError" class="alert alert-error alert-dismissable" style="display: none;">
			  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			  No FLights found. Please try again.
			</div>
			<div id="searchOptions" style="margin: 80px 0px 0px 300px;">
				<div class="span1"></div>
				<div class="span4">
					<div>
							<form class="form-horizontal">
								<span style="margin-left: 20px;"><h3>Search a Flight</h3></span>
							  <div class="control-group">
							    <label class="control-label" for="source">Source</label>
							    <div class="controls">
							      <input type="text" id="source" placeholder="Source">
							    </div>
							  </div>
							  <div class="control-group">
							    <label class="control-label" for="destination">Destination</label>
							    <div class="controls">
							      <input type="text" id="destination" placeholder="Destination">
							    </div>
							  </div>
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
							  <div class="control-group">
							    <div class="controls">
							      <button type="submit" class="btn">Search</button>
							    </div>
							  </div>
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp" %>
</body>
</html>