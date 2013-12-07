<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS - Sign Up</title>

<%@include file="includes.jsp"%>

<script type="text/javascript">

	$(document).ready(function() {
		
		$('input:radio[name=userTypeInput]').change(function() {
			var userType = $("input:radio[name=userTypeInput]:checked").val();
			if (userType == 0) {
				$('.customerExtra').css('display', 'none');
				$('.empExtra').css('display', 'block');
			} else {
				$('.empExtra').css('display', 'none');
				$('.customerExtra').css('display', 'block');
			}
		});
		
		$('#signup').click(function(event) {
		var fname = $('#firstName').val();
		var lname = $('#lastName').val();
		var email = $('#email').val();
		var password = $('#password').val();
		var address = $('#address').val();
		var city = $('#city').val();
		var state = $('#state').val();
		var pincode = $('#zipCode').val();
		var dob = $('#dob').val();
		var passport = $('#passport').val();
		var nationality = $('#nationality').val();
		var workdesc = $('#workDesc').val();
		var position = $('#position').val();
		var hiredate = $('hireDate').val();
		var userType = $("input:radio[name=userTypeInput]:checked").val();
		
		$.ajax({
			url : "signup.htm",
		    type: "POST",
		    data : "email=" + email + "&password=" + password + "&userType=" + userType + "&firstName=" +fname+ "&lastName=" +lname+ "&address=" +address+
		    "&city=" +city+ "&state=" +state+ "&pincode=" +pincode+ "&dob=" +dob+ "&passport=" +passport+ "&nationality=" +nationality+ "&workDesc=" +workdesc+
		    "&position=" +position+ "&hireDate=" +hiredate,
		    success:function(data, textStatus, jqXHR){
		    	$('#loginError').css('display', 'none;');
		    	if(data.response == "success") {
		    		window.location.href="/AMSClient/";
		    	} else {
		    		$('#loginError').css('display', 'block');
		    	}
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		    	$('#loginError').css('display', 'block');
		    }
		});
		});
		});
</script>

</head>
<body>
	<%@include file="header.jsp"%>


	<div id="container" style="padding: 40px 0px 80px 0px;">
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
								<td><h2>Create an AMS account here</h2></td>
							</tr>
							<tr>
								<td><h5>You are a</h5></td>
								<td><input name="userTypeInput" id="userTypeInputEmployee"
									type="radio" class="required" value="0">

									<h5>Employee</h5></td>
								<td><input name="userTypeInput" id="userTypeInputCustomer"
									type="radio" class="required" value="1">
									<h5>Customer</h5></td>
							</tr>
							<tr>
								<td><h5>First Name</h5></td>
								<td><div class="input-group">
										<input type="text" id="firstName" class="required"
											placeholder="First Name">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Last Name</h5></td>
								<td><div class="input-group">
										<input type="text" id="lastName" class="required"
											placeholder="Last Name">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Email</h5></td>
								<td><div class="input-group">
										<input type="email" id="email" class="required email"
											placeholder="Email ID">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Password</h5></td>
								<td><div class="input-group">
										<input type="password" id="password" name="passwordInput"
											class="required" placeholder="Password">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Re-enter Password</h5></td>
								<td><div class="input-group">
										<input type="password" id="reEnterPassword"
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
										<input type="text" id="address" class="required"
											placeholder="Address">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>City</h5></td>
								<td><div class="input-group">
										<input type="text" id="city" class="required"
											placeholder="City">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>State</h5></td>
								<td><div class="input-group">
										<input type="text" id="state" class="required"
											placeholder="State">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>PinCode</h5></td>
								<td><div class="input-group">
										<input type="text" id="zipCode" class="required"
											placeholder="Zip Code">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Date Of Birth</h5></td>
								<td><div class="input-group">
										<input type="text" id="dob" class="required" placeholder="DOB">
									</div></td>
							</tr>
							<!-- 							Extra Fields -->
							<tr class="customerExtra" style="display: none;"></tr>
							<tr class="customerExtra" style="display: none;">
								<td><h5>Passport Number</h5></td>
								<td></td>
								<td><div class="input-group">
										<input type="text" id="passport" class="required"
											placeholder="Passport Number">
									</div></td>
							</tr>
							<tr class="customerExtra" style="display: none;"></tr>
							<tr class="customerExtra" style="display: none;">
								<td><h5>Nationality</h5></td>
								<td></td>
								<td><div class="input-group">
										<input type="text" id="nationality" class="required"
											placeholder="Nationality">
									</div></td>
							</tr>
							<tr class="empExtra" style="display: none;"></tr>
							<tr class="empExtra" style="display: none;">
								<td><h5>Work Description</h5></td>
								<td></td>
								<td><div class="input-group">
										<input type="text" id="workDesc" class="required"
											placeholder="Work Description">
									</div></td>
							</tr>
							<tr class="empExtra" style="display: none;"></tr>
							<tr class="empExtra" style="display: none;">
								<td><h5>Position</h5></td>
								<td></td>
								<td><div class="input-group">
										<input type="text" id="position" class="required"
											placeholder="Position">
									</div></td>
							</tr>
							<tr class="empExtra" style="display: none;"></tr>
							<tr class="empExtra" style="display: none;">
								<td><h5>Hire Date</h5></td>
								<td><div class="input-group">
										<input type="text" id="hireDate" class="required"
											placeholder="Hire Date">
									</div></td>
							</tr>
							<!-- 							End Extra -->
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