<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - Add Traveller</title>
<%@include file="includes.jsp"%>
<script type = "text/javascript">
	$(document).ready(function(){
		
		function validateForm() {
			var firstName1 = $('#firstName1').val();
			var lastName1 = $('#lastName1').val();
			var age1 = $('#age1').val();
			var gender1 = $('#gender1').val();
			var firstName2 = $('#firstName2').val();
			var lastName2 = $('#lastName2').val();
			var age2 = $('#age2').val();
			var gender2 = $('#gender2').val();
			var firstName3 = $('#firstName3').val();
			var lastName3 = $('#lastName3').val();
			var age3 = $('#age3').val();
			var gender3 = $('#gender3').val();
			
			var numbers = /^[0-9]+$/;
			var letters = /^[A-Za-z]+$/;
			
			if((firstName1 == "" || firstName1 == null) && (lastName1 == "" || lastName1 == null) && (age1 == "" || age1 == null) && (gender1 == "" || gender1 == null)
					&& (firstName2 == "" || firstName2 == null) && (lastName2 == "" || lastName2 == null) && (age2 == "" || age2 == null) && (gender2 == "" || gender2 == null)
					&& (firstName3 == "" || firstName3 == null) && (lastName3 == "" || lastName3 == null) && (age3 == "" || age3 == null) && (gender3 == "" || gender3 == null)) {
				alert("Please provide full information of atleast 1 traveller!");
				return false;
			}
			if((firstName1 != "" || lastName1 != "" || age1 != "" || gender1 != "") && (firstName1 == "" || lastName1 == "" || age1 == "" || gender1 == "")) {
				alert("Please fill in all the details for first traveller!")
				return false;
			}
			if((firstName2 != "" || lastName2 != "" || age2 != "" || gender2 != "") && (firstName2 == "" || lastName2 == "" || age2 == "" || gender2 == "")) {
				alert("Please fill in all the details for second traveller!")
				return false;
			}
			if((firstName3 != "" || lastName3 != "" || age3 != "" || gender3 != "") && (firstName3 == "" || lastName3 == "" || age3 == "" || gender3 == "")) {
				alert("Please fill in all the details for third traveller!")
				return false;
			}
			if(!firstName1.match(letters) && firstName1 != "") {
				alert("Not a valid first name for first traveller!");
				return false;
			}
			if(!lastName1.match(letters) && lastName1 != "") {
				alert("Not a valid last name for first traveller!");
				return false;
			}
			if(!age1.match(numbers) && age1 != "") {
				alert("Not a valid age for first traveller!");
				return false;
			}
			if(!firstName2.match(letters) && firstName2 != "") {
				alert("Not a valid first name for second traveller!");
				return false;
			}
			if(!lastName2.match(letters) && lastName2 != "") {
				alert("Not a valid last name for second traveller!");
				return false;
			}
			if(!age2.match(numbers) && age2 != "") {
				alert("Not a valid age for second traveller!");
				return false;
			}
			if(!firstName3.match(letters) && firstName3 != "") {
				alert("Not a valid first name for third traveller!");
				return false;
			}
			if(!lastName3.match(letters) && lastName3 != "") {
				alert("Not a valid last name for third traveller!");
				return false;
			}
			if(!age3.match(numbers) && age3 != "") {
				alert("Not a valid age for third traveller!");
				return false;
			}
		}
		
		$('#addTravellers').click(function(){
 			if(validateForm()) {
				
				var firstName1 = $('#firstName1').val();
				var lastName1 = $('#lastName1').val();
				var age1 = $('#age1').val();
				var gender1 = $('#gender1').val();
				var firstName2 = $('#firstName2').val();
				var lastName2 = $('#lastName2').val();
				var age2 = $('#age2').val();
				var gender2 = $('#gender2').val();
				var firstName3 = $('#firstName3').val();
				var lastName3 = $('#lastName3').val();
				var age3 = $('#age3').val();
				var gender3 = $('#gender3').val();
				
				$.ajax({
					url : "showPayment.htm",
				    type: "POST",
				    data : "fname1=" + firstName1 + "&lname1=" + lastName1 + "&age1=" + age1 + "&gender1=" + gender1
				    	+"&fname2=" + firstName2 + "&lname2=" + lastName2 + "&age2=" + age2 + "&gender2=" + gender2
				    	+"&fname3=" + firstName3 + "&lname3=" + lastName3 + "&age3=" + age3 + "&gender3=" + gender3,
				    success:function(data, textStatus, jqXHR){
				    	window.location.href = "showPayment.htm";
				    },
				    error: function(jqXHR, textStatus, errorThrown){
					    	alert("Could not process request.. " + errorThrown);
				    }
				});
 			}
		});
		
	});
	
</script>
</head>
<body>
<%@include file="header.jsp"%>
	<div style = "padding: 30px;">
		<div>
			<span><h3>Add Travellers</h3></span>
		</div>
		<div>
			<form name = "addTravellerform" action = "" method = "post" onsubmit = "return validateForm()">
				<table>
					<tr style = "text-align: center;">
						<td style = "width: 230px;"><b>First Name</b></td>
						<td style = "width: 230px;"><b>Last Name</b></td>
						<td style = "width: 230px;"><b>Age</b></td>
						<td style = "width: 230px;"><b>Gender</b></td>
					</tr>
					<tr>
						<td><input type = "text" name = "firstName1" id = "firstName1"></td>
						<td><input type = "text" name = "lastName1" id = "lastName1"></td>
						<td><input type = "text" name = "age1" id = "age1" maxlength = "2"></td>
						<td>
							<select name = "gender1" id = "gender1">
							<option value = "">--Select--</option>
							<option value = "Male">Male</option>
							<option value = "Female">Female</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><input type = "text" name = "firstName2" id = "firstName2"></td>
						<td><input type = "text" name = "lastName2" id = "lastName2"></td>
						<td><input type = "text" name = "age2" id = "age2" maxlegth = "2"></td>
						<td>
							<select name = "gender2" id = "gender2">
								<option value = "">--Select--</option>
								<option value = "Male">Male</option>
								<option value = "Female">Female</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><input type = "text" name = "firstName3" id = "firstName3"></td>
						<td><input type = "text" name = "lastName3" id = "lastName3"></td>
						<td><input type = "text" name = "age3" id = "age3" maxlength = "2"></td>
						<td>
							<select name = "gender3" id = "gender3">
								<option value = "">--Select--</option>
								<option value = "Male">Male</option>
								<option value = "Female">Female</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><input class="btn btn-primary" type="button" name="addTravellers" id="addTravellers" value="Submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
<%@include file="footer.jsp"%>
</body>
</html>