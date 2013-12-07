<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - Issue Ticket</title>

<%@include file="includes.jsp" %>

</head>
<body>
<%@include file="header.jsp" %>
	<div>
		<div style = "padding: 20px;">
			<div>
				<p><b><u>Itinerary and Reservation Details</u></b></p>
				<p><b>Reservation Id : abc123</b></p>
				<p><b>Reservation Number : 321cba</b></p>
			</div>
			<div style = "padding-top: 10px;">
				<p><b>Customer Info</b></p>
				<table border = "1">
					<tr style = "text-align: center;">
						<td style = "width: 250px;">
							<p><b>First Name</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Last Name</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Email</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Gender</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Address</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Nationality</b></p>
						</td>
					</tr>
					<tr style = "text-align: center;">
						<td>
							<p>Ameya</p>
						</td>
						<td>
							<p>Joshi</p>
						</td>
						<td>
							<p>ameyajoshi@gmail.com</p>
						</td>
						<td>
							<p>Male</p>
						</td>
						<td>
							<p>Pune, Maharashtra</p>
						</td>
						<td>
							<p>Indian</p>
						</td>
					</tr>
				</table>
			</div>
			<div style = "padding-top: 30px;">
				<p><b>Travellers' Info</b></p>
				<table border = "1">
					<tr style = "text-align:center;">
						<td style = "width: 250px;">
							<p><b>First Name</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Last Name</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Age</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Gender</b></p>
						</td>
					</tr>
					<tr style = "text-align:center;">
						<td>
							<p>Amit</p>
						</td>
						<td>
							<p>Agarwal</p>
						</td>
						<td>
							<p>26</p>
						</td>
						<td>
							<p>Male</p>
						</td>
					</tr>
					<tr style = "text-align:center;">
						<td>
							<p>Chitra</p>
						</td>
						<td>
							<p>Soni</p>
						</td>
						<td>
							<p>26</p>
						</td>
						<td>
							<p>Female</p>
						</td>
					</tr>
				</table>
			</div>
			<div style = "padding-top: 30px;">
				<p><b>Flight Info</b></p>
				<table border = "1">
					<tr style = "text-align:center;">
						<td style = "width: 250px;">
							<p><b>Departure</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Arrival</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Flight Number</b></p>
						</td>
						<td style = "width: 250px;">
							<p><b>Aircraft</b></p>
						</td>
					</tr>
					<tr style = "text-align:center;">
						<td>
							<p>SFO</p>
							<p>Fri,6 Dec 2013, 13:50hrs</p>
						</td>
						<td>
							<p>LAX</p>
							<p>Fri,6 Dec 2013, 15:50hrs</p>
						</td>
						<td>
							<p>CA666</p>
						</td>
						<td>
							<p>Airbus A380</p>
						</td>
					</tr>
					<tr style = "text-align:center;">
						<td>
							<p>LAX</p>
							<p>Sat,7 Dec 2013, 04:50hrs</p>
						</td>
						<td>
							<p>NY</p>
							<p>Sat,7 Dec 2013, 11:50hrs</p>
						</td>
						<td>
							<p>CA999</p>
						</td>
						<td>
							<p>Boieng 747</p>
						</td>
					</tr>
				</table>
			</div>
			<div>
				<%@include file="footer.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>
