<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS - Sign Up</title>

<%@include file="includes.jsp"%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#signup')
								.click(
										function(event) {

											var fname = $('#firstNameInput')
													.val();
											var lname = $('#lastNameInput')
													.val();
											var email = $('#emailInput').val();
											var password = $('#passwordInput')
													.val();
											var userType = $(
													"input:radio[name=userTypeInput]:checked")
													.val();

											$
													.ajax({
														url : "signup.htm",
														type : "POST",
														data : "fname=" + fname
																+ "&lname="
																+ lname
																+ "&email="
																+ email
																+ "&password="
																+ password
																+ "&userType="
																+ userType,
														success : function(
																data,
																textStatus,
																jqXHR) {
															window.location.href = "viewProjects.htm";
														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															alert("Could not process request.. "
																	+ errorThrown);
														}
													});
										});
					});
</script>

</head>
<body>
	<%@include file="header.jsp"%>


	<div id="container" style="padding-top: 40px;">
		<div class="container-fluid">
			<div class="row-fluid">
				<div id="sidebar" class="span2">
					<!--Sidebar content-->
					<ul id="sidebar-list" class="nav nav-list">
					</ul>
				</div>
				<div class="tab-content">
					<div class="tab-pane active" id="NewUserSignUp">
						<table>
							<!--Body content-->
							<tr>
								<td><h2>
										Create an AMS account here
										</h2></td>
							</tr>
							<tr>
								<td><h5>You are a</h5></td>
								<td><input name="userTypeInput" id="userTypeInputEmployee"
									type="radio" class="required" value="0">

									<h5>Employee</h5> </td>
								<td><input name="userTypeInput" id="userTypeInputCustomer"
									type="radio" class="required" value="1">
									<h5>Customer</h5></td>
							</tr>
							<tr>
								<td><h5>First Name</h5></td>
								<td><div class="input-group">
										<input type="text" id="firstNameInput" class="required"
											placeholder="First Name">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Last Name</h5></td>
								<td><div class="input-group">
										<input type="text" id="lastNameInput" class="required"
											placeholder="Last Name">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Email</h5></td>
								<td><div class="input-group">
										<input type="email" id="emailInput" class="required email"
											placeholder="Email ID">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Password</h5></td>
								<td><div class="input-group">
										<input type="password" id="passwordInput" name="passwordInput"
											class="required" placeholder="Password">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Re-enter Password</h5></td>
								<td><div class="input-group">
										<input type="password" id="reEnterPasswordInput"
											name="reEnterPasswordInput" class="required"
											placeholder="Re-enter Password"
											onChange="checkPasswordMatch();">
									</div></td>
								<td><div class="registrationFormAlert"
										id="divCheckPasswordMatch"></div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Address</h5></td>
								<td><div class="input-group">
										<input type="address" id="addressInput" class="required"
											placeholder="Address">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>City</h5></td>
								<td><div class="input-group">
										<input type="city" id="cityInput" class="required"
											placeholder="City">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>State</h5></td>
								<td><div class="input-group">
										<input type="state" id="stateInput" class="required"
											placeholder="State">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>PinCode</h5></td>
								<td><div class="input-group">
										<input type="zipCode" id="zipCode" class="required"
											placeholder="Zip Code">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Date Of Birth</h5></td>
								<td><div class="input-group">
										<input type="dob" id="dobInput" class="required"
											placeholder="DOB">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td></td>
								<td><div class="col-sm-offset-2 col-sm-10">
										<input type="submit" class="btn btn-default" id="signup"
											value="Sign Up" />
									</div></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="footer.jsp"%>

</body>
</html>