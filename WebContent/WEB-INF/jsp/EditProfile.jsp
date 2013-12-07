<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS - Update Profile</title>

<%@include file="includes.jsp"%>

<script type="text/javascript">

	$(document).ready(function() {
		
		$('#departDate').datetimepicker({
		      pickTime: false
		});
		$('#returnDate').datetimepicker({
		      pickTime: false
		});
		
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
		
		var nullValueCheck = function() {
			var fname = $('#firstName');
			var lname = $('#lastName');
			var email = $('#email');
			var password = $('#password');
			var rePassword = $('#reEnterPassword');
			var address = $('#address');
			var city = $('#city');
			var state = $('#state');
			var pincode = $('#zipCode');
			var dobDate = $('#dob').data('datetimepicker');
			var dob = dobDate.getDate();
			var userType = $("input:radio[name=userTypeInput]:checked");
			var passport = $('#passport');
			var nationality = $('#nationality');
			var workdesc = $('#workDesc');
			var position = $('#position');
			var hiredatepick = $('#hireDate').data('datetimepicker');
			var hiredate = hiredatepick.getDate();
			var result = false;
			
			if(userType.val() == null || userType.val().trim() == '') {
				alert('Please enter user type.');				
			}
			else if(fname.val() == null || fname.val().trim() == '') {
				alert('Please enter your First Name.');
			}
			else if(lname.val() == null || lname.val().trim() == '') {
				alert('Please enter your Last Name.');
			}
			else if(email.val() == null || email.val().trim() == '') {
				alert('Please enter your email.');
			}
			else if(password.val() == null || password.val().trim() == '') {
				alert('Please enter your Password.');
			}
			else if(rePassword.val() == null || rePassword.val().trim() == '') {
				alert('Please re-enter your Password.');
			}
			else if(address.val() == null || address.val().trim() == '') {
				alert('Please enter your Address.');
			}
			else if(city.val() == null || city.val().trim() == '') {
				alert('Please enter City.');
			}
			else if(state.val() == null || state.val().trim() == '') {
				alert('Please enter State.');
			}
			else if(pincode.val() == null || pincode.val().trim() == '') {
				alert('Please enter ZipCode.');
			}
			else if(dob.val() == null || dob.val().trim() == '') {
				alert('Please enter your Date Of Birth.');
			}
			else if(userType.val() == 0 && (workdesc.val() == null || workdesc.val().trim() == '')) {
				alert('Please enter your Work Description.');
			}
			else if(userType.val() == 0 && (position.val() == null || position.val().trim() == '')) {
				alert('Please enter your Position.');
			}
			else if(userType.val() == 0 && (hiredate.val() == null || hiredate.val().trim() == '')) {
				alert('Please enter your Hire Date.');
			}
			else if (userType.val() == 1 && (passport.val() == null || passport.val().trim() == '')) {
				alert('Please enter your Passport Number.');
			}
			else if (userType.val() == 1 && (nationality.val() == null || nationality.val().trim() == '')) {
				alert('Please enter your Nationality.');
			}
			else {
				result = true;
			}
			return result;
		};
		
		var validateAlphabets = function(){
			var fname = $('#firstName');
			var lname = $('#lastName');
			var nationality = $('#nationality');
			var PATTERN = /^[a-zA-Z]+$/;
			var result = false;
			
			if(!PATTERN.test(fname.val())){
				alert('Please enter only alphabets in First Name');
			}
			else if(!PATTERN.test(lname.val())){
				alert('Please enter only alphabets in Last Name');
			}
			else if(!PATTERN.test(nationality.val())){
				alert('Please enter only alphabets in Nationality');
			}
			else
				result = true;
			
			return result;
		};
		
		var validEmail = function() {
			var email = $('#email');
			var EMAIL_PATTERN = /^([a-zA-Z0-9_\-\.]+([+])?[a-zA-Z0-9_\-\.]+)@((\[[0-2]{1}[0-5]{1}[0-5]{1}\.[0-2]{1}[0-5]{1}[0-5]{1}\.[0-2]{1}[0-5]{1}[0-5]{1}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-2]{1}[0-5]{1}[0-5]{1})(\]?)$/;
			var result = false;

		 if(!EMAIL_PATTERN.test(email.val())) {
				alert('Email is not in a valid format.');
				email.val('');
			} 
		 else {
				result = true;
			}
			return result;
		};
		
		var validPassword = function(){
			var password = $('#password');
			var rePassword = $('#reEnterPassword');
			var result = false;

			if(password.val().length < 8 || password.val().length > 12){
				alert('Password can be between 8 and 12 characters');
				password.val('');
			}
			else if(password.val() != rePassword.val()){
				alert('Passwords do not match');
			}
			else{
				result = true;
			}
			return result;			
		};
		
		var validateSSN = function(){
			var ssn = $('#ssn');
			var SSN_PATTERN = /^(?!000)([0-6]\d{2}|7([0-6]\d|7[012]))([ -]?)(?!00)\d\d\3(?!0000)\d{4}$/;
			var result = false;
			
			if(!SSN_PATTERN.test(ssn.val())) {
				alert('SSN is not in a valid format.');
				ssn.val('');
			} 
		 else {
				result = true;
			}
			return result;
		};
		
		var validateZip = function(){
			var zipCode = $('#zipCode');
			var ZIP_PATTERN = /^\d{5}(-\d{4})?$/;
			var result = false;
			
			if(!ZIP_PATTERN.test(zipCode.val())) {
				alert('Zip Code is not in a valid format.');
				zipCode.val('');
			} 
		 else {
				result = true;
			}
			return result;
		};
		
		
		$('#updateProfile').click(function(event) {
		if(nullValueCheck() && validateAlphabets() && validEmail() && validPassword() && validateSSN() && validateZip()) {
		var fname = $('#firstName').val();
		var lname = $('#lastName').val();
		var email = $('#email').val();
		var password = $('#password').val();
		var address = $('#address').val();
		var city = $('#city').val();
		var state = $('#state').val();
		var pincode = $('#zipCode').val();
		var dobDate = $('#dob').data('datetimepicker');
		var dob = dobDate.getDate();
		var passport = $('#passport').val();
		var nationality = $('#nationality').val();
		var workdesc = $('#workDesc').val();
		var position = $('#position').val();
		var hiredatepick = $('#hireDate').data('datetimepicker');
		var hiredate = hiredatepick.getDate();
		var userType = $("input:radio[name=userTypeInput]:checked").val();
		
		$.ajax({
			url : "EditProfile.htm",
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
		}
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
					<div class="tab-pane active" id="UserProfileUpdate">
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
											class="required" placeholder="Password" maxlength="12">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Re-enter Password</h5></td>
								<td><div class="input-group">
										<input type="password" id="reEnterPassword"
											name="reEnterPasswordInput" class="required"
											placeholder="Re-enter Password" maxlength="12">
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Social Security Number</h5></td>
								<td><div class="input-group">
										<input type="text" id="ssn" class="required" placeholder="SSN">
									</div></td>
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
								<td><div id="dob">
							    <input data-format="yyyy-MM-dd" type="text"></input>
							    <span class="add-on">
							      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
							      </i>
							    </span>
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
								<td><div id="hireDate">
							    <input data-format="yyyy-MM-dd" type="text"></input>
							    <span class="add-on">
							      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
							      </i>
							    </span>
							  </div></td>
							</tr>
							<!-- End Extra -->
							<tr></tr>
							<tr>
								<td></td>
								<td><div class="col-sm-offset-2 col-sm-10">
										<input type="submit" class="btn btn-default" id="updateProfile"
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